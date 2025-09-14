package com.mobile.soccerleague.data.remote


import com.mobile.soccerleague.data.entity.response.MatchesResponse
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.entity.response.ResponseMessage
import com.mobile.soccerleague.presentation.components.currentDateFormatted
import com.mobile.soccerleague.presentation.components.currentDateSSubtracted
import io.ktor.client.HttpClient
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SLRepositoryImpl : SLRepository {

    private var baseUrl = "https://api.football-data.org/v4/"

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
        isLenient = true
        encodeDefaults = true
    }

    private lateinit var httpClient: HttpClient


    private fun initHttpClient() {

        httpClient = HttpClient {
            install(DefaultRequest) {
                headers {

                }
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 40000
                connectTimeoutMillis = 40000
                socketTimeoutMillis = 40000
            }
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    private fun ensureHttpClientInitialized() {
        if (!this::httpClient.isInitialized) {
            initHttpClient()
        }
    }

    private suspend inline fun <reified T : Any, reified R : Any> makeRequest(
        method: HttpMethod,
        endpoint: String,
        requestBody: R? = null,
        token: String? = TokenManager.getToken(),
        additionalHeaders: Map<String, String> = emptyMap(),
        urlParameters: Map<String, String> = emptyMap(),
        pathParameters: Map<String, String> = emptyMap(),
        onSuccess: (T) -> Unit,
        onFailure: (String) -> Unit,
        noinline onSpecialCase: (suspend (HttpResponse) -> Unit)? = null
    ) {
        try {
            ensureHttpClientInitialized()

            var resolvedEndpoint = endpoint
            pathParameters.forEach { (key, value) ->
                resolvedEndpoint = resolvedEndpoint.replace("{$key}", value)
            }

            val response: HttpResponse = httpClient.request {
                this.method = method
                url("$baseUrl$resolvedEndpoint")
                header("X-Auth-Token", "532232336f1c42df8a03887f431bf763")
                token?.let { header("Authorization", "Bearer $it") }
                additionalHeaders.forEach { (key, value) -> header(key, value) }
                urlParameters.forEach { (key, value) -> parameter(key, value) }

                requestBody?.let { body ->
                    val bodyText = json.encodeToString(body)
                    setBody(TextContent(bodyText, ContentType.Application.Json))
                }
            }
            handleResponse(response, onSuccess, onFailure, onSpecialCase)
        } catch (e: SocketTimeoutException) {
            onFailure(timeOutErrorMessage())
        } catch (e: IOException) {
            onFailure(internetErrorMessage())
        } catch (e: Exception) {
            onFailure("Unexpected error try again")
        }
    }

    // Centralized response handler
    private suspend inline fun <reified T : Any> handleResponse(
        response: HttpResponse,
        onSuccess: (T) -> Unit,
        onFailure: (String) -> Unit,
        noinline onSpecialCase: (suspend (HttpResponse) -> Unit)? = null
    ) {
        val rawBody = response.bodyAsText()
        when (response.status) {
            HttpStatusCode.OK, HttpStatusCode.Created -> {
                val responseObject = json.decodeFromString<T>(rawBody)
                onSuccess(responseObject)
            }

            HttpStatusCode.Accepted -> onSpecialCase?.invoke(response)
            HttpStatusCode.TooManyRequests -> onFailure(tooManyRequestErrorMessage())
            HttpStatusCode.ServiceUnavailable -> {
                try {
                    val errorResponse = json.decodeFromString<ResponseMessage>(rawBody)
                    onFailure(errorResponse.message)
                } catch (e: Exception) {
                    onFailure(rawBody.ifEmpty { "Service unavailable, please try again later" })
                }
            }

            else -> {
                try {
                    val errorResponse = json.decodeFromString<ResponseMessage>(rawBody)
                    onFailure(errorResponse.message)
                } catch (e: Exception) {
                    onFailure("Unexpected error: ${response.status.value} - $rawBody")
                }
            }
        }
    }

    override suspend fun getPlayerDetail(
        onSuccess: (response: PlayerResponse) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        makeRequest<PlayerResponse, Unit>(
            method = HttpMethod.Get,
            endpoint = "persons/44",
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

//    competitions={competitionIds}
//    ids={matchIds}
//    dateFrom={DATE}
//    dateTo={DATE}
//    status={STATUS}
//
//    /v4/competitions/{id}/matches dateFrom={DATE}dateTo={DATE}stage={STAGE}status={STATUS}matchday={MATCHDAY}group={GROUP}season={YEAR} Open




    override suspend fun getAllFootballMatches(
        onSuccess: (response: MatchesResponse) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        makeRequest<MatchesResponse, Unit>(
            method = HttpMethod.Get,
            endpoint = "competitions/2021/matches?dateFrom=${currentDateSSubtracted()}&dateTo=${currentDateFormatted()}",
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }


}

// Utility functions (unchanged)
private fun internetErrorMessage() = "Internet connection issue"
private fun timeOutErrorMessage() = "Request timed out"
private fun tooManyRequestErrorMessage() = "Too many requests"


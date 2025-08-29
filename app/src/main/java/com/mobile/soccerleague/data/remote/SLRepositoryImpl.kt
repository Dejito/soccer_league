package com.mobile.soccerleague.data.remote


import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.entity.response.ResponseMessage
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


//class SLRepositoryImpl : SLRepository {
//
//    private val json = Json {
//        ignoreUnknownKeys = true
//        explicitNulls = false
//        isLenient = true
//        encodeDefaults = true
//    }
//
//    private lateinit var httpClient: HttpClient
//
//    private suspend fun initHttpClient() {
//
//        httpClient = HttpClient {
//            install(DefaultRequest) {
//                headers {}
//            }
//            install(Logging) {
//                logger = Logger.SIMPLE
//                level = LogLevel.ALL
//            }
//            install(HttpTimeout) {
//                requestTimeoutMillis = 60000
//                connectTimeoutMillis = 60000
//                socketTimeoutMillis = 60000
//            }
//            install(ContentNegotiation) {
//                json(Json {
//                    prettyPrint = true
//                    isLenient = true
//                    ignoreUnknownKeys = true
//
//                })
//            }
//        }
//    }
//
//    private suspend fun ensureHttpClientInitialized() {
//        if (!this::httpClient.isInitialized) {
//            initHttpClient()
//        }
//    }
//
//    private suspend inline fun <reified T : Any, reified R : Any> makeRequest(
//        method: HttpMethod,
//        endpoint: String,
//        requestBody: R? = null,
//        additionalHeaders: Map<String, String> = emptyMap(),
//        urlParameters: Map<String, String> = emptyMap(),
//        pathParameters: Map<String, String> = emptyMap(),
//        onSuccess: (T) -> Unit,
//        onFailure: (String) -> Unit,
//        noinline onSpecialCase: (suspend (HttpResponse) -> Unit)? = null
//    ) {
//        try {
//            ensureHttpClientInitialized()
//
//            var resolvedEndpoint = endpoint
//            pathParameters.forEach { (key, value) ->
//                resolvedEndpoint = resolvedEndpoint.replace("{$key}", value)
//            }
//
//            val response: HttpResponse = httpClient.request {
//                this.method = method
//                url("https://api.football-data.org/v4/$resolvedEndpoint")
//                header("X-Auth-Token", "532232336f1c42df8a03887f431bf763")
//                additionalHeaders.forEach { (key, value) -> header(key, value) }
//                urlParameters.forEach { (key, value) -> parameter(key, value) }
//
//                requestBody?.let { body ->
//                    val bodyText = json.encodeToString(body)
//                    setBody(TextContent(bodyText, ContentType.Application.Json))
//                }
//            }
//            handleResponse(response, onSuccess, onFailure, onSpecialCase)
//        } catch (e: SocketTimeoutException) {
//            e.printStackTrace()
//            onFailure(internetErrorMessage())
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    // Centralized response handler
//    private suspend inline fun <reified T : Any> handleResponse(
//        response: HttpResponse,
//        onSuccess: (T) -> Unit,
//        onFailure: (String) -> Unit,
//        noinline onSpecialCase: (suspend (HttpResponse) -> Unit)? = null
//    ) {
//        val rawBody = response.bodyAsText()
//        when (response.status) {
//            HttpStatusCode.OK, HttpStatusCode.Created -> {
////                if (encryptedCommunication()) {
//                    handleSuccess(response, onSuccess, onFailure)
////                } else {
////                    val decryptedResponse = if (rawBody.startsWith("{") || rawBody.startsWith("[")) {
////                        rawBody
////                    } else {
////                        decryData(rawBody)
////                    }
////
////                    val responseObject = json.decodeFromString<T>(decryptedResponse)
////                    onSuccess(responseObject)
////                }
//            }
//
//            HttpStatusCode.Accepted -> onSpecialCase?.invoke(response)
//            HttpStatusCode.TooManyRequests -> onFailure(tooManyRequestErrorMessage())
//            HttpStatusCode.ServiceUnavailable -> {
//                try {
//                    val errorResponse = json.decodeFromString<ResponseMessage>(rawBody)
//                    onFailure(errorResponse.message)
//                } catch (e: Exception) {
//                    onFailure(rawBody.ifEmpty { "Service unavailable, please try again later" })
//                }
//            }
//            else -> {
//                try {
//                    val errorResponse = json.decodeFromString<ResponseMessage>(rawBody)
//                    onFailure(errorResponse.message)
//                } catch (e: Exception) {
//                    onFailure("Unexpected error: ${response.status.value} - $rawBody")
//                }
//            }
//        }
//    }
//
//
//
//
//// Utility functions (unchanged)
//private fun internetErrorMessage() = "Internet connection issue"
//private fun timeOutErrorMessage() = "Request timed out"
//private fun tooManyRequestErrorMessage() = "Too many requests"
//private fun checkIfProdIsPresent(message: String): String {
//    return when {
//        message.contains(
//            "prod",
//            ignoreCase = true
//        ) || message.contains(
//            "kegow-middleware-soidnv4kmq",
//            ignoreCase = true
//        ) -> "Unable to process request. Try again."
//
//        else -> "An unexpected error occurred. Please try again."
//    }
//}
//
//
//private suspend inline fun <reified T : Any> handleSuccess(
//    response: HttpResponse,
//    onSuccess: (T) -> Unit,
//    onFailure: (String) -> Unit
//) {
//    try {
//        val fetchResponse = response.bodyAsText()
//        val responseObject = json.decodeFromString<T>(fetchResponse)
//        onSuccess(responseObject)
//    } catch (e: Exception) {
//        onFailure("Failed to parse response")
//    }
//}
//
//    override suspend fun getAllFootballMatches(
//        onSuccess: (response: PlayerResponse) -> Unit,
//        onFailure: (error: String) -> Unit
//    ) {
//        makeRequest<PlayerResponse, Unit>(
//          method = HttpMethod.Get,
//            endpoint = "persons/44",
//            onSuccess = onSuccess,
//            onFailure = onFailure
//        )
//    }
//
//    //    override suspend fun loginUser(
////        loginReqBody: LoginReqBody,
////        onSuccess: (response: LoginResponse) -> Unit,
////        onFailure: (error: String) -> Unit
////    ) {
////        makeRequest<LoginResponse, LoginReqBody>(
////            method = HttpMethod.Post,
////            endpoint = "/login",
////            requestBody = loginReqBody,
////            onSuccess = onSuccess,
////            onFailure = onFailure
////        )
////    }
//
//
//
//}

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

//    private suspend fun currentLocation(): Location? = geoLocator.currentLocationOrNull()

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

    override suspend fun getAllFootballMatches(
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


}

// Utility functions (unchanged)
private fun internetErrorMessage() = "Internet connection issue"
private fun timeOutErrorMessage() = "Request timed out"
private fun tooManyRequestErrorMessage() = "Too many requests"


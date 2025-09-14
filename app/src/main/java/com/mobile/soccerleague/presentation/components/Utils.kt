package com.mobile.soccerleague.presentation.components

import android.content.Context
import android.widget.Toast
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun Context.displayToastMessage(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}



fun currentDateFormatted(): String {
    val tomorrow = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return tomorrow.format(formatter)
}

fun currentDateSSubtracted(): String {
    val tomorrow = LocalDate.now().plusDays(-2)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return tomorrow.format(formatter)
}
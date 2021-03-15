package br.com.concrete.composekmmmoviesapp.androidApp.util

import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

fun String.parseToDate(): Date? {
    return dateFormat.parse(this)
}

fun Date.getYearFromDate(): Int {
    val cal  = Calendar.getInstance(Locale.getDefault())
    cal.time = this

    return cal.get(Calendar.YEAR)
}
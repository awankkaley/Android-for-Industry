package com.eudekaproject.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.eudekaproject.R
import java.text.SimpleDateFormat
import java.util.*

fun TextView.formatList(item: String) {
    text = when (item) {
        "null" -> resources.getString(R.string.not_avail)
        else -> item.replace("[", "").replace("]", "")
    }
}

@SuppressLint("SimpleDateFormat")
fun TextView.formatDate(date: String) {
    if (date == "null") {
        text = resources.getString(R.string.not_avail)
    } else {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
        format.timeZone = TimeZone.getTimeZone("GMT")
        val dateTime: Date = format.parse(date)
        val newDateFormat = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.getDefault())
        text = newDateFormat.format(dateTime)
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
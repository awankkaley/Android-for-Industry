package com.eudekaproject.utils

import android.view.View
import android.widget.TextView
import com.eudekaproject.R

fun TextView.ipDomain(ip: String) {
    text = when (ip) {
        "null" -> resources.getString(R.string.not_avail)
        else -> ip.replace("[", "").replace("]", "")
    }
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
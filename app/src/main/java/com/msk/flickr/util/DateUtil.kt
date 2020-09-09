package com.msk.flickr.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private const val INPUT_FORMAT = "yyyy-MM-dd"
    private const val OUTPUT_FORMAT = "dd-MM-yyyy"
    private const val DELIMETER = "T"
    fun getFormattedDate(date: String): String {
        return try {
            val dateOnly = date.substringBefore(DELIMETER)
            val date = SimpleDateFormat(INPUT_FORMAT, Locale.ENGLISH).parse(dateOnly)
            SimpleDateFormat(OUTPUT_FORMAT, Locale.ENGLISH).format(date)
        } catch (e: Exception) {
            ""
        }
    }

}

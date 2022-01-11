package com.br.eventbysicreed.util

import android.content.Context
import android.content.Intent
import com.br.eventbysicreed.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


fun shareContent(title: String?, description: String?, context: Context) {
    val shareIntent = Intent(Intent.ACTION_SEND)

    shareIntent.type = "text/plain"

    shareIntent.putExtra(
        Intent.EXTRA_SUBJECT,
        title
    )

    shareIntent.putExtra(
        Intent.EXTRA_TEXT,
        description
    )

    context.startActivity(
        Intent.createChooser(
            shareIntent,
            context.getString(R.string.share_with)
        )
    )
}

fun formatDate(formatDate: Long): String? {
    formatDate?.let {
        return formatDate(Date(it), DateFormat.SHORT)
    }
}

fun formatDate(date: Date, formatPattern: Int): String? {
    val format = DateFormat.getDateInstance(formatPattern, Locale("pt", "BR"))
    return format.format(date) ?: null
}
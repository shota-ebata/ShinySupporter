package com.ebi_tarou.shinysupporter.infra.db.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeConverter {

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let {
            LocalDateTime.parse(it, dataTimeFormatter)
        }
    }

    @TypeConverter
    fun localToTimestamp(localDateTime: LocalDateTime?): String? {
        return localDateTime?.format(dataTimeFormatter)
    }

    companion object {
        private val dataTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    }
}
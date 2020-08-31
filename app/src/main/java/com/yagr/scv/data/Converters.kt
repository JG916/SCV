package com.yagr.scv.data

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken


class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toList(strings: String?): List<String>? =
            strings?.let {
                return Gson().fromJson(strings, object : TypeToken<List<String>>() {}.type)
            }


        @TypeConverter
        @JvmStatic
        fun fromList(strings: List<String>?): String? =
            strings?.let { return Gson().toJson(strings) }
    }
}
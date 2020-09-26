package com.bmk.daggerproject.util

import android.content.Context
import android.util.Log
import java.io.IOException

/**
 * Created by manish on 07/07/201820.
 */

object Utils {
    fun getAssetJsonData(context: Context): String? {
        var json: String
        try {
            val inputStream = context.assets.open("item.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        // print the data
        Log.i("data", json)
        return json
    }

}
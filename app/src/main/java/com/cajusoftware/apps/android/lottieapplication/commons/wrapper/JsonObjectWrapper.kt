package com.cajusoftware.apps.android.lottieapplication.commons.wrapper

import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject

class JsonObjectWrapper @Inject constructor() {

    fun createJson(params: MutableMap<String, Any>): JSONObject {
        val jsonObject = JSONObject()

        try {
            params.forEach { (key, value) ->
                jsonObject.put(key, value)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jsonObject
    }
}
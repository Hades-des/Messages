package com.example.messages

import android.content.Context
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.reflect.Method

class APIWorker(var applicationContext: Context) {
    private var volleyQueue = Volley.newRequestQueue(applicationContext)

    public fun makeGetRequest(
        url: String,
        callback: (String) -> Unit,
    ) {
        var request = object : StringRequest(
            Method.GET,
            url,
            Response.Listener(callback),
            Response.ErrorListener {
                Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
        }

        volleyQueue.add(request)
    }
}

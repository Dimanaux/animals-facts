package com.example.dimanaux.animals.facts.domain

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dimanaux.animals.facts.R

class AnimalFacts(private val animalTypes: List<AnimalType>, private val context: Context) {
    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private val url = "https://cat-fact.herokuapp.com/facts/random"

    fun anotherFact(callback: (String) -> Unit) {
        val stringRequest = StringRequest(
            Request.Method.GET,
            withParam("animal_type", animalTypes),
            Response.Listener<String> {
                callback.invoke(parseFactFromResponse(it))
            },
            Response.ErrorListener {
                callback.invoke(context.getString(R.string.poorConnectionErrorMessage))
            }
        )
        queue.add(stringRequest)
    }

    private fun parseFactFromResponse(response: String) =
        response.split(",\"")
            .find { it.startsWith("text\"") }
            ?.split(":", limit = 2)
            ?.get(1)
            ?.trim('"')
            ?.filter { it != '\\' }
            ?: "Fake fact"

    private fun withParam(name: String, value: List<AnimalType>) =
        "$url?$name=${value.joinToString(",")}"
}

package com.example.messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var buttonLoadMessages: Button
    private lateinit var textViewJson: TextView
    private lateinit var apiWorker: APIWorker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url = "var url = \"https://jsonplaceholder.typicode.com/posts\""
        
        apiWorker = ApiWorker(applicationContext)

        textViewJson = findViewById(R.id.textViewJson)

        buttonLoadMessages = findViewById(R.id.buttonLoadMessages)
        buttonLoadMessages.setOnClickListener {
            apiWorker.makeGetRequest(url,::updateTextViewJson)
        }
    }

    fun updateTextViewJson(data: String){
        textViewJson.text = data
    }


}
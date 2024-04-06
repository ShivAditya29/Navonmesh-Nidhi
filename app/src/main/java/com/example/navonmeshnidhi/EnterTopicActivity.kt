package com.example.navonmeshnidhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EnterTopicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_topic)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            // Get entered data
            val topicName = findViewById<EditText>(R.id.topicNameEditText).text.toString()
            val description = findViewById<EditText>(R.id.descriptionEditText).text.toString()

            // Pass data to next activity
            val intent = Intent(this, ViewTopicActivity::class.java)
            intent.putExtra("topicName", topicName)
            intent.putExtra("description", description)
            startActivity(intent)
        }
    }
}
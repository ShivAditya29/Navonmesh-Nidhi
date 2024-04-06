package com.example.navonmeshnidhi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.navonmeshnidhi.R
import com.google.firebase.database.*
import com.example.navonmeshnidhi.Topic


class ViewTopicActivity : AppCompatActivity() {

    // Initialize Firebase Database
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val reference: DatabaseReference = database.getReference("topics")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_topic)

        // Retrieve passed data
        val topicName = intent.getStringExtra("topicName")
        val description = intent.getStringExtra("description")

        // Display data
        val topicNameTextView = findViewById<TextView>(R.id.topicNameTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        topicNameTextView.text = "Topic Name: $topicName"
        descriptionTextView.text = "Description: $description"

        // Attach ValueEventListener to read data from Firebase
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Handle data change
                val topics = mutableListOf<Topic>()
                for (topicSnapshot in dataSnapshot.children) {
                    val topic = topicSnapshot.getValue(Topic::class.java)
                    topic?.let { topics.add(it) }
                }
                // Now you have the list of topics, you can display it in your activity
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle cancelled event or errors
            }
        })
    }
}

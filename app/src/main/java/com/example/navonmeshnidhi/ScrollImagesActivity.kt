package com.example.navonmeshnidhi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.navonmeshnidhi.R
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ScrollImagesActivity : AppCompatActivity() {

    // Initialize Firebase Database
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val reference: DatabaseReference = database.getReference("topics")

    // Map to store image descriptions
    private val imageDescriptions = mapOf(
        R.id.img1 to "Accessing experienced mentors can significantly enhance a startup chances of success.",
        R.id.img2 to "Illustrating the significance of adequate funding in driving business growth and innovation.",
        R.id.img3 to "The impact of professional guidance on steering a startup through challenges and setbacks.",
        R.id.img4 to "Providing a dynamic platform for aspiring entrepreneurs to connect and collaborate.",
        R.id.img5 to "Providing a diverse range of potential investors who are on the lookout for promising startup ventures.",
        R.id.img6 to "Opportunity to present groundbreaking business ideas to wider audience."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_images)

        // Initialize post idea button
        val postIdeaButton = findViewById<Button>(R.id.post_idea)
        postIdeaButton.setOnClickListener {
            // Call postTopic() when Post Idea button is clicked
            postTopic("Your Topic Name", "Your Topic Description")
            startActivity(Intent(this, EnterTopicActivity::class.java))
        }
        val viewIdeaButton = findViewById<Button>(R.id.view_idea)
        viewIdeaButton.setOnClickListener {

            startActivity(Intent(this, ViewTopicActivity::class.java))
        }
    }


    // Write topic data to Firebase Database
    private fun postTopic(topicName: String, description: String) {
        // Generate a unique key for the topic
        val topicId = reference.push().key ?: ""

        // Create a new topic object
        val topic = Topic(topicId, topicName, description)

        // Write the topic data to the database
        reference.child(topicId).setValue(topic)
            .addOnSuccessListener {
                // Data successfully written to Firebase
            }
            .addOnFailureListener { e ->
                // Error occurred while writing data
            }
    }

    fun onImageClick(view: android.view.View) {
        val intent = Intent(this, DescriptionActivity::class.java)
        val description = imageDescriptions[view.id] ?: "Default Description"
        val imageResource = when (view.id) {
            R.id.img1 -> R.drawable.mentor
            R.id.img2 -> R.drawable.finance
            R.id.img3 -> R.drawable.expert
            R.id.img4 -> R.drawable.connectinn
            R.id.img5 -> R.drawable.investor
            R.id.img6 -> R.drawable.virtpe
            else -> R.drawable.error // You can define a default image resource here
        }
        intent.putExtra("description", description)
        intent.putExtra("imageResource", imageResource)
        startActivity(intent)
    }
}

package com.example.navonmeshnidhi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DescriptionActivity : AppCompatActivity() {

    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val description = intent.getStringExtra("description")
        val imageResource = intent.getIntExtra("imageResource", 0)

        // Initialize descriptionTextView
        descriptionTextView = findViewById(R.id.descriptionTextView)

        // Set the background of the layout to the clicked image
        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)
        backgroundImageView.setImageResource(imageResource)

        descriptionTextView.text = description
    }
}

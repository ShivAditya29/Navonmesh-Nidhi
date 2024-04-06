package com.example.navonmeshnidhi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Find views by their IDs
        val edName: EditText = findViewById(R.id.edname)
        val edEmail: EditText = findViewById(R.id.edmail)
        val edPassword: EditText = findViewById(R.id.edPass)

        // Set click listener for sign-up button
        findViewById<Button>(R.id.register).setOnClickListener {
            val name = edName.text.toString().trim()
            val email = edEmail.text.toString().trim()
            val password = edPassword.text.toString().trim()

            // Check if any field is empty
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@SignUpActivity, "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Create user with email and password
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign-up success, update UI
                        Toast.makeText(
                            this@SignUpActivity,
                            "Sign-up successful",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Navigate to login activity
                        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                        // Finish sign up activity
                        finish()
                    } else {
                        // If sign-up fails, display a message to the user.
                        Toast.makeText(
                            this@SignUpActivity, "Sign-up failed: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        // Find the TextView for login
        val loginTextView: TextView = findViewById(R.id.insign)

        // Set click listener for the login TextView
        loginTextView.setOnClickListener {
            // Navigate to the login activity
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            // Finish sign up activity
            finish()
        }
    }
}

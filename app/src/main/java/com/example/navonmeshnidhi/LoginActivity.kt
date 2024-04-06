package com.example.navonmeshnidhi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Find views by their IDs
        val edEmail: EditText = findViewById(R.id.edmail2)
        val edPassword: EditText = findViewById(R.id.edPass2)
        val btnLogin: Button = findViewById(R.id.login)
        val btnSignUp: TextView = findViewById(R.id.upsign)

        // Set click listener for login button
        btnLogin.setOnClickListener {
            val email = edEmail.text.toString().trim()
            val password = edPassword.text.toString().trim()

            // Check if any field is empty
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@LoginActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Sign in with email and password
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign-in success, update UI with the signed-in user's information
                        Toast.makeText(this@LoginActivity, "Login successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, ScrollImagesActivity::class.java))
                        // Finish sign up activity
                        finish()
                    } else {
                        // If sign-in fails, display a message to the user.
                        Toast.makeText(
                            this@LoginActivity, "Authentication failed: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        // Set click listener for sign-up text view
        btnSignUp.setOnClickListener {
            // Navigate to the sign-up activity
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            // Finish login activity
            finish()
        }
    }
}

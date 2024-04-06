package com.example.navonmeshnidhi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.navonmeshnidhi.SignUpActivity

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        // Normal Handler is deprecated, so we have to change the code a little bit.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }, 1200) // 1200 is the delayed time in milliseconds.
    }
}

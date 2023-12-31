package com.example.intentactivity

import android.os.Bundle
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.intentactivity.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        with(binding) {

            //Clickable span to redirect to main activity
            val spannableString = android.text.SpannableString(textViewRedirectRegister.text)
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: android.view.View) {
                    val intentToMainActivity =
                        android.content.Intent(
                            this@LoginActivity,
                            MainActivity::class.java
                        )
                    startActivity(intentToMainActivity)
                }
            }
            spannableString.setSpan(clickableSpan, 12, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            textViewRedirectRegister.text = spannableString
            textViewRedirectRegister.movementMethod = LinkMovementMethod.getInstance()
        }

        setContentView(binding.root)
    }
}
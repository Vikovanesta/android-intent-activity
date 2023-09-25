package com.example.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spanned
import android.text.method.LinkMovementMethod
import com.example.intentactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            // Go to second activity
            btnRegister.setOnClickListener{
                val intentToHomeActivity =
                    Intent(
                        this@MainActivity,
                        HomeActivity::class.java
                    )
                // Pass data to second activity
                val username = editTextUsername.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()

                intentToHomeActivity.putExtra(EXTRA_USERNAME, username)
                intentToHomeActivity.putExtra(EXTRA_EMAIL, email)
                intentToHomeActivity.putExtra(EXTRA_PHONE, phone)

                startActivity(intentToHomeActivity)
            }

            // Make a clickable span
            val spannableString = android.text.SpannableString(textViewRedirectLogin.text)
            val clickableSpan = object : android.text.style.ClickableSpan() {
                override fun onClick(widget: android.view.View) {
                    val intentToLoginActivity =
                        Intent(
                            this@MainActivity,
                            LoginActivity::class.java
                        )
                    startActivity(intentToLoginActivity)
                }
            }
            spannableString.setSpan(clickableSpan, 25, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            textViewRedirectLogin.text = spannableString
            textViewRedirectLogin.movementMethod = LinkMovementMethod.getInstance()
        }

        setContentView(binding.root)
    }
}
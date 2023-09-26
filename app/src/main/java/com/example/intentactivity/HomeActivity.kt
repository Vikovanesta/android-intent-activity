package com.example.intentactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentactivity.MainActivity.Companion.EXTRA_EMAIL
import com.example.intentactivity.MainActivity.Companion.EXTRA_PHONE
import com.example.intentactivity.MainActivity.Companion.EXTRA_USERNAME
import com.example.intentactivity.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            textWelcome.text = "Welcome $username"
            textEmailActivated.text = "Your email ($email) has been activated"
            textPhoneRegistered.text = "Your phone ($phone) has been registered"
        }

        setContentView(binding.root)
    }
}
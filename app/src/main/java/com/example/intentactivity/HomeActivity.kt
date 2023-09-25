package com.example.intentactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentactivity.MainActivity.Companion.EXTRA_EMAIL
import com.example.intentactivity.MainActivity.Companion.EXTRA_PHONE
import com.example.intentactivity.MainActivity.Companion.EXTRA_USERNAME
import com.example.intentactivity.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val launcher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            //Should update UI

            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val username = data?.getStringExtra(EXTRA_USERNAME)
                val email = data?.getStringExtra(EXTRA_EMAIL)
                val phone = data?.getStringExtra(EXTRA_PHONE)

                binding.textWelcome.text = "Welcome $username"
                binding.textEmailActivated.text = "Your email ($email) has been activated"
                binding.textPhoneRegistered.text = "Your phone ($phone) has been registered"
            }
        }

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

//            btnToThird.setOnClickListener {
//                val intent = Intent(
//                    this@SecondActivity,
//                    ThirdActivity::class.java
//                ).apply { putExtra(EXTRA_NAME, name) }
//                launcher.launch(intent)
//            }

        }

        setContentView(binding.root)
    }
}
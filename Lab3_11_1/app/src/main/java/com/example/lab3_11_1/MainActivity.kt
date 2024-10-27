package com.example.lab3_11_1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.emailField)
        val phoneField = findViewById<EditText>(R.id.phoneField)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val validationResult = findViewById<TextView>(R.id.validationResult)

        submitButton.setOnClickListener {
            val email = emailField.text.toString()
            val phone = phoneField.text.toString()
            if (validateEmail(email) && validatePhone(phone)) {
                validationResult.text = "Email và số điện thoại hợp lệ!"
            } else {
                validationResult.text = "Lỗi: Email hoặc số điện thoại không hợp lệ!"
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePhone(phone: String): Boolean {
        return phone.matches("\\d+".toRegex())
    }
}

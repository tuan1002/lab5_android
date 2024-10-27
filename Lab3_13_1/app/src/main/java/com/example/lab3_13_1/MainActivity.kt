package com.example.lab3_13_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextNumber)
        val button = findViewById<Button>(R.id.buttonCheck)
        val textView = findViewById<TextView>(R.id.textViewResult)

        button.setOnClickListener {
            val number = editText.text.toString().toIntOrNull()
            if (number != null) {
                if (number % 2 == 0) {
                    textView.text = "Even Number"
                } else {
                    textView.text = "Odd Number"
                }
            } else {
                textView.text = "Invalid Input"
            }
        }
    }
}


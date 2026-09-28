package com.example.adventuretime

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adventuretime.R

class ContactUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etGroupType = findViewById<EditText>(R.id.etGroupType)
        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnSendMessage = findViewById<Button>(R.id.btnSendMessage)

        btnSendMessage.setOnClickListener {
            val name = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val message = etMessage.text.toString().trim()

            // Input Validation
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thank you, $name! Message sent successfully.", Toast.LENGTH_LONG).show()

                // Clear input fields
                etFullName.text.clear()
                etEmail.text.clear()
                etPhone.text.clear()
                etGroupType.text.clear()
                etMessage.text.clear()
            }
        }
    }
}
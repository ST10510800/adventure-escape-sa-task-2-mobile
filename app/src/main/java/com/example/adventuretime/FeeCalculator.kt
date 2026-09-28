package com.example.adventuretime

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adventuretime.R

class FeeCalculatorActivity : AppCompatActivity() {

    private var basePricePerPerson = 750

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fee_calculator)

        val btnBack = findViewById<TextView>(R.id.btnBack)
        val tvSelectedActivity = findViewById<TextView>(R.id.tvSelectedActivity)
        val etGuests = findViewById<EditText>(R.id.etGuests)
        val cbEquipment = findViewById<CheckBox>(R.id.cbEquipment)
        val cbLunch = findViewById<CheckBox>(R.id.cbLunch)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnConfirmBooking = findViewById<Button>(R.id.btnConfirmBooking)

        val tvBasePrice = findViewById<TextView>(R.id.tvBasePrice)
        val tvExtrasCost = findViewById<TextView>(R.id.tvExtrasCost)
        val tvDiscount = findViewById<TextView>(R.id.tvDiscount)
        val tvTotalAmount = findViewById<TextView>(R.id.tvTotalAmount)

        btnBack.setOnClickListener {
            finish()
        }

        // Receive activity name from DetailActivity
        val activityName = intent.getStringExtra("SELECTED_ACTIVITY") ?: "Activity"
        tvSelectedActivity.text = activityName

        // Determine base price based on activity package
        basePricePerPerson = when (activityName) {
            "Mountain Adventure Package",
            "Family Explorer Package",
            "Corporate Team Challenge",
            "Ultimate Adventure Day" -> 1500
            else -> 750
        }

        btnCalculate.setOnClickListener {
            val guestsText = etGuests.text.toString().trim()

            if (guestsText.isEmpty() || guestsText.toIntOrNull() == null || guestsText.toInt() <= 0) {
                Toast.makeText(this, "Please enter a valid number of guests", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guestCount = guestsText.toInt()
            val rawBaseTotal = basePricePerPerson * guestCount

            // Calculate extras per guest
            var extraPerGuest = 0
            if (cbEquipment.isChecked) extraPerGuest += 150
            if (cbLunch.isChecked) extraPerGuest += 200
            val totalExtras = extraPerGuest * guestCount

            val subtotal = rawBaseTotal + totalExtras

            // Apply 10% discount for group size >= 5
            var discount = 0.0
            if (guestCount >= 5) {
                discount = subtotal * 0.10
            }

            val finalTotal = subtotal - discount

            // Display breakdown
            tvBasePrice.text = "Base Rate ($guestCount guests @ R$basePricePerPerson): R$rawBaseTotal"
            tvExtrasCost.text = "Extras: R$totalExtras"
            tvDiscount.text = "Group Discount (10%): -R${String.format("%.2f", discount)}"
            tvTotalAmount.text = "TOTAL: R${String.format("%.2f", finalTotal)}"
        }

        btnConfirmBooking.setOnClickListener {
            Toast.makeText(this, "Booking Confirmed for $activityName!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
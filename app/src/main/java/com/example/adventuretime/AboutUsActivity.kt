package com.example.adventuretime

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adventuretime.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_overview

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_overview -> true
                R.id.nav_calculator -> {
                    // Linked when FeeCalculatorActivity is created
                    true
                }
                R.id.nav_contacts -> {
                    // Linked when ContactUsActivity is created
                    true
                }
                else -> false
            }
        }
    }
}
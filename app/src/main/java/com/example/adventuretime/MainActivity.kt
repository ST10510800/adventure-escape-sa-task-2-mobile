package com.example.adventuretime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val btnBookUltimate = findViewById<Button>(R.id.btnBookUltimate)
        val btnBookZipline = findViewById<Button>(R.id.btnBookZipline)

        // Select 'home' tab by default
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_overview -> {
                    startActivity(Intent(this, OverviewActivity::class.java))
                    true
                }
                R.id.nav_calculator -> {
                    startActivity(Intent(this, FeeCalculatorActivity::class.java))
                    true
                }
                R.id.nav_contacts -> {
                    startActivity(Intent(this, ContactUsActivity::class.java))
                    true
                }
                else -> false
            }
        }

        btnBookUltimate.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ACTIVITY_NAME", "Ultimate Adventure Day")
            startActivity(intent)
        }

        btnBookZipline.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ACTIVITY_NAME", "Ziplining Adventure")
            startActivity(intent)
        }
    }
}
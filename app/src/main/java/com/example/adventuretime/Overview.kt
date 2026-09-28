package com.example.adventuretime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.adventuretime.R

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        // Card Container Click Listeners
        findViewById<LinearLayout>(R.id.cardZiplining).setOnClickListener { openDetailScreen("Ziplining Adventure") }
        findViewById<LinearLayout>(R.id.cardRockClimbing).setOnClickListener { openDetailScreen("Rock Climbing Session") }
        findViewById<LinearLayout>(R.id.cardMountainAdventure).setOnClickListener { openDetailScreen("Mountain Adventure Package") }
        findViewById<LinearLayout>(R.id.cardFamilyExplorer).setOnClickListener { openDetailScreen("Family Explorer Package") }
        findViewById<LinearLayout>(R.id.cardKayakingExperience).setOnClickListener { openDetailScreen("Kayaking Experience") }
        findViewById<LinearLayout>(R.id.cardCorporateChallenge).setOnClickListener { openDetailScreen("Corporate Team Challenge") }
        findViewById<LinearLayout>(R.id.cardUltimateAdventure).setOnClickListener { openDetailScreen("Ultimate Adventure Day") }

        // Button Click Listeners
        findViewById<Button>(R.id.btnBookZiplining).setOnClickListener { openDetailScreen("Ziplining Adventure") }
        findViewById<Button>(R.id.btnBookRockClimbing).setOnClickListener { openDetailScreen("Rock Climbing Session") }
        findViewById<Button>(R.id.btnBookMountainAdventure).setOnClickListener { openDetailScreen("Mountain Adventure Package") }
        findViewById<Button>(R.id.btnBookFamilyExplorer).setOnClickListener { openDetailScreen("Family Explorer Package") }
        findViewById<Button>(R.id.btnBookKayaking).setOnClickListener { openDetailScreen("Kayaking Experience") }
        findViewById<Button>(R.id.btnBookCorporate).setOnClickListener { openDetailScreen("Corporate Team Challenge") }
        findViewById<Button>(R.id.btnBookUltimate).setOnClickListener { openDetailScreen("Ultimate Adventure Day") }
    }

    private fun openDetailScreen(activityName: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("SELECTED_ACTIVITY", activityName)
        startActivity(intent)
    }
}
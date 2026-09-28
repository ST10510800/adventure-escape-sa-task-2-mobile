package com.example.adventuretime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.adventuretime.R

data class ActivityItem(
    val title: String,
    val imageResId: Int,
    val rating: String,
    val duration: String,
    val minAge: String,
    val difficulty: String,
    val includes: String,
    val details: String,
    val price: String
)

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnBack = findViewById<TextView>(R.id.btnBack)
        val tvDetailTitle = findViewById<TextView>(R.id.tvDetailTitle)
        val imgDetailImage = findViewById<ImageView>(R.id.imgDetailImage)
        val tvRating = findViewById<TextView>(R.id.tvRating)
        val tvDuration = findViewById<TextView>(R.id.tvDuration)
        val tvMinAge = findViewById<TextView>(R.id.tvMinAge)
        val tvDifficulty = findViewById<TextView>(R.id.tvDifficulty)
        val tvIncludesList = findViewById<TextView>(R.id.tvIncludesList)
        val tvDetailsDescription = findViewById<TextView>(R.id.tvDetailsDescription)
        val tvStartingPrice = findViewById<TextView>(R.id.tvStartingPrice)
        val btnBookNow = findViewById<Button>(R.id.btnBookNow)

        btnBack.setOnClickListener {
            finish() // Navigates back to Overview screen
        }

        // Get the selected activity name passed from OverviewActivity
        val selectedActivityName = intent.getStringExtra("SELECTED_ACTIVITY") ?: "Ziplining Adventure"

        // Load data for all 7 activities
        val activityData = getActivityDetails(selectedActivityName)

        // Populate Views
        tvDetailTitle.text = activityData.title
        imgDetailImage.setImageResource(activityData.imageResId)
        tvRating.text = activityData.rating
        tvDuration.text = "⏱ " + activityData.duration
        tvMinAge.text = "👶 Min age: " + activityData.minAge
        tvDifficulty.text = "📊 " + activityData.difficulty
        tvIncludesList.text = activityData.includes
        tvDetailsDescription.text = activityData.details
        tvStartingPrice.text = "Starting from " + activityData.price

        btnBookNow.setOnClickListener {
            val intent = Intent(this, FeeCalculatorActivity::class.java)
            intent.putExtra("SELECTED_ACTIVITY", activityData.title)
            startActivity(intent)
        }
    }

    private fun getActivityDetails(name: String): ActivityItem {
        return when (name) {
            "Ziplining Adventure" -> ActivityItem(
                title = "Ziplining Adventure",
                imageResId = R.drawable.img_ziplining,
                rating = "★ 4.8 (120 reviews)",
                duration = "2-3 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Safety Briefing\nEquipment hires\nProfessional Instructors",
                details = "Experience breathtaking views while ziplining through the forest.",
                price = "R750"
            )
            "Rock Climbing Session" -> ActivityItem(
                title = "Rock Climbing Session",
                imageResId = R.drawable.img_rock_climbing,
                rating = "★ 4.9 (111 reviews)",
                duration = "2-3 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Climbing equipment\nSafety instruction\nProfessional guide",
                details = "Learn Climbing techniques on natural rock faces.",
                price = "R750"
            )
            "Mountain Adventure Package" -> ActivityItem(
                title = "Mountain Adventure Package",
                imageResId = R.drawable.img_mountain_adventure,
                rating = "★ 4.3 (92 reviews)",
                duration = "3-4 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Mountain hiking\nScenic viewpoints\nRock scrambling\nSafety equipment",
                details = "A guided mountain adventure for outdoor enthusiasts.",
                price = "R1500"
            )
            "Family Explorer Package" -> ActivityItem(
                title = "Family Explorer Package",
                imageResId = R.drawable.img_family_explorer,
                rating = "★ 5.0 (102 reviews)",
                duration = "6-8 hours",
                minAge = "7+",
                difficulty = "Moderate",
                includes = "Nature walk\nObstacle course\nPicnic area\nFamily games",
                details = "A fun-filled outdoor experience designed for families.",
                price = "R1500"
            )
            "Kayaking Experience" -> ActivityItem(
                title = "Kayaking Experience",
                imageResId = R.drawable.img_kayaking_experience,
                rating = "★ 4.9 (130 reviews)",
                duration = "2-3 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Kayak and paddle\nSafety equipment\nGuided route",
                details = "Paddle through scenic rivers and lakes.",
                price = "R750"
            )
            "Corporate Team Challenge" -> ActivityItem(
                title = "Corporate Team Challenge",
                imageResId = R.drawable.img_corporate_challenge,
                rating = "★ 4.4 (88 reviews)",
                duration = "4-5 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Team obstacle course\nOrienteering challenge\nRaft-building activity\nTeam awards",
                details = "Team-building activities designed for businesses and organisations.",
                price = "R1500"
            )
            "Ultimate Adventure Day" -> ActivityItem(
                title = "Ultimate Adventure Day",
                imageResId = R.drawable.img_ultimate_adventure,
                rating = "★ 5.0 (155 reviews)",
                duration = "8-10 hours",
                minAge = "11+",
                difficulty = "Moderate",
                includes = "Guided hiking trail\nZiplining\nKayaking\nSafety briefing and equipment",
                details = "A full-day outdoor adventure featuring multiple exciting activities.",
                price = "R1500"
            )
            else -> getActivityDetails("Ziplining Adventure")
        }
    }
}
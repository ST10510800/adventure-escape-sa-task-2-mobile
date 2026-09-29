# Adventure Escape SA 🌄📱

A native Android application built using **Kotlin** and **XML** designed for exploring and booking outdoor adventures across South Africa. The app allows users to view curated activities, dynamic tour details, calculate group package fees with automatic discounts, and contact support directly.

---

## 🚀 Features

* **Home Dashboard:** Clean hero section, brand logo, action bar navigation, and highlighted adventure cards.
* **Activity Catalog (Overview):** Browse through all 7 outdoor activity offerings.
* **Dynamic Activity Details:** View activity descriptions, duration, pricing, and prerequisites powered by dynamic Kotlin Intents.
* **Group Fee Calculator:** Interactive total cost calculator with automatic group discount tiers (e.g., up to 15% savings for multiple bookings or large groups).
* **Contact & Support:** Quick access screen to reach out for inquiries or custom booking requests.
* **Unified Navigation:** Google Material Design `BottomNavigationView` for seamless screen transitions.

---

## 🛠️ Tech Stack & Specifications

* **Language:** Kotlin
* **UI Markup:** Android XML (`RelativeLayout`, `LinearLayout`, `ScrollView`, `FrameLayout`)
* **Architecture:** Multi-Activity layout (`MainActivity`, `OverviewActivity`, `DetailActivity`, `FeeCalculatorActivity`, `ContactUsActivity`)
* **Components:** Google Material Design Components
* **Build System:** Gradle (Kotlin DSL `build.gradle.kts` & `libs.versions.toml`)
* **Target Device / Min SDK:** Tested on physical device (`Samsung SM-A145F` / Android 14+)

---

## 📁 Project Structure

```text
app/src/main/
├── java/com/example/adventuretime/
│   ├── MainActivity.kt          # Home screen & bottom nav handling
│   ├── OverviewActivity.kt      # Catalog of all activities
│   ├── DetailActivity.kt        # Dynamic activity details view
│   ├── FeeCalculatorActivity.kt # Interactive fee calculation engine
│   └── ContactUsActivity.kt     # Contact & support page
└── res/
    ├── drawable/                # App drawables (hero_landscape, ic_tree_logo, etc.)
    ├── layout/                  # Screen XML layout files
    └── menu/
        └── bottom_nav_menu.xml  # Bottom navigation menu definition

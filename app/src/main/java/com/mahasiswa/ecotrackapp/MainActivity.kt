package com.mahasiswa.ecotrackapp

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var navHome: LinearLayout
    private lateinit var navMap: LinearLayout
    private lateinit var navReport: LinearLayout
    private lateinit var navHistory: LinearLayout
    private lateinit var navProfile: LinearLayout

    private lateinit var ivHome: ImageView
    private lateinit var ivMap: ImageView
    private lateinit var ivHistory: ImageView
    private lateinit var ivProfile: ImageView

    private lateinit var lblHome: TextView
    private lateinit var lblMap: TextView
    private lateinit var lblReport: TextView
    private lateinit var lblHistory: TextView
    private lateinit var lblProfile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Only apply bottom padding for the navigation bar area
            v.setPadding(0, 0, 0, systemBars.bottom)
            insets
        }

        initNavigation()
        
        if (savedInstanceState == null) {
            selectTab(R.id.nav_home)
        }
    }

    private fun initNavigation() {
        navHome = findViewById(R.id.nav_home)
        navMap = findViewById(R.id.nav_map)
        navReport = findViewById(R.id.nav_report)
        navHistory = findViewById(R.id.nav_history)
        navProfile = findViewById(R.id.nav_profile)

        ivHome = findViewById(R.id.iv_home)
        ivMap = findViewById(R.id.iv_map)
        ivHistory = findViewById(R.id.iv_history)
        ivProfile = findViewById(R.id.iv_profile)

        lblHome = findViewById(R.id.lbl_home)
        lblMap = findViewById(R.id.lbl_map)
        lblReport = findViewById(R.id.lbl_report)
        lblHistory = findViewById(R.id.lbl_history)
        lblProfile = findViewById(R.id.lbl_profile)

        navHome.setOnClickListener { selectTab(it.id) }
        navMap.setOnClickListener { selectTab(it.id) }
        navReport.setOnClickListener { 
            startActivity(Intent(this, ReportActivity::class.java))
        }
        navHistory.setOnClickListener { selectTab(it.id) }
        navProfile.setOnClickListener { selectTab(it.id) }
    }

    private fun selectTab(id: Int) {
        val inactiveTint = getColor(R.color.gray4)
        val activeTint = getColor(R.color.g2)

        // Reset text colors
        lblHome.setTextColor(inactiveTint)
        lblMap.setTextColor(inactiveTint)
        lblReport.setTextColor(inactiveTint)
        lblHistory.setTextColor(inactiveTint)
        lblProfile.setTextColor(inactiveTint)

        // Set iOS style icons
        ivHome.setImageResource(R.drawable.ic_home_ios)
        ivMap.setImageResource(R.drawable.ic_map_ios)
        ivHistory.setImageResource(R.drawable.ic_history_ios)
        ivProfile.setImageResource(R.drawable.ic_person_ios)

        // Reset all icons to tinted gray (inactive state)
        ivHome.imageTintList = ColorStateList.valueOf(inactiveTint)
        ivMap.imageTintList = ColorStateList.valueOf(inactiveTint)
        ivHistory.imageTintList = ColorStateList.valueOf(inactiveTint)
        ivProfile.imageTintList = ColorStateList.valueOf(inactiveTint)

        when (id) {
            R.id.nav_home -> {
                lblHome.setTextColor(activeTint)
                ivHome.imageTintList = null // Full color iOS style
                loadFragment(HomeFragment())
            }
            R.id.nav_map -> {
                lblMap.setTextColor(activeTint)
                ivMap.imageTintList = null
                loadFragment(MapFragment())
            }
            R.id.nav_history -> {
                lblHistory.setTextColor(activeTint)
                ivHistory.imageTintList = null
                loadFragment(HistoryFragment())
            }
            R.id.nav_profile -> {
                lblProfile.setTextColor(activeTint)
                ivProfile.imageTintList = null
                loadFragment(ProfileFragment())
            }
        }
    }

    fun navigateToTab(itemId: Int) {
        selectTab(itemId)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

package com.mahasiswa.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val headerContent = view.findViewById<View>(R.id.profile_header_content)
        ViewCompat.setOnApplyWindowInsetsListener(headerContent) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top, v.paddingRight, v.paddingBottom)
            insets
        }

        setupProfileMenu(view)

        return view
    }

    private fun setupProfileMenu(view: View) {
        // Edit Profile
        setupMenuItem(view.findViewById(R.id.menu_edit_profile), 
            "Edit Profil", "Ubah data diri dan foto", 
            R.drawable.ic_person_ios, R.color.g5)

        // Notifications
        setupMenuItem(view.findViewById(R.id.menu_notifications), 
            "Notifikasi", "Atur preferensi notifikasi", 
            R.drawable.ic_notifications_ios, R.color.bluel)

        // Region
        setupMenuItem(view.findViewById(R.id.menu_region), 
            "Wilayah Saya", "Tampan, Pekanbaru", 
            R.drawable.ic_pin_ios, R.color.accl)

        // Security
        setupMenuItem(view.findViewById(R.id.menu_security), 
            "Keamanan", "Password dan privasi", 
            R.drawable.ic_lock, R.color.gray5)
        
        // Help
        setupMenuItem(view.findViewById(R.id.menu_help), 
            "Bantuan & FAQ", "Panduan penggunaan", 
            R.drawable.ic_refresh_ios, R.color.bluel)

        // Logout
        val mLogout = view.findViewById<View>(R.id.menu_logout)
        setupMenuItem(mLogout, "Keluar", "Logout dari akun", 
            R.drawable.ic_trash_ios, R.color.redl)
        
        mLogout.findViewById<TextView>(R.id.tv_menu_title).setTextColor(requireContext().getColor(R.color.red))
        mLogout.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun setupMenuItem(view: View, title: String, sub: String, icon: Int, bgTint: Int) {
        view.findViewById<TextView>(R.id.tv_menu_title).text = title
        view.findViewById<TextView>(R.id.tv_menu_sub).text = sub
        view.findViewById<ImageView>(R.id.iv_menu_icon).setImageResource(icon)
        view.findViewById<ImageView>(R.id.iv_menu_icon).imageTintList = null
        view.findViewById<View>(R.id.icon_container).backgroundTintList = 
            requireContext().getColorStateList(bgTint)
    }
}

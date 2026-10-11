package com.mahasiswa.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val headerContent = view.findViewById<View>(R.id.header_content)
        ViewCompat.setOnApplyWindowInsetsListener(headerContent) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top, v.paddingRight, v.paddingBottom)
            insets
        }

        setupMenu(view)
        setupOtherActions(view)

        return view
    }

    private fun setupMenu(view: View) {
        // Row 1
        setupMenuItem(view.findViewById(R.id.menu_map), R.drawable.ic_map_ios, R.color.g5, "Peta Sampah") {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_map)
        }
        setupMenuItem(view.findViewById(R.id.menu_report), R.drawable.ic_camera_ios, R.color.accl, "Lapor Sampah") {
            startActivity(Intent(requireContext(), ReportActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_schedule), R.drawable.ic_calendar_ios, R.color.bluel, "Jadwal Angkut") {
            startActivity(Intent(requireContext(), JadwalActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_recycle), R.drawable.ic_recycle_ios, R.color.gray5, "Setor Sampah") {
            startActivity(Intent(requireContext(), SetorSampahActivity::class.java))
        }

        // Row 2
        setupMenuItem(view.findViewById(R.id.menu_guide), R.drawable.ic_book_ios, R.color.accl, "Panduan Pilah") {
            startActivity(Intent(requireContext(), PanduanActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_reward), R.drawable.ic_gift_ios, R.color.g5, "Reward") {
            startActivity(Intent(requireContext(), RewardActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_stats), R.drawable.ic_stats_ios, R.color.redl, "Statistik") {
            startActivity(Intent(requireContext(), StatistikActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_notif), R.drawable.ic_notifications_ios, R.color.bluel, "Notifikasi") {
            showToast("Fitur Notifikasi akan segera hadir!")
        }

        // Row 3 (Additional Menus)
        setupMenuItem(view.findViewById(R.id.menu_history), R.drawable.ic_history_ios, R.color.gray5, "Riwayat") {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_history)
        }
        setupMenuItem(view.findViewById(R.id.menu_bank), R.drawable.ic_star_ios, R.color.accl, "Bank Sampah") {
            startActivity(Intent(requireContext(), SetorSampahActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_community), R.drawable.ic_person_ios, R.color.g5, "Komunitas") {
            startActivity(Intent(requireContext(), KomunitasActivity::class.java))
        }
        setupMenuItem(view.findViewById(R.id.menu_help), R.drawable.ic_refresh_ios, R.color.bluel, "Bantuan") {
            startActivity(Intent(requireContext(), BantuanActivity::class.java))
        }
    }

    private fun setupMenuItem(view: View, iconRes: Int, bgTint: Int, label: String, onClick: () -> Unit) {
        val iconView = view.findViewById<ImageView>(R.id.iv_menu_icon)
        iconView.setImageResource(iconRes)
        iconView.imageTintList = null
        view.findViewById<TextView>(R.id.tv_label).text = label
        view.findViewById<View>(R.id.icon_bg).backgroundTintList = requireContext().getColorStateList(bgTint)
        view.setOnClickListener { onClick() }
    }

    private fun setupOtherActions(view: View) {
        view.findViewById<ImageView>(R.id.iv_profile_header).setOnClickListener {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_profile)
        }
        view.findViewById<Button>(R.id.btn_tukar_poin).setOnClickListener {
            startActivity(Intent(requireContext(), RewardActivity::class.java))
        }
        view.findViewById<TextView>(R.id.tv_view_all_reports).setOnClickListener {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_history)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

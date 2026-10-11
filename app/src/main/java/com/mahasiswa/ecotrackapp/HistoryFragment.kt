package com.mahasiswa.ecotrackapp

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        val headerContainer = view.findViewById<View>(R.id.history_header_container)
        ViewCompat.setOnApplyWindowInsetsListener(headerContainer) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top, v.paddingRight, v.paddingBottom)
            insets
        }

        setupFilters(view)

        return view
    }

    private fun setupFilters(view: View) {
        val filterAll = view.findViewById<TextView>(R.id.filter_all)
        val filterPending = view.findViewById<TextView>(R.id.filter_pending)
        val filterProcessing = view.findViewById<TextView>(R.id.filter_processing)
        val filterDone = view.findViewById<TextView>(R.id.filter_done)

        val filters = listOf(filterAll, filterPending, filterProcessing, filterDone)

        filters.forEach { filterView ->
            filterView.setOnClickListener {
                filters.forEach { f ->
                    f.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                    f.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray3))
                }
                
                filterView.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.g2))
                filterView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
        }
    }
}

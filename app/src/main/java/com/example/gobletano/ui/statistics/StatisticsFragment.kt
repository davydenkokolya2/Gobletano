package com.example.gobletano.ui.statistics

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentStatisticsBinding
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.util.Screens

class StatisticsFragment : Fragment() {

    private lateinit var binding: FragmentStatisticsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    private lateinit var viewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        binding.btnBackStatistics.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StatisticsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
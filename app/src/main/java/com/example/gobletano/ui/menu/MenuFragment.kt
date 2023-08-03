package com.example.gobletano.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentMenuBinding
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.util.Screens

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.btnLevels.setOnClickListener {
            navigationAppViewModel.loadState(Screens.LEVELS)
        }
        binding.btnPlay.setOnClickListener {
            navigationAppViewModel.loadState(Screens.LEVEL)
        }
        binding.btnSettings.setOnClickListener {
            navigationAppViewModel.loadState(Screens.SETTINGS)
        }
        binding.btnStatistics.setOnClickListener {
            navigationAppViewModel.loadState(Screens.STATISTICS)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
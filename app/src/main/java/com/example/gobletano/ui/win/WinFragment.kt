package com.example.gobletano.ui.win

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.util.Screens

class WinFragment : Fragment() {

    private lateinit var binding: FragmentWinBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinBinding.inflate(inflater, container, false)
        binding.btnMenu.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        binding.btnNextLevel.setOnClickListener {
            navigationAppViewModel.loadState(Screens.LEVEL)
        }
        return binding.root
    }
}
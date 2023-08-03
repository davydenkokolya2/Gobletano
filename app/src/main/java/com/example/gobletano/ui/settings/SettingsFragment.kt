package com.example.gobletano.ui.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentSettingsBinding
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.util.Screens
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.btnBackSettings.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        lifecycleScope.launch {
            settingsViewModel.stateSetting.collect {
                when (it) {
                    "on" -> {
                        binding.btnOnSound.visibility = View.VISIBLE
                        binding.btnOffSound.visibility = View.INVISIBLE
                    }
                    "off" -> {
                        binding.btnOffSound.visibility = View.VISIBLE
                        binding.btnOnSound.visibility = View.INVISIBLE
                    }
                }
            }
        }
        binding.btnOnSound.setOnClickListener {
            settingsViewModel.loadState("off")
        }
        binding.btnOffSound.setOnClickListener {
            settingsViewModel.loadState("on")
        }
        return binding.root
    }
}
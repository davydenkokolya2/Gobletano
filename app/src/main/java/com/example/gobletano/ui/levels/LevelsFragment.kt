package com.example.gobletano.ui.levels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentLevelsBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.ui.level.LevelViewModel
import com.example.gobletano.util.Screens
import kotlinx.coroutines.launch

class LevelsFragment : Fragment() {

    private lateinit var binding: FragmentLevelsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val levelsViewModel: LevelsViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelsBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            levelsViewModel.stateLevels.collect {
                binding.btnLevel2.setImageResource(R.drawable.button_second_level_off)
                binding.btnLevel3.setImageResource(R.drawable.button_three_level_off)
                binding.btnLevel4.setImageResource(R.drawable.button_four_level_off)
                binding.btnLevel5.setImageResource(R.drawable.button_five_level_off)
                binding.btnLevel6.setImageResource(R.drawable.button_six_level_off)
                when (it) {
                    6 -> {
                        binding.btnLevel2.setImageResource(R.drawable.button_second_level_on)
                        binding.btnLevel3.setImageResource(R.drawable.button_three_level_on)
                        binding.btnLevel4.setImageResource(R.drawable.button_four_level_on)
                        binding.btnLevel5.setImageResource(R.drawable.button_five_level_on)
                        binding.btnLevel6.setImageResource(R.drawable.button_six_level_on)
                    }

                    5 -> {
                        binding.btnLevel2.setImageResource(R.drawable.button_second_level_on)
                        binding.btnLevel3.setImageResource(R.drawable.button_three_level_on)
                        binding.btnLevel4.setImageResource(R.drawable.button_four_level_on)
                        binding.btnLevel5.setImageResource(R.drawable.button_five_level_on)
                    }

                    4 -> {
                        binding.btnLevel2.setImageResource(R.drawable.button_second_level_on)
                        binding.btnLevel3.setImageResource(R.drawable.button_three_level_on)
                        binding.btnLevel4.setImageResource(R.drawable.button_four_level_on)
                    }

                    3 -> {
                        binding.btnLevel2.setImageResource(R.drawable.button_second_level_on)
                        binding.btnLevel3.setImageResource(R.drawable.button_three_level_on)
                    }

                    2 -> {
                        binding.btnLevel2.setImageResource(R.drawable.button_second_level_on)
                    }
                }
            }
        }
        binding.btnLevel1.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 1) {
                levelViewModel.loadState(1)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnLevel2.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 2) {
                levelViewModel.loadState(2)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnLevel3.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 3) {
                levelViewModel.loadState(3)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnLevel4.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 4) {
                levelViewModel.loadState(4)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnLevel5.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 5) {
                levelViewModel.loadState(5)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnLevel6.setOnClickListener {
            if (levelViewModel.stateLevel.value >= 6) {
                levelViewModel.loadState(6)
                navigationAppViewModel.loadState(Screens.LEVEL)
            }
        }
        binding.btnBackMenu.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        return binding.root
    }
}
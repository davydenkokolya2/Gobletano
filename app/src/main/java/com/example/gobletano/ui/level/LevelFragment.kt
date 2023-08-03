package com.example.gobletano.ui.level

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentLevelBinding
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.ui.levels.LevelsViewModel
import com.example.gobletano.util.Constants
import com.example.gobletano.util.Screens
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Integer.min

class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    private val levelsViewModel: LevelsViewModel by activityViewModels()
    private lateinit var viewModel: LevelViewModel
    /*val timer = object: CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            if (millisUntilFinished/1000 >= 10)
                binding.tvTime.text = "00:${millisUntilFinished/1000}"
            else
                binding.tvTime.text = "00:0${millisUntilFinished/1000}"
        }

        override fun onFinish() {
            navigationAppViewModel.loadState(Screens.LOSE)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLevelBinding.inflate(inflater, container, false)
        binding.btnBackLevel.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        lifecycleScope.launch {
            for (i in 19 downTo 0){
                if (i >= 10)
                    binding.tvTime.text = "00:${i}"
                else
                    binding.tvTime.text = "00:0${i}"
                delay(1000)
            }
            navigationAppViewModel.loadState(Screens.LOSE)
        }
        lifecycleScope.launch {
            levelViewModel.stateLevel.collect {
                when(it) {
                    1 -> binding.tvLevel.setImageResource(R.drawable.icon_level_1)
                    2 -> binding.tvLevel.setImageResource(R.drawable.icon_level_2)
                    3 -> binding.tvLevel.setImageResource(R.drawable.icon_level_3)
                    4 -> binding.tvLevel.setImageResource(R.drawable.icon_level_4)
                    5 -> binding.tvLevel.setImageResource(R.drawable.icon_level_5)
                    6 -> binding.tvLevel.setImageResource(R.drawable.icon_level_6)
                }
            }
        }
        val level = levelViewModel.stateLevel.value - 1
        if (Constants.level[level][0][0] == 0)
            binding.iv00.visibility = View.INVISIBLE
        if (Constants.level[level][0][1] == 0)
            binding.iv01.visibility = View.INVISIBLE
        if (Constants.level[level][0][2] == 0)
            binding.iv02.visibility = View.INVISIBLE
        if (Constants.level[level][1][0] == 0)
            binding.iv10.visibility = View.INVISIBLE
        if (Constants.level[level][1][1] == 0)
            binding.iv11.visibility = View.INVISIBLE
        if (Constants.level[level][1][2] == 0)
            binding.iv12.visibility = View.INVISIBLE
        if (Constants.level[level][2][0] == 0)
            binding.iv20.visibility = View.INVISIBLE
        if (Constants.level[level][2][1] == 0)
            binding.iv21.visibility = View.INVISIBLE
        if (Constants.level[level][2][2] == 0)
            binding.iv22.visibility = View.INVISIBLE
        if (Constants.level[level][3][0] == 0)
            binding.iv30.visibility = View.INVISIBLE
        if (Constants.level[level][3][1] == 0)
            binding.iv31.visibility = View.INVISIBLE
        if (Constants.level[level][3][2] == 0)
            binding.iv32.visibility = View.INVISIBLE
        if (Constants.level[level][4][0] == 0)
            binding.iv40.visibility = View.INVISIBLE
        if (Constants.level[level][4][1] == 0)
            binding.iv41.visibility = View.INVISIBLE
        if (Constants.level[level][4][2] == 0)
            binding.iv42.visibility = View.INVISIBLE

        binding.iv00.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][0]) {
                1 -> binding.iv00.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv00.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv01.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][1]) {
                1 -> binding.iv01.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv01.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv02.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][2]) {
                1 -> binding.iv02.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv02.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.iv10.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][0]) {
                1 -> binding.iv10.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv10.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv11.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][1]) {
                1 -> binding.iv11.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv11.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv12.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][2]) {
                1 -> binding.iv12.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv12.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.iv20.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][0]) {
                1 -> binding.iv20.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv20.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv21.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][1]) {
                1 -> binding.iv21.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv21.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv22.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][2]) {
                1 -> binding.iv22.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv22.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.iv30.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][0]) {
                1 -> binding.iv30.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv30.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv31.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][1]) {
                1 -> binding.iv31.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv31.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv32.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][2]) {
                1 -> binding.iv32.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv32.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.iv40.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][0]) {
                1 -> binding.iv40.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv40.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv41.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][1]) {
                1 -> binding.iv41.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv41.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.iv42.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][2]) {
                1 -> binding.iv42.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.iv42.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        return binding.root
    }
    private fun goToWinFragment() {
        levelViewModel.loadState(min(levelViewModel.stateLevel.value + 1, 6))
        levelsViewModel.loadState(min(levelsViewModel.stateLevels.value + 1, 6))
        //Thread.sleep(1_000)
        navigationAppViewModel.loadState(Screens.WIN)
    }

    private fun iconCupOff() {
        binding.iv00.setImageResource(R.drawable.icon_off_cup)
        binding.iv01.setImageResource(R.drawable.icon_off_cup)
        binding.iv02.setImageResource(R.drawable.icon_off_cup)

        binding.iv10.setImageResource(R.drawable.icon_off_cup)
        binding.iv11.setImageResource(R.drawable.icon_off_cup)
        binding.iv12.setImageResource(R.drawable.icon_off_cup)

        binding.iv20.setImageResource(R.drawable.icon_off_cup)
        binding.iv21.setImageResource(R.drawable.icon_off_cup)
        binding.iv22.setImageResource(R.drawable.icon_off_cup)

        binding.iv30.setImageResource(R.drawable.icon_off_cup)
        binding.iv31.setImageResource(R.drawable.icon_off_cup)
        binding.iv32.setImageResource(R.drawable.icon_off_cup)

        binding.iv40.setImageResource(R.drawable.icon_off_cup)
        binding.iv41.setImageResource(R.drawable.icon_off_cup)
        binding.iv42.setImageResource(R.drawable.icon_off_cup)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LevelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
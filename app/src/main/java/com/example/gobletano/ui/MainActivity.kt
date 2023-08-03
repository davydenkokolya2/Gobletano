package com.example.gobletano.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.gobletano.R
import com.example.gobletano.databinding.ActivityMainBinding
import com.example.gobletano.ui.level.LevelFragment
import com.example.gobletano.ui.levels.LevelsFragment
import com.example.gobletano.ui.levels.LevelsViewModel
import com.example.gobletano.ui.lose.LoseFragment
import com.example.gobletano.ui.menu.MenuFragment
import com.example.gobletano.ui.settings.SettingsFragment
import com.example.gobletano.ui.settings.SettingsViewModel
import com.example.gobletano.ui.statistics.StatisticsFragment
import com.example.gobletano.ui.win.WinFragment
import com.example.gobletano.util.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigationAppViewModel: NavigationAppViewModel by viewModels()
    private val settingsViewModel: SettingsViewModel by viewModels()
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true

        lifecycleScope.launch {
            navigationAppViewModel.stateScreens.collect {
                when(it){
                    Screens.MENU -> replaceFragment(MenuFragment())
                    Screens.LEVEL -> replaceFragment(LevelFragment())
                    Screens.LEVELS -> replaceFragment(LevelsFragment())
                    Screens.LOSE -> replaceFragment(LoseFragment())
                    Screens.SETTINGS -> replaceFragment(SettingsFragment())
                    Screens.WIN -> replaceFragment(WinFragment())
                    Screens.STATISTICS -> replaceFragment(StatisticsFragment())
                }
            }
        }
        lifecycleScope.launch {
            settingsViewModel.stateSetting.collect {
                when (it) {
                    "on" -> mediaPlayer.start()
                    "off" -> mediaPlayer.pause()

                    else -> {}
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}
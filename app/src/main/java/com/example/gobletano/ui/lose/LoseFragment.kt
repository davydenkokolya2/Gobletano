package com.example.gobletano.ui.lose

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletano.R
import com.example.gobletano.databinding.FragmentLoseBinding
import com.example.gobletano.databinding.FragmentWinBinding
import com.example.gobletano.ui.NavigationAppViewModel
import com.example.gobletano.util.Screens

class LoseFragment : Fragment() {

    private lateinit var binding: FragmentLoseBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    private lateinit var viewModel: LoseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoseBinding.inflate(inflater, container, false)
        binding.btnMenuLose.setOnClickListener {
            navigationAppViewModel.loadState(Screens.MENU)
        }
        binding.btnPlayAgain.setOnClickListener {
            navigationAppViewModel.loadState(Screens.LEVEL)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
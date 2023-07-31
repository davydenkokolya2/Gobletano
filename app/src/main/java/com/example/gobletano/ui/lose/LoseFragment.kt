package com.example.gobletano.ui.lose

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gobletano.R

class LoseFragment : Fragment() {

    companion object {
        fun newInstance() = LoseFragment()
    }

    private lateinit var viewModel: LoseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lose, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
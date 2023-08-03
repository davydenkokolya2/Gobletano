package com.example.gobletano.ui.levels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelsViewModel @Inject constructor() : ViewModel() {
    private val _stateLevels = MutableStateFlow<Int>(1)
    val stateLevels: StateFlow<Int> = _stateLevels

    fun loadState(level: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLevels.emit(level)
        }
    }
}
package com.example.gobletano.ui.level

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor() : ViewModel() {
    private val _stateLevel = MutableStateFlow<Int>(1)
    val stateLevel: StateFlow<Int> = _stateLevel

    fun loadState(level: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLevel.emit(level)
        }
    }
}
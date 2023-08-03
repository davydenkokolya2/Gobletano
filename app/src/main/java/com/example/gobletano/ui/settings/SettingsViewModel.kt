package com.example.gobletano.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _stateSetting = MutableStateFlow<String>("on")
    val stateSetting: StateFlow<String> = _stateSetting

    fun loadState(setting: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateSetting.emit(setting)
        }
    }
}
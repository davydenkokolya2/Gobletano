package com.example.gobletano.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gobletano.util.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationAppViewModel @Inject constructor() : ViewModel(){
    private val _stateScreens = MutableStateFlow<Screens>(Screens.MENU)
    val stateScreens: StateFlow<Screens> = _stateScreens

    fun loadState(screens: Screens) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateScreens.emit(screens)
        }
    }
}
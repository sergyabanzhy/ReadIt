package com.read.mvi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.read.mvi.machine.Machine

class TestViewModel: ViewModel() {

    val machine = Machine(viewModelScope)
}
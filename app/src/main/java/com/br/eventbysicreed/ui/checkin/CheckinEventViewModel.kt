package com.br.eventbysicreed.ui.checkin

import androidx.lifecycle.ViewModel
import com.br.eventbysicreed.data.model.checkin.CheckinModel
import com.br.eventbysicreed.repository.Repository
import com.br.eventbysicreed.ui.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CheckinEventViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _checkin =
        MutableStateFlow<ResourceState<CheckinModel>>(ResourceState.Loading())
    val checkin: StateFlow<ResourceState<CheckinModel>> = _checkin
}
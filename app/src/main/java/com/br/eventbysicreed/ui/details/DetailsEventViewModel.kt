package com.br.eventbysicreed.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.eventbysicreed.data.model.event.EventModel
import com.br.eventbysicreed.repository.Repository
import com.br.eventbysicreed.ui.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsEventViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val _details = MutableStateFlow<ResourceState<EventModel>>(ResourceState.Loading())
    val details: StateFlow<ResourceState<EventModel>> = _details

}
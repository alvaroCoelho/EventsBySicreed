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

    fun fetch(eventId: Int) = viewModelScope.launch{
        safeFetch(eventId)
    }

    private suspend fun safeFetch(eventId: Int) {
        _details.value = ResourceState.Loading()
        try {
            val response = repository.getEvent(eventId)
            _details.value = handleResponse(response)
        }catch (throwable: Throwable){
            when(throwable){
                is IOException -> _details.value = ResourceState.Error("Erro de rede")
                else -> _details.value = ResourceState.Error("Erro de conversão")
            }
        }
    }

    private fun handleResponse(response: Response<EventModel>): ResourceState<EventModel> {
        if(response.isSuccessful){
            response.body()?.let { values ->
                return ResourceState.Sucess(values)
            }
        }
        return ResourceState.Error(response.message())
    }

 fun checkin(){

 }


}
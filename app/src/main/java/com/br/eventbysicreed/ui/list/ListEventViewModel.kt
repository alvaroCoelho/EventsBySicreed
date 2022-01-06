package com.br.eventbysicreed.ui.list

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
class ListEventViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _list = MutableStateFlow<ResourceState<List<EventModel>>>(ResourceState.Loading())
    val list: StateFlow<ResourceState<List<EventModel>>> = _list

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch{
        safeFetch()

    }

    private suspend fun safeFetch() {
        try {
            val response = repository.list()
            _list.value = handleResponse(response)
        }catch (throwable: Throwable){
            when(throwable){
                is IOException -> _list.value = ResourceState.Error("Erro conexão")
                else -> _list.value = ResourceState.Error("Falha conversão")
            }
        }

    }

    private fun handleResponse(response: Response<List<EventModel>>): ResourceState<List<EventModel>> {
        if (response.isSuccessful){
            response.body()?.let { values ->
                return ResourceState.Sucess(values)
            }
        }
        return ResourceState.Error(response.message())
    }

}
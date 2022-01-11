package com.br.eventbysicreed.ui.checkin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.eventbysicreed.data.model.checkin.CheckinModel
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
class CheckinEventViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _checkin =
        MutableStateFlow<ResourceState<CheckinModel>>(ResourceState.Loading())
    val checkinEvent: StateFlow<ResourceState<CheckinModel>> = _checkin


    fun checkin(checkinModel: CheckinModel) = viewModelScope.launch {

       safeCheckin(checkinModel)

    }



     suspend fun safeCheckin(checkinModel: CheckinModel) {
        _checkin.value = ResourceState.Loading()
        try {
            val response = repository.checkin(checkinModel)
            _checkin.value = handleResponse(response)
        }catch (throwable: Throwable){
            when(throwable){
                is IOException -> _checkin.value = ResourceState.Error("Erro conexão")
                else -> _checkin.value = ResourceState.Error("Falha conversão")
            }
        }

    }

    private fun handleResponse(response: Response<CheckinModel>): ResourceState<CheckinModel> {
        if(response.isSuccessful){
            response.body()?.let { values ->
                return ResourceState.Sucess(values)
            }
        }
        return ResourceState.Error(response.message())
    }

}
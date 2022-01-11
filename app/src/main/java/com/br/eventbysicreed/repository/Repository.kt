package com.br.eventbysicreed.repository

import com.br.eventbysicreed.data.model.checkin.CheckinModel
import com.br.eventbysicreed.data.remote.ServiceApi
import javax.inject.Inject

class Repository @Inject constructor(
    private val api:ServiceApi
) {

    suspend fun list() = api.list()
     suspend fun checkin(checkin: CheckinModel) = api.checkin(checkin)

}
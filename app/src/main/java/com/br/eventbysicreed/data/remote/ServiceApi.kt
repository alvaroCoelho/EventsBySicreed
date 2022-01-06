package com.br.eventbysicreed.data.remote

import com.br.eventbysicreed.data.model.event.EventModel
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("events")
    suspend fun list(): Response<List<EventModel>>
}
package com.br.eventbysicreed.data.remote

import com.br.eventbysicreed.data.model.event.EventModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    @GET("events")
    suspend fun list(): Response<List<EventModel>>


    @GET("events/{id}")
    suspend fun getEvent(
        @Path(
            value = "idd",
            encoded = true
        )characterId: Int

    ): Response<EventModel>
}
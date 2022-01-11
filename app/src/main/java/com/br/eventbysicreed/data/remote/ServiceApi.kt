package com.br.eventbysicreed.data.remote

import com.br.eventbysicreed.data.model.checkin.CheckinModel
import com.br.eventbysicreed.data.model.event.EventModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceApi {

    @GET("events")
    suspend fun list(): Response<List<EventModel>>

    @POST("checkin")
    suspend fun checkin(@Body checkinModel: CheckinModel): Response<CheckinModel>

}
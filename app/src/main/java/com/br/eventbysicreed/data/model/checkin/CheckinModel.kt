package com.br.eventbysicreed.data.model.checkin

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CheckinModel (

    @SerializedName("id")
    val id: Int,
    @SerializedName("eventId")
    val eventId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String

):Serializable
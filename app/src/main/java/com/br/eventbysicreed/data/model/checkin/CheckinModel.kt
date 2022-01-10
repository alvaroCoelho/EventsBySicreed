package com.br.eventbysicreed.data.model.checkin

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CheckinModel (

    @SerializedName("id")
    var id: Int,
    @SerializedName("eventId")
    var eventId: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String

):Serializable
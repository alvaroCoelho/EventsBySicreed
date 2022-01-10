package com.br.eventbysicreed.data.model.event

import com.br.eventbysicreed.data.model.people.PeopleModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventModel(

    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("price")
    var price:String,
    @SerializedName("latitude")
    var latitude:String,
    @SerializedName("longitude")
    var longitude:String,
    @SerializedName("image")
    var image:String,
    @SerializedName("description")
    var description:String,
    @SerializedName("date")
    var date:String,
    @SerializedName("people")
    var people: List<PeopleModel>

):Serializable
package com.br.eventbysicreed.data.model.event

import com.br.eventbysicreed.data.model.people.PeopleModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventModel(

    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("price")
    val price:String,
    @SerializedName("latitude")
    val latitude:String,
    @SerializedName("longitude")
    val longitude:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("date")
    val date:String,
    @SerializedName("people")
    val people: List<PeopleModel>

):Serializable
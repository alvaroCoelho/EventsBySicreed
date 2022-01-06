package com.br.eventbysicreed.data.model.event

import java.io.Serializable

data class EventModel(

    val id:Int,
    val title:String,
    val price:String,
    val latitude:String,
    val longitude:String,
    val image:String,
    val description:String,
    val date:String

):Serializable
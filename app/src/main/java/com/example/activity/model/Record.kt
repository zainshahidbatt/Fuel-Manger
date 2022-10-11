package com.example.activity.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "records")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val meterReading:String,
    val litters:Int,
    val price:Int,
    val totalAmount:Int,
    var totalConsumption:Int=0
)
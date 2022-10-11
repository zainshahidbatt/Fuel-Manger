package com.example.activity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.activity.model.Record

@Database(entities = [Record::class], version = 5)
abstract class RecordDatabase:RoomDatabase(){
    abstract fun recordDao(): RecordDao

}
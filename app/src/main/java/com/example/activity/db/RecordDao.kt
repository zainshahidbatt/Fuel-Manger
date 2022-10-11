package com.example.activity.db

import androidx.room.*
import com.example.activity.model.Record
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

    @Query("SELECT *  FROM records ORDER BY id DESC")
    fun getRecord(): Flow<List<Record>>

    @Query("SELECT * FROM records ORDER BY ID DESC LIMIT 1")
    fun getLatest(): Flow<List<Record>>

    @Insert
    suspend fun insertRecord(record: Record)

    @Delete
    suspend fun deleteRecord(record: Record)

    @Update
    suspend fun updateRecord(record: Record)
}
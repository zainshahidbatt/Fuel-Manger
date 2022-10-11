package com.example.activity.repository

import com.example.activity.db.RecordDao
import com.example.activity.model.Record
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecordRepository @Inject constructor(private val recordDao: RecordDao) {
    fun getRecords(): Flow<List<Record>> {
        return recordDao.getRecord()
    }

    suspend fun insertRecord(record: Record) {
        recordDao.insertRecord(record)
    }
    fun getLatestRecord():Flow<List<Record>>{
        return recordDao.getLatest()
    }
}
package com.example.activity.di

import android.content.Context
import androidx.room.Room

import com.example.activity.db.RecordDao
import com.example.activity.db.RecordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRecordDB(@ApplicationContext context:Context):RecordDatabase{
        return Room.databaseBuilder(context,RecordDatabase::class.java,"RecordDB").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun getDao(recordDatabase: RecordDatabase): RecordDao {
        return recordDatabase.recordDao()
    }

}
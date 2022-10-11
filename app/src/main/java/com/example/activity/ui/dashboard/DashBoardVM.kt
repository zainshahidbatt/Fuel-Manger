package com.example.activity.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity.model.Record
import com.example.activity.repository.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardVM @Inject constructor(private val repository: RecordRepository):ViewModel() {

    private val _record=MutableStateFlow<State>(State.Idle)
    val readRecord=_record.asStateFlow()
    init {
        observerRecord()
    }

    private fun observerRecord() {
        repository.getRecords()
        viewModelScope.launch {
            repository.getRecords().collect{
                fun bind(item:Record){

                }
            }
        }
    }

    sealed class State{
    data class Success(val record:List<Record>):State()
    object Idle:State()
}
}
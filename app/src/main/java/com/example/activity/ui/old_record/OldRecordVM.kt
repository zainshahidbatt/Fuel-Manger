package com.example.activity.ui.old_record

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
class OldRecordVM @Inject constructor(private val repository: RecordRepository) : ViewModel() {

    private val _record = MutableStateFlow<State>(State.Idle)
    val readRecord = _record.asStateFlow()

    init {
        observeRecord()
    }

    private fun observeRecord() {
        viewModelScope.launch {
            repository.getRecords().collect {
                var total = 0
                it.forEach { list ->
                    total += list.litters
                }

                _record.value = State.Success(it)

            }
        }
    }

    sealed class State {
        data class Success(val record: List<Record>) : State()
        object Idle : State()
    }
}

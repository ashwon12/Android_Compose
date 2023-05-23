package com.example.composestatus

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel(){
    private val _task = getWellnessTasks().toMutableStateList()
    val tasks : List<WellnessTask>
        get() = _task

    fun remove(items : WellnessTask){
        _task.remove(items)
    }

    // 상태의 값이 변경됨을 감지하고 업데이트 해주는 함수
    fun changeTaskChecked(items: WellnessTask, checked : Boolean) =
        tasks.find { it.id == items.id }?.let {
            it.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

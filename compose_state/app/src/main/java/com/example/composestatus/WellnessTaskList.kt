package com.example.composestatus

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

// 리스트 값 업데이트
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }


// 리싸이클러뷰를 만들기 위한 껍데기
@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WellnessTaskItem(taskItem = task.label)
        }
    }
}
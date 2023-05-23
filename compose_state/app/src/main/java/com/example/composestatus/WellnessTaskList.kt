package com.example.composestatus

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

// 리스트 값 업데이트

// 리싸이클러뷰를 만들기 위한 껍데
@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask : (WellnessTask,Boolean) -> Unit
) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = scrollState
    ) {
        items(items =list,
        key = {task -> task.id}) { task ->
            WellnessTaskItem(
                taskItem = task.label,
                onClose = { onCloseTask(task) },
                checked = task.checked,
                onCheckedChange = {checked -> onCheckedTask(task,checked)}
            )
        }
    }
}
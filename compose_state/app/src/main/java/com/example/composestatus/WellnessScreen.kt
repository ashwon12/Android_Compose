package com.example.composestatus

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        StatefulCounter()

        // rememberSaveable()를 사용하여 WellnessScreen에 목록을 저장하려고 하면 런타임 예외가 발생
        val list = remember {
            getWellnessTasks().toMutableStateList()
        }
        WellnessTasksList(list = list, onCloseTask = {
                task -> list.remove(task)
        })
    }

}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }


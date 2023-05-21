package com.example.composestatus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 모든 함수의 첫번째 인자로 modifier이 들어가는게 좋다. 재사용성이 높아지기 떄문
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // 리컴포지션을 가능하게 하기 위한 State 타입 추가
        // 리컴포지션이 발생할 경우 0으로 초기화 되기 때문 remember을 사용하여 기존의 값을 기억하도록 한다.
        // Kotlin 의 by 키워드를 사용하여 getter와 setter 를 추가함으로써 매번 value를 언급하지 않아도 됨
        // 리컴포저블 뿐만 아니라 앱의 요소들 ( 가로세로변경) 의 상태를 기억하기 위함 rememberSaveable 사용
        var count by rememberSaveable { mutableStateOf(0) }

        if (count > 0) {
//            var showTask by remember {
//                mutableStateOf(true)
//            }
//            if (showTask){
//                WellnessTaskItem(taskItem = "오늘 15분 걸었니?", onClose = { showTask = false})
//            }
            Text(text = "You've had $count glasses")
        }
        // 이벤트를 발생함 ( 상태 변경을 감지 하지 않았기 때문에 아무일도 일어나지 않음 )
        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "물잔 추가하기")
            }
//            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
//                Text("물잔 초기화")
//            }
        }

    }
}
package com.example.composestatus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 모든 함수의 첫번째 인자로 modifier이 들어가는게 좋다. 재사용성이 높아지기 떄문
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count = 0
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "You've had $count glasses")

        // 이벤트를 발생함 ( 상태 변경을 감지 하지 않았기 때문에 아무일도 일어나지 않음 )
        Button(onClick = {count++}, Modifier.padding(top = 8.dp)) {
            Text(text = "물잔 추가하기")
        }
    }
}
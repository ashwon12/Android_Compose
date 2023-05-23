package com.example.composestatus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 시간에 따라 변하지않는 스테이트리스 컴포저블.
 * 가능한 스테이트리스 컴포저블을 많이 갖는게 좋음
 */
@Composable
fun StatelessCounter(
    count : Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}


/**
 * 시간에 따라 변할 수 있는 상태를 소유하고 있음
 *
 * 상태 호이스팅 -> 변화하는 값에 따라 화면을 다르게 보여주는 것
 * 상태 호이스팅을 할 때 고려할 점
1. 상태는 적어도 그 상태를 사용하는 모든 컴포저블의 가장 낮은 공통 상위 요소로 끌어올려야 합니다(읽기).
2. 상태는 최소한 변경될 수 있는 가장 높은 수준으로 끌어올려야 합니다(쓰기).
3. 두 상태가 동일한 이벤트에 대한 응답으로 변경되는 경우 두 상태는 동일한 수준으로 끌어올려야 합니다.
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}
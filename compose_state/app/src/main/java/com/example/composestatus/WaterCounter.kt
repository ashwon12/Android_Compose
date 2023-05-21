package com.example.composestatus

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 모든 함수의 첫번째 인자로 modifier이 들어가는게 좋다. 재사용성이 높아지기 떄문
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 0
    Text(text = "You've had $count glasses", modifier = modifier.padding(16.dp))
}
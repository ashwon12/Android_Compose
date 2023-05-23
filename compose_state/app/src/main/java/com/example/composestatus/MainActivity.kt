package com.example.composestatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestatus.ui.theme.ComposeStatusTheme


/**
 *  APP 의 State 는 특정 시간에 UI에 표시되는 내용
 *  1. 스크롤의 위치
 *  2. 사용자의 프로필 사진
 *  3. 채팅 앱에서 받은 가장 최근의 메세지
 *
 *  상태는 존재하고 이벤트는 발생한다.
 *
 *  컴포지션, 초기 컴포지션, 리컴포지션의 개념을 알 것.
 *  데이터가 변경될 떄 컴포지션을 업데이트 하기 위해서 컴포저블을 다시 그리는 것을 리컴포지션이라고 칭함.
 *  COmpose에서 틁정 상태를 읽는 리컴포지션의 예약할 수 있는 추적 시스템이 존재함.
 *  -> State, MutableState
 *
 *  상태가 내려가고 (스테이트리스) 이벤트가 올라가는 패턴을 단방향 데이터흐름 UDF 라고 한다.
 *  컴포즈에서 UDF 를 구현하는 방법을
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStatusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStatusTheme {
        WellnessScreen()
    }
}
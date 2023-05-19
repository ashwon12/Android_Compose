package com.example.android.wearable.composeforwearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway
import com.example.android.wearable.composeforwearos.theme.WearAppTheme

/**
https://android-developers.googleblog.com/2021/10/compose-for-wear-os-now-in-developer.html)
 */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    WearAppTheme {
        val listState = rememberScalingLazyListState() // 상태 기억하기.

        /**
         * Scaffold는 모바일과 같은 일반적인 패턴으로 화면을 정렬할 수 있는 구조를 제공
         *  모바일 : AppBar, Fab 이외에 기타 모바일 관련 요소를 제공하지만 wear에선 x
         *  Instance Of 웨어에선 ' TimeText , Vignette, PositionIndicator, PageIndicator' 을 제공
         */
        Scaffold(
            timeText = {
                TimeText(
                    modifier = Modifier.scrollAway(listState) // 스크롤하면 시간 삭제 되는 구조
                )
            },
            vignette = {
                // 스크롤 구조에서만 사용하는 것, 블러처리를 주는 기능, 포지션을 전부 지정하여 사용 가능.
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                /*
                인디케이터는 항상 Scaffold( 시계 ) 안에 있어야 함 , 스크롤 되는 곳 말고!! 가운데 있어야 하기 때문
                스크롤 위에있어야 스크롤의 위치를 알 수 있음.
                */
                PositionIndicator(
                    scalingLazyListState = listState,
                )
            }
        ) {


            // Modifiers used by our Wear composables.
            val contentModifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
            val iconModifier = Modifier
                .size(24.dp)
                .wrapContentSize(align = Alignment.Center)


            /*
            헤더가 있다면 'ListHearder' 로 첫번째에 설정하느 것이 좋다.
            Link : https://developer.android.com/reference/kotlin/androidx/wear/compose/material/package-summary#ListHeader(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function1)
            헤더가 없다면 autoCentering 변수를 사용하여 충분한 패딩을 준다.

            시각적 효과를 보장하는 기본 설정을 제공하기 때문에
            padding, verticalArrangement같은 매개변수가 필요 없다.
             */

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState,
                autoCentering = AutoCenteringParams(0)
            ) {
                item { ButtonExample(contentModifier, iconModifier) }
                item { TextExample(contentModifier) }
                item { CardExample(contentModifier, iconModifier) }
                item { ChipExample(contentModifier, iconModifier) }
                item { ToggleChipExample(contentModifier) }
            }
        }
    }
}

// Note: Preview in Android Studio doesn't support the round view yet (coming soon).
@Preview(
    widthDp = WEAR_PREVIEW_DEVICE_WIDTH_DP,
    heightDp = WEAR_PREVIEW_DEVICE_HEIGHT_DP,
    apiLevel = WEAR_PREVIEW_API_LEVEL,
    uiMode = WEAR_PREVIEW_UI_MODE,
    backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
    showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun WearAppPreview() {
    WearApp()
}

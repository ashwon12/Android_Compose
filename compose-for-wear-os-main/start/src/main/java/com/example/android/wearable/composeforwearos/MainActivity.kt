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

        /* *************************** Part 4: Wear OS Scaffold *************************** */
        // TODO (Start): Create a Scaffold (Wear Version)

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

            /* ******************* Part 1: Simple composables ******************* */
            item { ButtonExample(contentModifier, iconModifier) }
            item { TextExample(contentModifier) }
            item { CardExample(contentModifier, iconModifier) }

            /* ********************* Part 2: Wear unique composables ********************* */
            item { ChipExample(contentModifier, iconModifier) }
            item { ToggleChipExample(contentModifier) }
        }

        // TODO (End): Create a Scaffold (Wear Version)

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

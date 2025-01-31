package com.yapp.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yapp.core.designsystem.component.button.solid.YappSolidPrimaryButtonXLarge
import com.yapp.core.designsystem.component.input.text.YappInputTextLarge
import com.yapp.core.designsystem.theme.YappTheme


@Composable
fun LoginScreen() {
    var defaultInputValue by remember { mutableStateOf("") }
    var errorInputText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Column {
            Text(
                modifier = Modifier.padding(top = 72.dp, bottom = 32.dp),
                text = "당신의 작은 아이디어가\n" +
                        "세상을 바꿉니다.",
                style = YappTheme.typography.title2Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.illust_login_yappu),
                contentDescription = null
            )
            YappInputTextLarge(
                label = "이메일",
                value = defaultInputValue,
                onValueChange = { defaultInputValue = it },
                placeholder = "YAPP@email.com",
            )

            Spacer(Modifier.height(16.dp))
            YappInputTextLarge(
                label = "비밀번호",
                password = defaultInputValue,
                onPasswordChange = { defaultInputValue = it },
                placeholder = "••••••••"
            )

            Spacer(Modifier.height(24.dp))

            YappSolidPrimaryButtonXLarge(
                modifier = Modifier.fillMaxWidth(),
                text = "로그인",
                enable = false,
                onClick = {}
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
                Text(
                    text = "또는",
                    modifier = Modifier.padding(horizontal = 4.dp),
                    color = Color.LightGray,
                    style = YappTheme.typography.caption1Medium
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = YappTheme.colorScheme.lineNormalNormal,
                    thickness = 1.dp
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    YappTheme {
        LoginScreen()
    }
}
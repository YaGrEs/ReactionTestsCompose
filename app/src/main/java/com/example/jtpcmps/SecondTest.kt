package com.example.jtpcmps

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class SecondTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colors = listOf(Color.Red, Color.Black, Color.Yellow, Color.Green, Color.Gray, Color.Blue, Color.Cyan)
            var isDotShow by remember { mutableStateOf(false)}
            val scope = rememberCoroutineScope()
            var isFieldShow by remember { mutableStateOf(false)}
            var isButtonEnabled by remember { mutableStateOf(true)}
            val count = remember{mutableStateOf("")}
            val dotCount = remember{mutableStateOf(0)}
            var isDialogShow by remember { mutableStateOf(false)}
            val mContext = LocalContext.current
            val genNumber = Random.nextInt(10, 20)


            Box(modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.back2),
                    contentScale = ContentScale.FillBounds
                ))

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly){
                Canvas(Modifier.size(300.dp).background(Color.White).align(Alignment.CenterHorizontally)) {
                    if (isDotShow){
                        drawCircle(
                            color = colors[Random.nextInt(0,6)],
                            center = Offset(x = Random.nextInt(20,200).dp.toPx(), y = Random.nextInt(20,200).dp.toPx()),
                            radius = 10.dp.toPx()
                        )
                    }
                }
                Button(
                    modifier = Modifier.height(60.dp).width(180.dp).align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black),
                    enabled = isButtonEnabled,
                    onClick = {
                        scope.launch {
                            isButtonEnabled = false
                            for (i in 1..genNumber) {
                                isDotShow = true
                                delay(350L)
                                isDotShow = false
                                ++dotCount.value
                            }
                            isFieldShow = true
                            println(dotCount.value)
                        }

                    }
                ) { Text("Запустить", fontSize = 22.sp) }
                if (isFieldShow){
                    Row{
                        TextField(
                            count.value,
                            textStyle = TextStyle(fontSize =  28.sp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                            onValueChange = {count.value = it}
                        )
                        Button(
                            modifier = Modifier.height(60.dp).width(180.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black),
                            onClick = {
                                isDialogShow = true
                            }
                        ) { Text("Ок", fontSize = 22.sp) }
                    }
                }

            }
            if (isDialogShow){
                AlertDialog(
                    onDismissRequest = {isDialogShow = false},
                    title = { Text(text = "Результат") },
                    text = { Column{
                        Text("Ваш ответ: ${count.value}")
                        Text("Правильный ответ: ${dotCount.value}")
                        if (count.value.toInt() == dotCount.value){
                            Text("Вы прошли тест")
                        }
                        else{
                            Text("Попробуйте еще раз")
                        }
                        }},
                    confirmButton = {
                        Button({mContext.startActivity(Intent(mContext, MainActivity::class.java))}) {
                            Text("Выход", fontSize = 22.sp)
                        }
                    }
                )
            }
        }
    }
}
package com.example.jtpcmps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jtpcmps.ui.theme.JTPCMPSTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import Clock
import android.app.Application
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

class FirstTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current

            owner?.let {
                val model: UserViewModel = viewModel(
                    it,
                    "UserViewModel",
                    UserViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                SecondMain(model)
            }
        }
    }
}
@Composable
fun SecondMain(vm: UserViewModel = viewModel()){
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()
    val secondcount = remember { mutableStateOf(30) }
    val clickcount = remember { mutableStateOf(0) }
    var isClickable by remember { mutableStateOf(false)}
    val mContext = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.back2),
            contentScale = ContentScale.FillBounds
        ))
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {if(progress < 1.0f) ++clickcount.value},
            enabled = isClickable,
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, disabledContainerColor = Color.White, contentColor = Color.Black),
            border = BorderStroke(6.dp, Color.Gray)
        ){}
        if (!isClickable) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(60.dp)
                    .width(180.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black),
                onClick = {
                    isClickable = true
                    scope.launch {
                        while (progress < 1f) {
                            progress += 0.034f
                            delay(1000L)
                            --secondcount.value
                        }
                    }
                }
            ) { Text("Запустить", fontSize = 22.sp) }
        }
        else{
            Text("Сделано ${clickcount.value} кликов", fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.alumnisans)),
                modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        Text("Осталось ${secondcount.value} секунд", fontSize = 40.sp,
            fontFamily = FontFamily(Font(R.font.alumnisans)),
            modifier = Modifier.align(Alignment.CenterHorizontally))
        Row {
            Image(Clock, null, modifier = Modifier.offset((-15).dp))
            LinearProgressIndicator(progress = progress, modifier = Modifier.offset(0.dp, 40.dp), color = Color.Black)
        }
        TextField(
            vm.userName,
            textStyle = TextStyle(fontSize =  28.sp),
            onValueChange = {vm.changeName(it)}
        )
    }
    if (progress > 1f){
        AlertDialog(
            onDismissRequest = {progress < 1f},
            title = { Text(text = "Результат") },
            text = { Column{
                Text("Вы сделали ${clickcount.value} нажатий за 30 секунд")
                Text("Ваша скорость равна ${clickcount.value / 30} символа(ов) в секунду")}},
            confirmButton = {
                Button({vm.changeResult("${clickcount.value}")
                    vm.addUser()
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))}) {
                    Text("Выход", fontSize = 22.sp)
                }
            }
        )
    }
}



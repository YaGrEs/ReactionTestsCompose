package com.example.jtpcmps

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jtpcmps.ui.theme.JTPCMPSTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent @OptIn(ExperimentalFoundationApi::class) {
            val mContext = LocalContext.current
            val toptext = listOf("Тест на скорость нажатия", "Тест на визуальный анализ")
            val information = listOf("Информация о первом тесте", "Информация о втором тесте")
            val testclasses = listOf(FirstTest::class.java, SecondTest::class.java)
            val pagerState = rememberPagerState { toptext.size }
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            var showSnackbarHost by remember { mutableStateOf(true) }

            HorizontalPager(state = pagerState, Modifier.fillMaxHeight()) { page ->
                    Scaffold(
                        snackbarHost = {
                            SnackbarHost(hostState = snackbarHostState)
                        },
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                text = { Text("Информация о тесте") },
                                icon = { Icon(Icons.Filled.Info, contentDescription = "") },
                                onClick = {
                                    scope.launch {
                                        showSnackbarHost = true
                                        if (showSnackbarHost){
                                            val info = snackbarHostState.showSnackbar(information[page], withDismissAction = true)
                                            when (info){
                                                SnackbarResult.ActionPerformed -> {}
                                                SnackbarResult.Dismissed -> { showSnackbarHost = false}
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    ) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .paint(
                                painterResource(id = R.drawable.back),
                                contentScale = ContentScale.FillBounds
                            ))
                        Column{
                            Text(toptext[page], fontSize = 60.sp, modifier= Modifier
                                .padding(it)
                                .padding(20.dp)
                                .align(Alignment.CenterHorizontally),
                                fontFamily = FontFamily(Font(R.font.alumnisans)),
                                color = Color.DarkGray, textAlign = TextAlign.Center,
                                style = TextStyle(shadow = Shadow(Color.LightGray , Offset(10.0f, 16.5f), 1.0f)))
                            Button(onClick = {mContext.startActivity(Intent(mContext, testclasses[page]))},
                                elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp, pressedElevation = 2.dp),
                                modifier = Modifier.height(80.dp).width(180.dp).align(Alignment.CenterHorizontally).offset(y = 100.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black),
                                border = BorderStroke(3.dp, Color.Black)
                            ){
                                Text("Начать", fontSize = 25.sp)
                            }
                        }
                        }

                        }

                    }
                }
            }
package com.vetoshkin.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import kotlin.concurrent.thread


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPart()
            MainPart1()
        }
    }
}

@Composable
fun MainPart(){
    BackArrow()
    Column {
        BackArrowRow()
        PutThings()
        AnyText()

    }
}

@Composable
fun MainPart1() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            ZoneA()
            OutlinedTextInput()
            CountInput()
            CellText(text = "Ячейка:     A01-01-1-1")
            HorizontalLine()
            CellText(text = "Конт.:      TE-0031533")
            HorizontalLine()
            ButtonBottom(text = "ВЕРНУТЬ КОНТЕЙНЕР В БУФЕР")
            ButtonBottom(text = "ПЛАН/ФАКТ")
        }
    }
}

@Composable
fun PutThings(){
    Text(
        text = "ПОЛОЖИТЬ 12 шт.",
        fontSize = 21.sp,
        fontWeight = FontWeight(700),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun AnyText(){
    Text(
        text = "MiNімі Носки жен. хлоп. СПОРТ ШИК 4300 с полоской Роса антико 39-41 ШК: 4680007214011\nSKU: 197603269784011",
        fontSize = 18.sp,
        fontWeight = FontWeight(400),
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    )
}

@Composable
fun BackArrowRow(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Размещение Товара",
                fontSize = 21.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(14.dp)
            )
        }
    }
}


@Composable
fun BackArrow(){
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun ZoneA(){
    Text(
        text = "Зона А",
        fontSize = 21.sp,
        fontWeight = FontWeight(750),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun OutlinedTextInput(){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = {Text(text = "Код:")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Green
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun CountInput(){
    Text(
        text = "Введите Количесво",
        fontSize = 26.sp,
        fontWeight = FontWeight(900),
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Composable
fun CellText(text: String){
    Text(
        text = text,
        fontSize = 19.sp,
        fontWeight = FontWeight(550),
        modifier = Modifier
            .fillMaxWidth()
            .padding(13.dp)
    )
}

@Composable
fun HorizontalLine(thickness: Int = 1){
    HorizontalDivider(
        thickness = thickness.dp,
        color = Color.Black,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun ButtonBottom(text: String){
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.LightGray
        )
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight(1000)
        )
    }
}

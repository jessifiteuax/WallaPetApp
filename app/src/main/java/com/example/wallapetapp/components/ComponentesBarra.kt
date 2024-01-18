package com.example.wallapetapp.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.wallapetapp.ui.theme.LemonFamily

@Composable
fun textoBarra(texto: String){
    Text(text = texto, fontSize = 24.sp, color = Color.White, fontFamily = LemonFamily)
}



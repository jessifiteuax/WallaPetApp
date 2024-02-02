package com.example.wallapetapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wallapetapp.ui.theme.LemonFamily

@Composable
fun textoBarra(texto: String){
    Text(text = texto, fontSize = 24.sp, color = Color.White, fontFamily = LemonFamily)
}

@Composable
fun iconoBarra(navController: NavHostController) {
    IconButton(onClick = { navController.popBackStack()})
    {
        Icon(imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White)
    }
}

@Composable
fun textoBarraBottom(texto: String){
    Text(text = texto, fontSize = 12.sp, color = Color.White, fontFamily = LemonFamily)
}

@Composable
fun iconoBarraUpdate(
    navigateBack: () -> Unit
) {
    IconButton(onClick = { navigateBack})
    {
        Icon(imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White)
    }
}
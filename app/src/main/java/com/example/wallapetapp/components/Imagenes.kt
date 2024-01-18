package com.example.wallapetapp.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.wallapetapp.R

@Composable
fun ImagenLogo() {
    Image(
        painter = painterResource(id = R.drawable.logowallapet),
        contentDescription = "logo",
        alpha = 0.2f
    )
}

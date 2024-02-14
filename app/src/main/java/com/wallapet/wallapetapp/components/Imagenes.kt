package com.wallapet.wallapetapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wallapet.wallapetapp.R

@Composable
fun ImagenLogo() {
    Image(
        painter = painterResource(id = R.drawable.logowallapet),
        contentDescription = "logo",
        alpha = 0.2f
    )
}

@Composable
fun ImagenLogoAcercaDe() {
    Image(
        painter = painterResource(id = R.drawable.logowallapet),
        contentDescription = "logo",
        modifier = Modifier.size(150.dp)
    )
}
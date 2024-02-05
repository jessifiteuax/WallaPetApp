package com.example.wallapetapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wallapetapp.R

@Composable
fun BotonVerMascotas(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("Mascotas") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC03D69),
            contentColor = Color.White,
        )
    ) {
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = stringResource(R.string.botonvermascotas),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")

    }
}

@Composable
fun BotonEntrarMascotas(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("EntrarMascotas") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC03D69),
            contentColor = Color.White
        )
    ) {
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = stringResource(R.string.botonentrarmascotas),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")
    }
}

@Composable
fun BotonVerConsejos(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("Consejos") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC03D69),
            contentColor = Color.White,
        )
    ) {
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Quiero ver consejos",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")

    }
}

@Composable
fun BotonVerContactos(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("Contactos") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC03D69),
            contentColor = Color.White,
        )
    ) {
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Contactos de interés",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")

    }
}








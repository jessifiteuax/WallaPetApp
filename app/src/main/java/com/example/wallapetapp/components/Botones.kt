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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            text = stringResource(R.string.quiero_ver_consejos),
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
            text = stringResource(R.string.contactos_de_inter_s),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(imageVector = Icons.Filled.Pets, tint = Color.White, contentDescription = "")

    }
}

@Composable
fun BotonDarkMode(darkMode: MutableState<Boolean>){
   /* Button(onClick = {darkMode.value = !darkMode.value}) {
        Text(text = "DarkMode", fontSize = 10.sp)
    }*/
    TextButton(onClick = {
        darkMode.value = !darkMode.value
    }, colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Transparent)
    ) {
        Text(text = "Dark\nMode")
    }
/*    var switched by remember { mutableStateOf(false) }

    Switch(checked = darkMode.value,
        onCheckedChange = {darkMode.value = !darkMode.value}
    )*/

}






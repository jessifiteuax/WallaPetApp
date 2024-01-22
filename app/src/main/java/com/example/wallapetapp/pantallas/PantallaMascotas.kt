package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.model.Mascotas
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.CaveatFamily
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.example.wallapetapp.viewModel.MascotasViewModel


//hacer una vista  scaffold recibiendo MascotasVM i pasarla a la funcion del view
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaMascotas(navController: NavHostController, mascotasVM: MascotasViewModel) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.mascotas)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar,
                )
            )
        },
        bottomBar = { BarraNav(navController = navController) }
    ) {
        ContenidoWallaMascotas()
    }
}

@Composable
fun ContenidoWallaMascotas() {
    //LazyColumn(verticalArrangement = Arrangement.SpaceEvenly){
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        ItemMascota()
        // items(){           //poner en los parentesis lo q llega de la consulta

        //}
    }
}

@Composable
fun ItemMascota() {         //tiene q venir de la BBDD el VM
    Column {
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logowallapet),
                contentDescription = "foto mascota"         //tiene q venir de la BBDD
            )
        }
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "nombre de la mascota",         //tiene q venir de la BBDD
                fontSize = 20.sp,
                fontFamily = CaveatFamily
            )
        }
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "codigo postal",         //tiene q venir de la BBDD
                fontSize = 20.sp,
                fontFamily = CaveatFamily,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "poblacion",         //tiene q venir de la BBDD
                fontSize = 20.sp,
                fontFamily = CaveatFamily,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "email",         //tiene q venir de la BBDD
                fontSize = 20.sp,
                fontFamily = CaveatFamily,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "observaciones",         //tiene q venir de la BBDD
                fontSize = 20.sp,
                fontFamily = CaveatFamily,
               modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }
}
/*fun ItemMascota() {    //poner en los parentesis la lista que llega de la consulta
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier.width(200.dp)) {
        Image(
            painter = painterResource(id = R.drawable.fotodefecto),
            contentDescription = "foto mascota",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "nombre de la mascota", //tiene q venir de la BBDD
            fontSize = 18.sp,
            fontFamily = CaveatFamily,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "codigo postal",            //tiene q venir de la BBDD
            fontSize = 12.sp,
            fontFamily = CaveatFamily,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
        )
        Text(
            text = "npoblacion",         //tiene q venir de la BBDD
            fontSize = 12.sp,
            fontFamily = CaveatFamily,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
        )
        Text(
            text = "mail contacto",         //tiene q venir de la BBDD
            fontSize = 12.sp,
            fontFamily = CaveatFamily,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
        )
        Text(
            text = "observaciones",         //tiene q venir de la BBDD
            fontSize = 12.sp,
            fontFamily = CaveatFamily,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
        )
    }
}*/
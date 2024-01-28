package com.example.wallapetapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wallapetapp.R
import com.example.wallapetapp.domain.model.Mascota

@Composable
fun MascotaCard(mascota: Mascota) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                TextoCardTitulos(texto = stringResource(R.string.nombre))
                TextoCardDatos(texto = mascota.nombre)
                TextoCardTitulos(texto = stringResource(R.string.poblacioncard))
                TextoCardDatos(texto = mascota.poblacion)
                TextoCardTitulos(texto = stringResource(R.string.codigo_postalcard))
                TextoCardDatos(texto = mascota.codPostal)
                TextoCardTitulos(texto = stringResource(R.string.emailcard))
                TextoCardDatos(texto = mascota.mail)
                TextoCardTitulos(texto = stringResource(R.string.observaciones))
                TextoCardDatos(texto = mascota.observaciones)
                TextoCardTitulos(texto = stringResource(R.string.fecha_de_entrada))
                TextoCardDatos(texto = mascota.fecha)
                TextoCardDatos(texto = mascota.foto)
            }
        }
    }
}
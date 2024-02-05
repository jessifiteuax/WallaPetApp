package com.example.wallapetapp.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.wallapetapp.model.Consejo
import com.example.wallapetapp.ui.theme.WallaColTopBar

@Composable
fun ConsejoCard(consejo: Consejo) {
    val context = LocalContext.current
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column {
            TextoCardTitulos(texto = consejo.titulo)
            TextoCardDatos(texto = consejo.descripcion)
            Spacer(modifier = Modifier.padding(5.dp))
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), thickness = 5.dp, color = WallaColTopBar
            )
            Row {
                Icon(imageVector = Icons.Outlined.Public, contentDescription = "Web", Modifier.weight(0.2f))
                Text(text = "Más información", Modifier
                    .weight(0.8f)
                    .clickable {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(consejo.webReferencia)
                    context.startActivity(intent)
                })
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }

}
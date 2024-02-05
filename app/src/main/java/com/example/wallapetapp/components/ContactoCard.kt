package com.example.wallapetapp.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.wallapetapp.model.Contacto
import com.example.wallapetapp.ui.theme.WallaColTopBar

@Composable
fun ContactoCard(contacto: Contacto) {
    val context = LocalContext.current
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column {
            TextoCardTitulos(texto = contacto.lugar)
            TextoCardDatos(texto = contacto.descripcion)
            Spacer(modifier = Modifier.padding(5.dp))
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), thickness = 5.dp, color = WallaColTopBar
            )
            Row {

                Icon(imageVector = Icons.Outlined.Phone, contentDescription = "Telf")
                Text(
                    text = "Llamar",
                    Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_DIAL)
                            intent.data = Uri.parse(contacto.telefono)
                            context.startActivity(intent)
                        },
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Icon(imageVector = Icons.Outlined.Mail, contentDescription = "mail")
                Text(
                    text = "Enviar email",
                    Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data= Uri.parse(contacto.mail)
                            }
                            context.startActivity(intent)
                        },
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
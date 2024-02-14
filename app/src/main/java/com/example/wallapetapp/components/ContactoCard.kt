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
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wallapetapp.R
import com.example.wallapetapp.model.Contacto
import com.example.wallapetapp.ui.theme.WallaColTopBar

@Composable
fun ContactoCard(contacto: Contacto) {
    val context = LocalContext.current
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 15.dp)
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
                    text = stringResource(R.string.llamar),
                    Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_DIAL)
                            intent.data = Uri.parse("tel:${contacto.telefono}")
                            context.startActivity(intent)
                        },
                )
                Spacer(modifier = Modifier.padding(10.dp))
                if(contacto.mail!=""){
                    Icon(imageVector = Icons.Outlined.Mail, contentDescription = "mail")
                    Text(
                        text = stringResource(R.string.enviar_email),
                        Modifier
                            .clickable {
                                val intent = Intent(Intent.ACTION_SENDTO)
                                intent.data= Uri.parse("mailto:${contacto.mail}")
                                context.startActivity(intent)
                            },
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
        }
    }
}
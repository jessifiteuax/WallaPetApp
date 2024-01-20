@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.wallapetapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoTexto(valor: String = "Desconocido", onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoTextoNum(valor: String = "", onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

@Composable
fun checkDatosOK(poblacion: String, codPostal: String, mail: String): Boolean {
    var estaChecked by remember { mutableStateOf(false) }
    var verAlerta by remember { mutableStateOf(false) }

    Box{
        Row(
            //modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            ) {
            Checkbox(
                checked = estaChecked,
                onCheckedChange = {
                    if(poblacion!= "" && codPostal != "" && mail!=""){
                        estaChecked = !estaChecked
                    }else{
                        verAlerta=true
                    }
                }
            )
            Text(text = stringResource(R.string.datos_correctos))
            if (verAlerta) {
            Advertencia(
                titulo = stringResource(R.string.cuidado),
                mensaje = stringResource(R.string.campos_imprescindibles),
                textoConfirm = stringResource(R.string.voy_a_ello),
                onConfirmClick = { verAlerta=false }) { }
             }
        }
    }
    return estaChecked
}



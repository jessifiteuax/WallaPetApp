package com.example.wallapetapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.ui.theme.WallaColTopBar



@Composable
fun TabsView(navController: NavHostController,  darkmode: MutableState<Boolean>) {

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(stringResource(R.string.ver_consejos), stringResource(R.string.ver_contactos))

    Column {
        TabRow(selectedTabIndex = selectedTab,
            containerColor = WallaColTopBar,
            contentColor = Color.White,
            indicator = { tabPosition ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPosition[selectedTab])
                )
            }
        )
        {
            tabs.forEachIndexed { index, title ->
                Tab(selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }
        when(selectedTab){
            0 -> WallaConsejos(navController, darkmode)
            1 -> WallaContactos(navController, darkmode)
        }
    }
}

@Composable
fun TabsView2(navController: NavHostController,  darkmode: MutableState<Boolean>) {

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(stringResource(R.string.ver_contactos), stringResource(R.string.ver_consejos))

    Column {
        TabRow(selectedTabIndex = selectedTab,
            containerColor = WallaColTopBar,
            contentColor = Color.White,
            indicator = { tabPosition ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPosition[selectedTab])
                )
            }
        )
        {
            tabs.forEachIndexed { index, title ->
                Tab(selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }
        when(selectedTab){
            0 -> WallaContactos(navController, darkmode)
            1 -> WallaConsejos(navController, darkmode)
        }
    }
}
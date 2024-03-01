package com.example.codelabnavigation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

enum class CupcakeScreen(){
    Start,
    Flavor,
    Pickup,
    Summary,
    PantallaEjemplo
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold (){
        innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CupcakeScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            composable(route = CupcakeScreen.Start.name){
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onNextButtonClicked = {cupcakeQuantity -> navController.navigate(CupcakeScreen.PantallaEjemplo.name)},
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(CupcakeScreen.Flavor.name){

            }
            composable(CupcakeScreen.Pickup.name){

            }
            composable(CupcakeScreen.Summary.name){
                SumaryScreen(
                    modifier = Modifier.fillMaxHeight(),
                    orderUiState = uiState
                ) {

                }
            }
        }
    }
}

private fun shareOrder(context: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}
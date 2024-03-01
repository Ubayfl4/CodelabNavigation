package com.example.codelabnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SelectOptionScreen(
    radioButtonList: List<String>,
    currentPrice: String,
    //navController:
    onSelectedChange: (String) -> Unit,
){
    var selectedOption by remember { mutableStateOf("")}
    var showError by remember { mutableStateOf(true)}
    val context = LocalContext.current

    radioButtonList.forEach{eachOption: String ->
        Column {
            Row(
                modifier = Modifier.selectable(
                    selected = true,
                    onClick = {
                        selectedOption = eachOption
                        onSelectedChange(selectedOption)
                    }
                )
            ){
                RadioButton(
                    selected = (selectedOption == eachOption),
                    onClick = {
                        selectedOption = eachOption
                        onSelectedChange(selectedOption)
                    }
                )
                Text(text = eachOption, modifier = Modifier.padding(start = 8.dp))
            }
        }
        if(showError){
            Text(text = )
        }
        Text(
            modifier = Modifier.padding(vertical = 40.dp, horizontal = 10.dp),
            text = "Has seleccionado: ${context.resources.getString(selectedOption)}"
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Precio: $currentPrice"
        )
        Button(onClick = onNavigatedNext()) {
            Text(text = "Siguiente")
        }
    }
}
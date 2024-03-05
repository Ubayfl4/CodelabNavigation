package com.example.codelabnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun SelectOptionScreen(
    radioButtonList: List<String>,
    currentPrice: String,
    onSelectedChange: (String) -> Unit,
    onCancelButtonClicked: () -> Unit,
    onNavigatedNext: () -> Unit
){
    var selectedOption by remember { mutableStateOf(radioButtonList[0])}
    var showError by remember { mutableStateOf(true)}
    val context = LocalContext.current
    Column {
        radioButtonList.forEach{eachOption: String ->
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

        Text(
            modifier = Modifier.padding(vertical = 40.dp, horizontal = 10.dp),
            text = "Has seleccionado: $selectedOption"
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Precio: $currentPrice"
        )
        Row {
            OutlinedButton(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .weight(1f),
                onClick =  onCancelButtonClicked
            ) {
                Text(stringResource(id = R.string.cancel))
            }
            Button(onClick = { onNavigatedNext() }, modifier = Modifier.weight(1f)) {
                Text(text = "Siguiente")
            }
        }
    }
}
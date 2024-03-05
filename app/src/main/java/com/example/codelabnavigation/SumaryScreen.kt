package com.example.codelabnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun SumaryScreen(
    modifier: Modifier,
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButton: (String, String) -> Unit
){
    Column(){
        Text(text = "Quantity")
        Text(text = "${orderUiState.quantity}")
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Text(text = "Flavor")
        Text(text = orderUiState.flavor)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Text(text = "Pick up date")
        Text(text = orderUiState.date)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Text(text = orderUiState.price)
        Row {
            OutlinedButton(
                modifier = Modifier.padding(vertical = 4.dp).weight(1f),
                onClick =  onCancelButtonClicked
            ) {
                Text(stringResource(id = R.string.cancel))
            }
            Button(
                modifier = Modifier.padding(vertical = 4.dp).weight(1f),
                onClick = {
                    val summary = "Q: ${orderUiState.quantity}, F: ${orderUiState.flavor}, P: ${orderUiState.price}"
                    onSendButton("Order #129322D", summary)
                }
            ) {
                Text(text = "Send to another app")
            }
        }
    }
}
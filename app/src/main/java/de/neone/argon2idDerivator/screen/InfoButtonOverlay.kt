package de.neone.argon2idDerivator.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.neone.argon2idDerivator.R


@Composable
fun InfoButtonOverlay() {
    var showInfo by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
    IconButton(
        onClick = { showInfo = true },
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(12.dp)
    ) {
        androidx.compose.material3.Icon(
            painter = painterResource(id = R.drawable.ic_info),
            contentDescription = "Info",
            tint = MaterialTheme.colorScheme.primary
        )
    }
        }

    if (showInfo) {
        InfoDialog(onClose = { showInfo = false })
    }
}
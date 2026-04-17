package de.neone.argon2idDerivator.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoDialog(onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        title = {
            Text("Hinweise zur Nutzung")
        },
        text = {
            Column {
                Text(
                    """
                    • Gib ein Master-Passwort ein, das du dir gut merken kannst.
                    • Ein Dienst- oder Plattformname erzeugt ein eindeutiges Passwort pro Plattform.
                    • Das Tool speichert keine Passwörter.
                    • Das abgeleitete Passwort wird aus Argon2id + Domain generiert.
                    • Wenn du es kopierst, bleibt es nur in deiner Zwischenablage.
                    """.trimIndent()
                )
            }
        },
        confirmButton = {
            Button(onClick = onClose) {
                Text("Ok")
            }
        },
        modifier = Modifier.padding(16.dp)
    )
}
package de.neone.argon2idDerivator.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun Argon2AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            background = Color(0xFF1F6E93),
            primary = Color(0xFF12568C),
            secondary = Color(0xFF5E9AC2)
        ),
        content = content
    )
}
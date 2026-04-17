package de.neone.argon2idDerivator.screen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Base64
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lambdapioneer.argon2kt.Argon2Kt
import com.lambdapioneer.argon2kt.Argon2Mode
import de.neone.argon2idDerivator.R

@Composable
fun Argon2Screen() {
    var masterPassword by remember { mutableStateOf("") }
    var saltKey by remember { mutableStateOf("") }
    var derivedPassword by remember { mutableStateOf("") }

    val context = LocalContext.current
    val argon2Kt = remember { Argon2Kt() }

    InfoButtonOverlay()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Icon",
            modifier = Modifier.size(200.dp)
                .padding(top = 24.dp)
        )

        Text(
            text = "Argon2id Passwort-Derivator",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "- N.E.O.N.E -",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = masterPassword,
            onValueChange = { masterPassword = it },
            label = { Text("Master-Passwort") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedTextField(
            value = saltKey,
            onValueChange = { saltKey = it },
            label = { Text("Schlüsselwort (z.B. amazon)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Button(
            onClick = {
                if (masterPassword.isEmpty() || saltKey.isEmpty()) {
                    Toast.makeText(context, "Beides ausfüllen!", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                try {
                    val hashResult = argon2Kt.hash(
                        mode = Argon2Mode.ARGON2_ID,
                        password = masterPassword.toByteArray(),
                        salt = saltKey.toByteArray(),
                        parallelism = 2,
                        tCostInIterations = 5,
                        mCostInKibibyte = 131072,
                        hashLengthInBytes = 32
                    )

                    val raw = ByteArray(hashResult.rawHash.remaining())
                    hashResult.rawHash.get(raw)

                    derivedPassword = Base64.encodeToString(
                        raw,
                        Base64.NO_WRAP
                    )

                } catch (_: Exception) {
                    Toast.makeText(context, "Schlüsselwort benötigt mind. 8 Zeichen", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Passwort ableiten")
        }

        if (derivedPassword.isNotEmpty()) {
            Text(
                text = "Das abgeleitete Passwort lautet:",
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = derivedPassword,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .background(
                        color = Color(0xFFC9B6DA),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
            )

            Button(
                onClick = {
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Passwort", derivedPassword)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(context, "Kopiert!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Kopieren")
            }

            Button(
                onClick = {
                    masterPassword = ""
                    saltKey = ""
                    derivedPassword = ""
                    Toast.makeText(context, "Zurück gesetzt!", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Alles zurücksetzen")
            }
        }
    }
}
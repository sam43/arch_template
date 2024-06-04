package android.template.ui.mymodel

import android.template.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MyModelScreen(modifier: Modifier = Modifier, viewModel: MyViewModel = hiltViewModel()) {
	val items by viewModel.uiState.collectAsStateWithLifecycle()
	if (items is MyModelUiState.Success) {
		MyModelScreen(
			items = (items as MyModelUiState.Success).data,
			onSave = viewModel::addMyModel,
			modifier = modifier
		)
	}
}

@Composable
internal fun MyModelScreen(
	items: List<String>,
	onSave: (name: String) -> Unit,
	modifier: Modifier = Modifier
) {
	Column(modifier) {
		var nameMyModel by remember { mutableStateOf("Compose") }
		Row(
			modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			TextField(
				value = nameMyModel,
				onValueChange = { nameMyModel = it }
			)
			
			Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameMyModel) }) {
				Text("Save")
			}
		}
		items.forEach {
			Text("Saved item: $it")
		}
	}
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
	MyApplicationTheme {
		MyModelScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
	}
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
	MyApplicationTheme {
		MyModelScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
	}
}
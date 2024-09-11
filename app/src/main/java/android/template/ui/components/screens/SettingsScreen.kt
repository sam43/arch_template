package android.template.ui.components.screens

import android.template.ui.components.utils.Screen
import android.template.ui.vms.MainViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MoreView(modifier: Modifier, navController: NavController, payLoad: List<String>, mainViewModel: MainViewModel = hiltViewModel()) {
	Text(
		text = "Hello from More Screen!",
		modifier = modifier
			.wrapContentSize(align = Alignment.Center)
			.clickable { navController.navigate(Screen.Profile(payLoad[0])) }
	)
}
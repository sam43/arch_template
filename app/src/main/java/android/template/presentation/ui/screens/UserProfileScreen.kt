package android.template.presentation.ui.screens

import android.template.presentation.ui.utils.Screen
import android.template.presentation.vms.MainViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun ProfileView(modifier: Modifier, navController: NavController, userName: String, viewModel: MainViewModel = hiltViewModel()) {
	val moreData = listOf("Themes", "Logout", "Privacy", "Help")
	val info = "Hello $userName! and Age = ${viewModel.userAgeData.collectAsState().value}"
	Text(
		text = info,
		modifier = modifier
			.wrapContentSize(align = Alignment.Center)
			.clickable {
				navController.navigate(Screen.More(moreData))
			}
	)
}
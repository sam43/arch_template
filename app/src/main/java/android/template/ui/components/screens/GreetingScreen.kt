package android.template.ui.components.screens

import android.template.ui.components.utils.Screen
import android.template.ui.vms.MainViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

/**
 * 1. Please try to use provided convention "<your_screen_name>Screen" which will be visible on UI or Device screen
 * 2. If you have nested UI/Views under as single screen name them as "<sub_view_name>View" under the same folder;
 * preferably create a package of screen and add fragments/views under that package to easy findings
 * */

@Composable
fun GreetingView(name: String, modifier: Modifier = Modifier, navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
	val scope = rememberCoroutineScope()
	Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
		Column(modifier = modifier.wrapContentSize(align = Alignment.Center)) {
			Text(
				text = "Hello $name!",
				modifier = modifier
			)
			Button(onClick = {
				navController.navigate(Screen.Profile("Rakuten"))
				// sample of setting user age using viewmodel
				scope.launch { mainViewModel.updateUserAgeData(25) }
			}) {
				Text(
					text = "Profile"
				)
			}
		}
	}
}
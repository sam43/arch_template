package android.template.ui.components

import android.template.core_ui.theme.ArchitectureTemplateTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun MainNavigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = Screen.Main, modifier = Modifier) {
		composable<Screen.Main> {
			// TODO:: Add sample view
			Greeting(name = "Android", navController = navController)
		}
		composable<Screen.Profile> {backstackEntry ->
			// TODO:: Get arguments
			val data = backstackEntry.toRoute<Screen.Profile>().userName
			// TODO:: Add sample view
			ProfileScreen(modifier = Modifier, navController = navController, userName = data)
		}
		composable<Screen.More> {backstackEntry ->
			// TODO:: Get arguments/list
			val data = backstackEntry.toRoute<Screen.More>().settings
			// TODO:: Add sample view
			MoreScreen(modifier = Modifier, navController = navController, payLoad = data)
		}
	}
	
	// NOTE:: to navigate to other composable inside NavHost, use: navController.navigate(Screen.Profile("Rakuten Taro"))
}

@Composable
fun ProfileScreen(modifier: Modifier, navController: NavController, userName: String) {
	val moreData = listOf("Themes", "Logout", "Privacy", "Help")
	Text(
		text = "Hello $userName!",
		modifier = modifier
			.clickable { navController.navigate(Screen.More(moreData)) }
	)
}
@Composable
fun MoreScreen(modifier: Modifier, navController: NavController, payLoad: List<String>) {
	Text(
		text = "Hello from More Screen!",
		modifier = modifier
			.clickable { navController.navigate(Screen.Profile(payLoad[0])) }
	)
}
sealed interface Screen {
	@Serializable
	data object Main : Screen
	@Serializable
	data class Profile(val userName: String) : Screen
	@Serializable
	data class More(val settings: List<String>) : Screen
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, navController: NavController) {
	Column(modifier = modifier) {
		Text(
			text = "Hello $name!",
			modifier = modifier
		)
		Button(onClick = { navController.navigate(Screen.Profile("Rakuten")) }) {
			Text(
				text = "Profile"
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	val navController = rememberNavController()
	ArchitectureTemplateTheme {
		Greeting(name = "Android", navController = navController)
	}
}
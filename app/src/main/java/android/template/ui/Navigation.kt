package android.template.ui

import android.template.core_ui.theme.ArchitectureTemplateTheme
import android.template.ui.components.screens.GreetingView
import android.template.ui.components.screens.MoreView
import android.template.ui.components.screens.ProfileView
import android.template.ui.components.utils.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun MainNavigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = Screen.Main, modifier = Modifier) {
		composable<Screen.Main> {
			// NOTE:: Sample view added
			GreetingView(name = "Android", navController = navController)
		}
		composable<Screen.Profile>  { backstackEntry ->
			// NOTE:: Getting arguments from backstack entry
			val data = backstackEntry.toRoute<Screen.Profile>().userName
			// NOTE:: Sample view added and passing arguments
			ProfileView(modifier = Modifier, navController = navController, userName = data)
		}
		composable<Screen.More> { backstackEntry ->
			// NOTE:: Get arguments/list from backstack entry
			val data = backstackEntry.toRoute<Screen.More>().settings
			// NOTE:: Sample view added and passed the payloads
			MoreView(modifier = Modifier, navController = navController, payLoad = data)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	val navController = rememberNavController()
	ArchitectureTemplateTheme {
		GreetingView(name = "Android", navController = navController)
	}
}
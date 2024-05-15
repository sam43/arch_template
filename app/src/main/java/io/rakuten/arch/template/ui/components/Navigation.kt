package io.rakuten.arch.template.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainNavigation() {
	val navController = rememberNavController()
	
	NavHost(navController = navController, startDestination = "main") {
		composable("main") { MyModelScreen(modifier = Modifier.padding(16.dp)) }
		// TODO: Add more destinations
	}
}

@Composable
fun MyModelScreen(modifier: Modifier) {
	// TODO:: Add sample view
}

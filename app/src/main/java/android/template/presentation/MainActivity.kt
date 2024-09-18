package android.template.presentation

import android.os.Bundle
import android.template.core_ui.theme.ArchitectureTemplateTheme
import android.template.presentation.navigation.MainNavigation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Sadat Sayem
 * Whatever classes and dirs in this app module, is only for sample implementation
 * But it is recommended to use core module for Network and other base implementation
 * Samples here are pretty much for any basic project implementation like MVP version of the future project and so on.
 * */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ArchitectureTemplateTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					MainNavigation()
				}
			}
		}
	}
}
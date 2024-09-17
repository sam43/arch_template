package android.template.ui.components.utils

import kotlinx.serialization.Serializable


sealed interface Screen {
	@Serializable
	data object Main : Screen
	@Serializable
	data class Profile(val userName: String) : Screen
	@Serializable
	data class More(val settings: List<String>) : Screen
}
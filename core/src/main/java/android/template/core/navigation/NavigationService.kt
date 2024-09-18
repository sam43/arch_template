package android.template.core.navigation

interface NavigationService {
//	fun navigateTo(destination: String, navOptions: NavOptionsBuilder.() -> Unit = {}) // old implementation
	fun navigateTo()
	fun navigateFromDeeplink()
	fun goBack()
}
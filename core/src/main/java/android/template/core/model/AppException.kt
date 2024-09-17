package android.template.core.model

import java.io.IOException

data class AppException(
	override val message: String?,
	val hasUserFriendlyMessage: Boolean
) : IOException()
package android.template.core.domain.usecase

import android.template.core.utils.IODispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface CoroutineUseCaseRunner {
	@IODispatcher val useCaseCoroutineScope: CoroutineScope
	
	fun useCaseScope(
		loadingUpdater: ((Boolean) -> Unit)? = null,
		onError: ((Throwable) -> Unit)? = null,
		onComplete: (() -> Unit)? = null,
		block: (suspend () -> Unit)
	) {
		useCaseCoroutineScope.launch {
			loadingUpdater?.invoke(true)
			try {
				block()
			} catch (e: Exception) {
				onError?.invoke(e)
			} finally {
				loadingUpdater?.invoke(false)
				onComplete?.invoke()
			}
		}
	}
}
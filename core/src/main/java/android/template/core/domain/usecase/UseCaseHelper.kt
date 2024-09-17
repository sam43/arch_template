package android.template.core.domain.usecase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

/**
 * @see IUseCase
 * Uses:
 * The IUseCase class can be used when you need to perform some action or side effect in your application,
 * such as adding, updating, or deleting data in a database or calling HTTP methods like POST or PUT to an API.
 * @author Sadat Sayem
 * */

abstract class IUseCase<in P> {
	suspend operator fun invoke(params: P) {
		doWork(params)
	}
	
	protected abstract suspend fun doWork(params: P)
}

/**
 * @see IResultUseCase
 * Uses:
 * The IResultUseCase class can be used when you need to perform some work that returns a result, such as getting data from a database or an API.
 * By returning a Flow object, the result can be observed asynchronously and supports coroutines, making it easy to handle long-running operations.
 * @author Sadat Sayem
 * */

abstract class IResultUseCase<in P, R> {
	operator fun invoke(params: P): Flow<R> = flow {
		emit(doWork(params))
	}
	
	protected abstract suspend fun doWork(params: P): R
}

/**
 * @see IObservableUseCase
 * Uses:
 * This IObservableUseCase can be useful for scenarios where you need to observe changes in data
 * based on user input or other external factors. Eg: getting the data from database which return flow or livedata.
 * @author Sadat Sayem
 * */

@OptIn(ExperimentalCoroutinesApi::class)
abstract class IObservableUseCase<P : Any, T> {
	private val paramState = MutableSharedFlow<P>(
		replay = 1,
		extraBufferCapacity = 1,
		onBufferOverflow = BufferOverflow.DROP_OLDEST,
	)
	
	val flow: Flow<T> = paramState
		.flatMapLatest { createObservable(it) }
	
	operator fun invoke(params: P) {
		paramState.tryEmit(params)
	}
	
	protected abstract fun createObservable(params: P): Flow<T>
}

/**
 * @see ISuspendObservableUseCase
 * Uses:
 * The ISuspendObservableUseCase can be used when you need to perform a long-running operation that involves asynchronous calls,
 * such as network requests or database queries. By using this use case, you can create a stream of data that emits the results of
 * the operation as they become available. This allows you to easily update your UI or perform other actions in response to changes in the data.
 * For example, suppose you have an app that displays a list of products. You could use the ISuspendObservableUseCase to fetch the product data from an API
 * and create a stream of Product objects that is updated whenever the data changes. You could then use this stream to populate a RecyclerView or update a view in
 * response to changes in the data.
 * @author Sadat Sayem
 * */

abstract class ISuspendObservableUseCase<P : Any, T> : IObservableUseCase<P, T>() {
	override fun createObservable(params: P): Flow<T> = flow {
		emit(doWork(params))
	}
	
	abstract suspend fun doWork(params: P): T
}
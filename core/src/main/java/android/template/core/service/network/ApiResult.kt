package android.template.core.service.network

import retrofit2.HttpException
import retrofit2.Response

sealed interface ApiResult<R> {
	data class Success<R : Any>(val data: R) : ApiResult<R>
	data class Error<R : Any>(val code: Int, val message: String?) : ApiResult<R>
	data class Exception<R : Any>(val t: Throwable) : ApiResult<R>
}

suspend fun <R : Any> handleApi(
	execute: suspend () -> Response<R>
): ApiResult<R> = try {
	val response = execute.invoke()
	val body = response.body()
	if (response.isSuccessful && body != null)
		ApiResult.Success(body)
	else ApiResult.Error(code = response.code(), message = response.message())
} catch (e: HttpException) {
	ApiResult.Error(code = e.code(), message = e.message)
} catch (t: Throwable) {
	ApiResult.Exception(t)
}
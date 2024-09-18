package android.template.service

import retrofit2.http.GET

interface ApiService {
	@GET("sss")
	fun getDataFromRemote()
}
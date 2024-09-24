plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.ksp)
}

android {
	namespace = "android.template.core"
	compileSdk = libs.versions.compileSdk.get().toInt()
	
	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()
		
		testInstrumentationRunner = "android.template.core.testing.HiltTestRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	
	buildFeatures {
		aidl = false
		buildConfig = true
		renderScript = false
		shaders = false
	}
	
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	
	kotlinOptions {
		jvmTarget = "17"
	}
}

dependencies {
	implementation(project(":core-db"))
	implementation(project(":core-datastore"))
	
	// Arch Components
	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)
	implementation(libs.kotlinx.coroutines.android)
	implementation(libs.androidx.lifecycle.runtime.compose)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	
	// Retrofit2 and Okhttp3
	implementation(libs.retrofit)
	implementation(libs.retrofit.converter.moshi)
	implementation(libs.retrofit.coroutines.adapter)
	implementation(libs.moshi)
	ksp(libs.moshi.codegen)
	
	val okhttpBom = platform(libs.okhttp.bom)
	implementation(okhttpBom)
	implementation(libs.okhttp)
	implementation(libs.okhttp.logging.interceptor)
	
	// Moshi
	implementation(libs.moshi)
	implementation(libs.moshi.codegen)
	
	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)
}
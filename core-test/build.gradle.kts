plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.kapt)
}

android {
	namespace = "io.rakuten.arch.core_test"
	compileSdk = 34
	
	defaultConfig {
		minSdk = 21
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	buildFeatures {
		aidl = false
		buildConfig = false
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
	implementation(libs.androidx.test.runner)
	implementation(libs.hilt.android.testing)
	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)
	// UI and Instrumentation testing
	androidTestImplementation(libs.androidx.test.core)
	androidTestImplementation(libs.espresso.core)
}
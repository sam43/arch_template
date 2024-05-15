plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.kapt)
}

android {
	namespace = "android.template.core.data"
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
	implementation(project(":core-db"))
	implementation(project(":core-shared"))
	
	// Arch Components
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	
	implementation(libs.kotlinx.coroutines.android)
	
	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)
}
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
	
	// Arch Components
	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)
	
	implementation(libs.kotlinx.coroutines.android)
	
	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)
}
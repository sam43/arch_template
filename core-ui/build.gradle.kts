plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
}
android {
	namespace = "io.rakuten.arch.core_ui"
	compileSdk = 34
	
	defaultConfig {
		minSdk = 21
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	
	buildFeatures {
		compose = true
		aidl = false
		buildConfig = false
		renderScript = false
		shaders = false
	}
	
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
		// NOTE:: `composeOptions` won't be needed from kotlin 2.0 and new gradle system; update it when needed
		// ref: https://android-developers.googleblog.com/2024/04/jetpack-compose-compiler-moving-to-kotlin-repository.html
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
	val composeBom = platform(libs.androidx.compose.bom)
	implementation(composeBom)
	androidTestImplementation(composeBom)
	
	// Core Android dependencies
	implementation(libs.androidx.core.ktx)
	
	// Compose
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	// Tooling
	debugImplementation(libs.androidx.compose.ui.tooling)
	// Test
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.espresso.core)
}
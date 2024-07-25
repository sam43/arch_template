plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.hilt.gradle)
	alias(libs.plugins.ksp)
	alias(libs.plugins.kotlin.kapt)
	alias(libs.plugins.kotlin.serialization)
//	kotlin("jvm") version "2.0.0"
//	kotlin("plugin.serialization") version "2.0.0"
}

android {
	namespace = "android.template"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "android.template"
		minSdk = 21
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		vectorDrawables {
			useSupportLibrary = true
		}
		
		// Enable room auto-migrations
		ksp {
			arg("room.schemaLocation", "$projectDir/schemas")
		}
	}
	
	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	
	kotlinOptions {
		jvmTarget = "17"
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
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	implementation(project(":core-ui"))
	
	// Core Android dependencies
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	
	// Hilt Dependency Injection
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	
	// Arch Components
	implementation(libs.androidx.lifecycle.runtime.compose)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.navigation.compose)
	implementation(libs.androidx.hilt.navigation.compose)
	implementation(libs.kotlinx.serialization)
	
	// Compose
	val composeBom = platform(libs.androidx.compose.bom)
	implementation(composeBom)
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	
	// Tooling
	debugImplementation(libs.androidx.compose.ui.tooling)
	
	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)
}
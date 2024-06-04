plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.ksp)
	alias(libs.plugins.kotlin.kapt)
}

android {
	namespace = "android.template.core.db"
	compileSdk = 34
	
	defaultConfig {
		minSdk = 21
		
		testInstrumentationRunner = "android.template.core.testing.HiltTestRunner"
		consumerProguardFiles("consumer-rules.pro")
		
		// The schemas directory contains a schema file for each version of the Room database.
		// This is required to enable Room auto migrations.
		// See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
		ksp {
			arg("room.schemaLocation", "$projectDir/schemas")
		}
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
	// Arch Components
	implementation(libs.androidx.room.runtime)
	implementation(libs.androidx.room.ktx)
	ksp(libs.androidx.room.compiler)
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
}
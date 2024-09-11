plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.ksp)
}

android {
	namespace = "io.rakuten.arch.core.datastore"
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
	testOptions.unitTests {
			isIncludeAndroidResources = true
	}
}

dependencies {
	implementation(libs.datastore.proto)
	implementation(libs.datastore.sharedpref)
	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)
	
	testImplementation(libs.junit)
	testImplementation(libs.androidx.junit.ktx)
	testImplementation(libs.kotlinx.coroutines.test)
	
	testImplementation(libs.roboelectric)
	
	// MockK for jUnit
	testImplementation(libs.mockk)
	testImplementation(libs.mockk.android)
	testImplementation(libs.mockk.agent)
	
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.espresso.core)
	
	// Jupiter
	testImplementation(libs.jupiter.api)
	testRuntimeOnly(libs.jupiter.engine)
	
	// Instrumented tests: jUnit rules and runners
	androidTestImplementation(libs.androidx.test.core)
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.androidx.test.runner)
}
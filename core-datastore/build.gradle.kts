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
//		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		
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
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
			excludes += "META-INF/DEPENDENCIES"
			excludes += "META-INF/LICENSE.md"
			excludes += "META-INF/LICENSE.txt"
			excludes += "META-INF/LICENSE-notice.md"
			excludes += "META-INF/license.txt"
			excludes += "META-INF/NOTICE"
			excludes += "META-INF/ASL2.0"
			excludes += "META-INF/NOTICE.txt"
			excludes += "META-INF/notice.txt"
			excludes += "META-INF/*.kotlin_module"
		}
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
	testImplementation(libs.androidx.test.core)
	testImplementation(libs.androidx.test.ext.junit)
	testImplementation(libs.androidx.test.runner)
	
	// for androidTest
	androidTestImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit.ktx)
	androidTestImplementation(libs.kotlinx.coroutines.test)
	androidTestImplementation(libs.androidx.core.testing)
	
	androidTestImplementation(libs.roboelectric)
	
	// MockK for jUnit
	testImplementation(libs.mockk)
	testImplementation(libs.mockk.android)
	testImplementation(libs.mockk.agent)
	
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.espresso.core)
	
	// Jupiter
	androidTestImplementation(libs.jupiter.api)
	androidTestRuntimeOnly(libs.jupiter.engine)
	
	// Instrumented tests: jUnit rules and runners
	androidTestImplementation(libs.androidx.test.core)
	androidTestImplementation(libs.androidx.test.runner)
}
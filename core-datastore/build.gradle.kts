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
}

dependencies {
	implementation(libs.datastore.proto)
	implementation(libs.datastore.sharedpref)
	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.espresso.core)
}
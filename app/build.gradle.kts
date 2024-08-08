plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.android.compose)
	alias(libs.plugins.hilt.gradle)
	alias(libs.plugins.ksp)
	alias(libs.plugins.kotlin.serialization)
}

android {
	namespace = "android.template"
	compileSdk = libs.versions.compileSdk.get().toInt()
	
	defaultConfig {
		applicationId = "android.template"
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
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
	
//	TODO:: enable this after adding signingConfig.jks file and uncomment the signing config inside buildTypes { } as well
//	signingConfigs {
//		create("release") {
//			val properties = Properties().apply {
//				load(FileInputStream(File(rootProject.rootDir, "local.properties")))
//			}
//			val releaseKeyStorePath: String by project
//
//			storeFile = file(releaseKeyStorePath)
//			storePassword = properties.getProperty("releaseStorePassword")
//			keyAlias = properties.getProperty("releaseKeyAlias")
//			keyPassword = properties.getProperty("releaseKeyPassword")
//		}
//	}
	
	buildTypes {
		release {
			isDebuggable = false
			isMinifyEnabled = true
			isShrinkResources = true
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro", "retrofit2.pro")
//			signingConfig = signingConfigs.getByName("release")
		}
		debug {
			isDebuggable = true
			isMinifyEnabled = false
			isShrinkResources = false
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
	
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
	
	flavorDimensions.addAll(listOf("env", "usertype"))
	
	productFlavors {
		create("inspector") {
			dimension = "usertype"
		}
		create("user") {
			dimension = "usertype"
		}
		create("dev") {
			dimension = "env"
			applicationIdSuffix = ".dev"
			resValue("string", "package_name", android.defaultConfig.applicationId + applicationIdSuffix as String)
		}
		create("stage") {
			dimension = "env"
			applicationIdSuffix = ".stage"
			resValue("string", "package_name", android.defaultConfig.applicationId + applicationIdSuffix as String)
		}
		create("qa") {
			dimension = "env"
			applicationIdSuffix = ".qa"
			resValue("string", "package_name", android.defaultConfig.applicationId + applicationIdSuffix as String)
		}
		create("prod") {
			dimension = "env"
			resValue("string", "package_name", android.defaultConfig.applicationId as String)
			// todo:: to be added the firebaseDistribution functionalities for all variants
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
	ksp(libs.hilt.compiler)
	
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
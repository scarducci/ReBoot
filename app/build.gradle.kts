import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}



android {
    namespace = "com.example.reboot"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.reboot"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //noinspection GradleCompatible
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    //Parse SDK
    var parseVersion = "4.2.0"
    implementation("com.github.parse-community.Parse-SDK-Android:parse:$parseVersion")
    // for Google login/signup support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:google:$parseVersion")
    // for Facebook login/signup support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:facebook:$parseVersion")
    // for Twitter login/signup support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:twitter:$parseVersion")
    // for FCM Push support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:fcm:$parseVersion")
    // for Kotlin extensions support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:ktx:$parseVersion")
    // for Kotlin coroutines support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:coroutines:$parseVersion")
    // for RxJava support (optional)
    implementation("com.github.parse-community.Parse-SDK-Android:rxjava:$parseVersion")

    //JitPack Github package repository dependencies
    implementation("com.github.jitpack:android-example:1.0.1")

    //Google login integration include
    implementation("com.google.android.gms:play-services-auth:20.7.0")
}




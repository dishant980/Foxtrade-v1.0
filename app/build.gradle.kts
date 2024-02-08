plugins {
    id("com.android.application")
}

android {
    namespace = "com.fxt.exchange"
    compileSdk = 34

    defaultConfig {
            applicationId = "com.fxt.exchange"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
        viewBinding
        true
    }
}


dependencies {
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0-rc02")
    implementation("junit:junit:4.13.2")
    implementation("androidx.test.espresso:espresso-core:3.6.0-alpha02")
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.28")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.legacy:legacy-support-v13:1.0.0")
    implementation ("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation("com.google.android.material:material:1.12.0-alpha02")
    implementation("androidx.test.espresso:espresso-core:3.6.0-alpha02")
    //noinspection GradleCompatible
    implementation("com.android.support:design:28.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("com.hbb20:ccp:2.7.3")
    implementation("com.airbnb.android:lottie:6.3.0")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.android.instantapps.thirdpartycompat:volleycompat:1.0.0")
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //noinspection BomWithoutPlatform
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.12")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("androidx.browser:browser:1.8.0-beta01")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    implementation("androidx.gridlayout:gridlayout:1.1.0-beta01")
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    implementation("com.ouattararomuald:slider:3.0.1")
    implementation("com.github.bumptech.glide:glide:4.11.0")
}
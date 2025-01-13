plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listadetarefas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.listadetarefas"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
}

dependencies {

    // Dependências existentes
    implementation(libs.play.services.wearable)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Dependências integradas
    implementation ("com.google.android.gms:play-services-wearable:18.0.0")
    implementation ("androidx.core:core-splashscreen:1.0.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
}

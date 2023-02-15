import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
//    id("org.jetbrains.compose") version "1.2.1"
    application
}

group = "com.diacht.ktest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
      testImplementation(kotlin("test"))
}

sourceSets {
    named("main") {
        java.srcDir("./helloworld/src/main/kotlin/")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

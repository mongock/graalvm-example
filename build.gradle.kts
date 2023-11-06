plugins {
    `kotlin-dsl`
    `maven-publish`
    id("java")
}

group = "io.mongock.example.graalvm"
version = "1.0-SNAPSHOT"

apply {
    plugin("org.jetbrains.kotlin.jvm")

    plugin("maven-publish")
}


repositories {
    mavenCentral()
    mavenLocal()
}

val mongodbVersion = "4.3.3"
dependencies {
    implementation("io.mongock:mongock-standalone:5.3.5")
    implementation("io.mongock:mongodb-sync-v4-driver:5.3.5")

    implementation("org.mongodb:mongodb-driver-sync:$mongodbVersion")
    implementation("org.mongodb:mongodb-driver-core:$mongodbVersion")
    implementation("org.mongodb:bson:$mongodbVersion")

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.slf4j", "slf4j-api", "2.0.6")
    implementation("org.slf4j:slf4j-simple:2.0.6")


    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "io.mongock.example.graalvm.App"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.compileClasspath)
    from({
        configurations.compileClasspath.get().filter {
            it.name.endsWith("jar")
        }.map { zipTree(it) }
    })
}
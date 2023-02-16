import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "br.com.macari.cnpj"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.firebase:firebase-admin:7.1.0")
    implementation("com.mandrillapp.wrapper.lutung:lutung:0.0.8")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.springframework.data:spring-data-mongodb:3.3.0")
    implementation("com.amazonaws:aws-java-sdk-s3:1.11.327")
    implementation("com.amazonaws:aws-java-sdk-sqs:1.11.327")

    implementation("mysql:mysql-connector-java")

    implementation("com.tinder.statemachine:statemachine:0.2.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.discord4j:discord4j-core:3.2.0")
    implementation("net.dv8tion:JDA:5.0.0-alpha.3")

    implementation("org.mongodb:mongodb-driver-core:4.2.3")
    implementation("org.mongodb:bson:4.2.3")
    implementation("org.mongodb:mongodb-driver-sync:4.2.3")

    implementation("org.hibernate.validator:hibernate-validator:7.0.2.Final")
    implementation("io.netty:netty-common:4.1.75.Final")

    implementation("com.newrelic.telemetry:micrometer-registry-new-relic:0.5.0")
    implementation("com.newrelic.agent.java:newrelic-api:7.0.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("junit:junit:4.13.2")
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    bootJar {
        archiveFileName.set("alerts-api.jar")
    }
}

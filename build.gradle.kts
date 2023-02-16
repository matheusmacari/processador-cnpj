import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "br.com.macari"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("com.google.cloud:libraries-bom:24.3.0"))


    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.apache.commons:commons-lang3:3.0")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.firebase:firebase-admin:7.1.0")
    implementation("com.google.code.gson:gson:2.8.6")

    implementation("com.amazonaws:aws-java-sdk-s3:1.11.327")
    implementation("com.amazonaws:aws-java-sdk-sqs:1.11.327")

    implementation("com.google.cloud:google-cloud-storage")

    implementation("mysql:mysql-connector-java:8.0.29")

    implementation("com.h2database:h2")
    implementation("com.mandrillapp.wrapper.lutung:lutung:0.0.8")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    implementation("org.mongodb:mongodb-driver-core:4.2.3")
    implementation("org.mongodb:bson:4.2.3")
    implementation("org.mongodb:mongodb-driver-sync:4.2.3")

    implementation("org.springframework.boot:spring-boot-starter-parent:2.1.7.RELEASE")
    implementation("org.springframework.data:spring-data-mongodb:3.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.6.2")

    implementation("com.newrelic.telemetry:micrometer-registry-new-relic:0.5.0")
    implementation("com.newrelic.agent.java:newrelic-api:7.0.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")

    implementation("org.hibernate.validator:hibernate-validator:7.0.2.Final")
    implementation("io.netty:netty-common:4.1.75.Final")

    implementation("io.jsonwebtoken:jjwt-api:0.10.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.10.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.10.6")

    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
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
        archiveFileName.set("processador-cnpj.jar")
    }
}
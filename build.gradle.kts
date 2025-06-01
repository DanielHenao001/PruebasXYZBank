plugins {
    java
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.9.8"
}

repositories {
    mavenCentral()
}

dependencies {
    // Dependencias principales (disponibles para main y test)
    implementation("net.serenity-bdd:serenity-core:3.9.8")
    implementation("net.serenity-bdd:serenity-junit5:3.9.8")
    implementation("net.serenity-bdd:serenity-cucumber:3.9.8")
    implementation("net.serenity-bdd:serenity-screenplay:3.9.8")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:3.9.8")
    implementation("net.serenity-bdd:serenity-ensure:3.9.8")  // Para validaciones

    // Dependencias específicas de testing (solo para test)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.7")  // Logging
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
    testLogging {
        events("passed", "skipped", "failed")
    }
    include("**/*Runner.class")
}

serenity {
    reports = listOf("pretty", "html")
    testRoot = "runners"
}
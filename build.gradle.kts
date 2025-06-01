plugins {
    java
    id("io.github.serenity-bdd.serenity-gradle-plugin") version "3.6.12"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    testImplementation("net.serenity-bdd:serenity-junit:3.6.12")
    testImplementation("net.serenity-bdd:serenity-cucumber6:3.6.12") // o serenity-cucumber8 si usas Cucumber 8+
    testImplementation("io.cucumber:cucumber-junit:6.11.0")
    testImplementation("junit:junit:4.13.2")
}


tasks.test {
    useJUnitPlatform()
}

plugins {
    id("java")
}

group = "com.github.annaleighsmith"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")

}

tasks.test {
    useJUnitPlatform()
}
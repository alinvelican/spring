plugins {
    java
}

group = "springtest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation("org.springframework:spring-context:5.2.6.RELEASE")
    implementation( "org.springframework:spring-aop:5.2.6.RELEASE")
            implementation("org.aspectj:aspectjweaver:1.8.13")
            implementation("org.aspectj:aspectjrt:1.8.13")
}

configure<JavaPluginConvention> {
//    sourceCompatibility = JavaVersion.VERSION_1_8
}
plugins {
	kotlin("jvm") version "2.2.21"
	kotlin("plugin.spring") version "2.2.21"
	kotlin("plugin.jpa") version "2.2.21"
	id("org.springframework.boot") version "4.0.6"
	id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
	group = "com"
	version = "0.0.1-SNAPSHOT"
	description = "library-search"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}



	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
		}
	}

	extra["springCloudVersion"] = "2025.1.1"

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}


	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		implementation("org.springframework.boot:spring-boot-h2console")

		implementation("org.springframework.boot:spring-boot-starter-webmvc")
		implementation("tools.jackson.module:jackson-module-kotlin")

		testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.getByName("bootJar") {
		enabled = false
	}

	tasks.getByName("jar") {
		enabled = true
	}
}
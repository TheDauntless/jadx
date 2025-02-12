plugins {
	id("jadx-library")

	id("com.github.johnrengelman.shadow") version "8.1.1"
}

dependencies {
	api(project(":jadx-core"))

	// TODO: Switch back to upstream once this PR gets merged:
	//   https://github.com/FabricMC/mapping-io/pull/19
	// implementation 'net.fabricmc:mapping-io:0.3.0'
	api(files("libs/mapping-io-0.4.0-SNAPSHOT.jar"))

	constraints {
		runtimeOnly("org.ow2.asm:asm:9.5")
	}
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
			artifact(tasks["shadowJar"])
		}
	}
}

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

pluginManagement {
    // Include 'plugins build' to define convention plugins.
    includeBuild("build-logic")
}

rootProject.name = "antlr5-master"
include(":antlr5-core-runtime")
include(":antlr5-java-runtime")
include(":antlr5-kotlin-runtime")
include(":antlr5-tool")
include(":antlr5-maven-plugin")
include(":antlr5-runtime-testsuite")
include(":antlr5-tool-testsuite")

project(":antlr5-core-runtime").projectDir = file("runtime/Core")
project(":antlr5-java-runtime").projectDir = file("runtime/Java")
project(":antlr5-kotlin-runtime").projectDir = file("runtime/Kotlin")
project(":antlr5-tool").projectDir = file("tool")
project(":antlr5-runtime-testsuite").projectDir = file("runtime-testsuite")
project(":antlr5-tool-testsuite").projectDir = file("tool-testsuite")

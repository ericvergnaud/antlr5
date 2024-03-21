/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

import kotlin.io.path.*

plugins {
    id("buildlogic.java-conventions")
    antlr
}

dependencies {
    antlr("org.antlr:antlr:3.5.3")
    api(project(":antlr5-core-runtime"))
    api(project(":antlr5-java-runtime"))
    api(libs.org.antlr.antlr.runtime)
    api(libs.org.antlr.st4)
    api(libs.org.abego.treelayout.org.abego.treelayout.core)
    api(libs.com.ibm.icu.icu4j)
}

description = "ANTLR 5 Tool"

abstract class CleanupAntlr3GeneratedSource : DefaultTask() {

    @get:InputFiles
    abstract val directory: DirectoryProperty

    @TaskAction
    fun cleanup() {
        val path = directory.get().getAsFile().toPath()
        path.listDirectoryEntries("*.java").forEach(this::cleanupOneFile)
    }

    fun cleanupOneFile(path: java.nio.file.Path) {
        println("Cleaning-up v3 generated source: " + path)
        var text = path.toFile().readText(Charsets.UTF_8)
        val replacements = listOf(Pair("(// .ANTLR .+) ....-..-.. ..:..:..", "$1"),
            Pair("(// elements: ).*", "$1"))
        replacements.forEach({ pair: Pair<String, String> -> text = text.replace(pair.first, pair.second) })
        path.toFile().writeText(text, Charsets.UTF_8)
    }

}

tasks.register<CleanupAntlr3GeneratedSource>("cleanupGeneratedCode") {
    dependsOn(":antlr5-tool:generateGrammarSource")
    directory = file("${layout.buildDirectory.get()}/generated-src/antlr/main/org/antlr/v5/codegen/")
}

tasks.register<CleanupAntlr3GeneratedSource>("cleanupGeneratedParsers") {
    dependsOn(":antlr5-tool:generateGrammarSource")
    directory = file("${layout.buildDirectory.get()}/generated-src/antlr/main/org/antlr/v5/parse/")
}


tasks.named("compileJava") {
    dependsOn("cleanupGeneratedCode", "cleanupGeneratedParsers")
}
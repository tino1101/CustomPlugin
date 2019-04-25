package com.example.plugins.config

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import groovy.swing.impl.DefaultAction
import groovy.xml.Namespace
import groovy.xml.StreamingDOMBuilder

class ConfigTask extends DefaultTask {

    static final String CONFIG_CENTER_URL = "http://127.0.0.1:8080/config-center-0.0.1-SNAPSHOT/";

    @TaskAction
    void download() {

        def names = project.configPluginExtension.name;
        def version = project.configPluginExtension.version;

        names.each { name ->

            def inputStream = new URL(CONFIG_CENTER_URL + name).openStream();

            println ("${project.projectDir} , ${project.buildDir}, ${project.rootDir}, ${project.resources}");

            def file = new File("${project.projectDir}/src/main/resources/${name}");
            file.withOutputStream {
                outputStream ->
                    outputStream << inputStream;
            }
        }
    }

}
package com.example.plugins.config

import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.extensions.create("configPluginExtension", ConfigPluginExtension)
        project.task("configTask", type: ConfigTask)
    }
}
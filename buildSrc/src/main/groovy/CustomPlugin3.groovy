import org.gradle.api.Plugin;
import org.gradle.api.Project;

class CustomPlugin3 implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('CustomPluginTask3') {
            doLast {
                println "CustomPlugin3"
            }
        }
    }
}
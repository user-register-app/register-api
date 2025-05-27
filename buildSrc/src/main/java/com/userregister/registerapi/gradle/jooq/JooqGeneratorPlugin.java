package com.userregister.registerapi.gradle.jooq;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

public class JooqGeneratorPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        TaskContainer tasks = project.getTasks();
        tasks.create("generateJooqData", JooqGeneratorTask.class);
    }
}


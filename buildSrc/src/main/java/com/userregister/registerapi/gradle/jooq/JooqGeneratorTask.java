package com.userregister.registerapi.gradle.jooq;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JooqGeneratorTask extends DefaultTask {
    private static final Logger logger = LoggerFactory.getLogger(JooqGeneratorTask.class);

    public String jdbcUrl = "";
    public String username = "";
    public String password = "";
    public String dbName = "";
    public String sqlDriver = "";

    @TaskAction
    public void generateJooqData() {
        downloadDriver();
        jooqGenerate();
    }

    private void downloadDriver() {
        try {
            Class.forName(sqlDriver);
        } catch (Exception e) {
            logger.error("Error when download {}", sqlDriver, e);
        }
    }

    private void jooqGenerate() {
        try {
            var path = getProject().getRootDir().getAbsolutePath() + "/infrastructure/database/src/main/java";

            Configuration configuration = new Configuration()
                    .withJdbc(new Jdbc()
                            .withDriver("org.postgresql.Driver")
                            .withUrl(jdbcUrl + "/" + dbName)
                            .withUser(username)
                            .withPassword(password))
                    .withGenerator(new Generator()
                            .withName("org.jooq.codegen.JavaGenerator")
                            .withGenerate(new Generate()
                                    .withRecords(true)
                                    .withJavaTimeTypes(true)
                                    .withIndexes(false)
                                    .withKeys(false)
                                    .withSerializableInterfaces(false))
                            .withDatabase(new Database()
                                    .withName("org.jooq.meta.postgres.PostgresDatabase")
                                    .withIncludes("")
                                    .withExcludes("flyway_schema_history")
                                    .withSchemata(new SchemaMappingType()
                                            .withInputSchema("public")))
                            .withTarget(new Target()
                                    .withPackageName("com.userregister.readerapi.database.jooq")
                                    .withDirectory(path)));

            GenerationTool.generate(configuration);
        } catch (Exception e) {
            logger.error("Error during generation JOOQ data", e);
        }
    }
}

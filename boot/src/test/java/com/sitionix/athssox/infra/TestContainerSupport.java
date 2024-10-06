package com.sitionix.athssox.infra;

import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;

@TestConfiguration
public class TestContainerSupport {

    private static final String POSTGRES_SERVICE_NAME = "postgresql";

    private static final Integer POSTGRES_SERVICE_PORT = 5432;

    private static DockerComposeContainer<?> composeContainer;

    static {
        final Boolean localContainers = Boolean.parseBoolean(System.getenv("LOCAL_CONTAINERS"));

        if (!localContainers) {
            composeContainer = new DockerComposeContainer<>(new File(ClassLoader.getSystemResource("compose/docker-compose.yml").getPath()));
            startCompose();
        }
    }

    public static void startCompose() {
        printLogs();

        composeContainer.withExposedService(POSTGRES_SERVICE_NAME, POSTGRES_SERVICE_PORT);

        composeContainer.start();

        waitScriptExecutions();
    }

    public static void waitScriptExecutions() {
        composeContainer.waitingFor(POSTGRES_SERVICE_NAME,
                Wait.forListeningPort().withStartupTimeout(Duration.ofMinutes(2)));
    }

    public static void printLogs() {
        final Slf4jLogConsumer consumer = new Slf4jLogConsumer(LoggerFactory.getLogger(TestContainerSupport.class));

        composeContainer.withLogConsumer(POSTGRES_SERVICE_NAME, consumer);
    }

}

package com.kasunjay.springtemporal.config;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: kasun
 * @Package: com.kasunjay.springtemporal.config
 * @Class: TemporalConfig
 * @Created on: 8/13/2025 at 10:52 PM
 */
@Configuration
public class TemporalConfig {
    /**
     * Creates and configures a WorkerFactory for Temporal workflows.
     * Registers the TravelWorkflow and its activities to the specified task queue.
     *
     * @param serviceStubs Temporal service stubs for communication with the Temporal service
     * @return Configured WorkerFactory instance
     */
    @Bean
    public WorkerFactory workerFactory(WorkflowServiceStubs serviceStubs) {
        WorkflowClient client = WorkflowClient.newInstance(serviceStubs);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("TRAVEL_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(null);
        worker.registerActivitiesImplementations(null);

        return factory;
    }

    /**
     * Provides a WorkflowServiceStubs bean for connecting to the Temporal service.
     *
     * @return WorkflowServiceStubs instance
     */
    @Bean
    public WorkflowServiceStubs serviceStubs() {
        return WorkflowServiceStubs.newInstance();
    }

    /**
     * Starts the Temporal worker after the Spring context is initialized.
     */
    @PostConstruct
    public void startWorker() {
        workerFactory(serviceStubs()).start();
    }
}

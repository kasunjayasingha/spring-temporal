package com.kasunjay.springtemporal.config;

import io.temporal.worker.WorkerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Starts Temporal workers when the Spring application is ready.
 */
@Component
public class TemporalWorkerStarter {

    private final WorkerFactory workerFactory;

    public TemporalWorkerStarter(WorkerFactory workerFactory) {
        this.workerFactory = workerFactory;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startWorkers() {
        Thread starterThread = new Thread(() -> {
            while (true) {
                try {
                    workerFactory.start();
                    return;
                } catch (Exception ex) {
                    // Temporal server might not be up yet. Retry with backoff.
                    try {
                        Thread.sleep(2_000);
                    } catch (InterruptedException ignored) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }, "temporal-worker-starter");
        starterThread.setDaemon(true);
        starterThread.start();
    }
}



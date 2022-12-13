package com.mycompany.app;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChatOpenAIExecutors {
        public static void main(String[] args) {
            // Create a fixed thread pool with 5 threads
            Executor executor = Executors.newFixedThreadPool(5);

            // Submit 10 tasks for execution
            for (int i = 0; i < 10; i++) {
                Runnable task = () -> System.out.println("Running task " + Thread.currentThread().getName());
                executor.execute(task);
            }
        }
}
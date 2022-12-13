package com.mycompany.app;

import java.time.Duration;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class VirtualThread {
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World! " + new Date());

        Runnable runnable = () -> {
            var currentThread = Thread.currentThread();
            var threadType = currentThread.isVirtual() ? "VIRTUAL" : "PLATAFORM";
            var message = String.format("Current Thread - thread id: %s - thread name %s - thread type: %s", currentThread.threadId(), currentThread.getName(), threadType);
            System.out.println(message);
            try {
                System.out.println("Sleeping the thread: ".concat(currentThread.getName()));
                Thread.sleep(Duration.ofSeconds(30));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var firstThread = Thread.ofPlatform().name("myFirstThread").start(runnable);
        var secondThread = Thread.ofVirtual().name("mySecondThread").start(runnable);


        System.out.println("End " + new Date());

    }
}

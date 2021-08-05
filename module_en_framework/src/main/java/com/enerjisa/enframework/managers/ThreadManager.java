package com.enerjisa.enframework.managers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 8.01.2021 - 16:55
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public final class ThreadManager {


    private final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    private final int KEEP_ALIVE_TIME = 1;

    private final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final ExecutorService executorService = new ThreadPoolExecutor(NUMBER_OF_CORES,
            30,//NUMBER_OF_CORES * 2,
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            taskQueue);

    @Inject
    ThreadManager() {
    }


    public void execute(Runnable runnable) {

        executorService.execute(runnable);
    }


//    private static class BackgroundThreadFactory implements ThreadFactory {
//        private static int sTag = 1;
//
//        @Override
//        public Thread newThread(Runnable runnable) {
//            Thread thread = new Thread(runnable);
//            thread.setName("CustomThread" + sTag);
//            thread.setPriority(Process.THREAD_PRIORITY_BACKGROUND);
//
//            // A exception handler is created to log the exception from threads
//            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                @Override
//                public void uncaughtException(Thread thread, Throwable ex) {
//                    RDALogger.error(" encountered an error: " + ex.getMessage());
//                }
//            });
//            return thread;
//        }
//    }
}

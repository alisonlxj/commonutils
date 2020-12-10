package com.alison.commonutils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lixianjun02
 * @ClassName ConcurrencyUtils
 * @Description ...
 * @Date 2020/11/22 10:58 上午
 **/
public class ConcurrencyUtils {


    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrencyUtils.class);

    private static final String DEFAULT_THREAD_NAME_REGEX = "Thread-[0-9]+";

    private static final ExecutorService CACHE_THREAD_POOL = Executors.newCachedThreadPool();


    private ConcurrencyUtils() {
    }


    private static void ________________________getStuff________________________() {
    }


    public static Thread getCurrentThread() {
        return Thread.currentThread();
    }

    public static Long getCurrentThreadId() {
        return getCurrentThread().getId();
    }

    public static String getCurrentThreadName() {
        return getCurrentThread().getName();
    }

    public static ClassLoader getCurrentThreadClassLoader() {
        return getCurrentThread().getContextClassLoader();
    }

    /**
     * current state
     *
     * @return NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
     */
    public static Thread.State getCurrentThreadState() {
        return getCurrentThread().getState();
    }


    public static ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = getCurrentThread().getThreadGroup();

        if (null != threadGroup.getParent()) {
            threadGroup = threadGroup.getParent();
        }

        return threadGroup;
    }


    public static Thread[] getAllAliveThreads() {
        ThreadGroup rootThreadGroup = getRootThreadGroup();

        // rootThreadGroup.activeCount() is a estimate number
        // thread count might change between allocating the array and calling rootThreadGroup.enumerate()
        Thread[] tempThreadArray = new Thread[rootThreadGroup.activeCount() * 2];

        int enumerate = rootThreadGroup.enumerate(tempThreadArray);

        Thread[] actualThreadArray = new Thread[enumerate];
        System.arraycopy(tempThreadArray, 0, actualThreadArray, 0, enumerate);

        return actualThreadArray;
    }


    private static void ________________________printStuff________________________() {
    }

    /**
     * don't use static synchronized method or synchronized block with "ThreadUtils.class" as the lock.
     */
    private static class PrintLock {
    }


    public static void printThread(Thread thread) {

        String theadGroupName = thread.getState() == Thread.State.TERMINATED ? "none" : thread.getThreadGroup().getName();

        LOGGER.info(
                String.format("threadGroup [%s] thread [%s] id [%s], state [%s]",
                        theadGroupName,
                        thread.getName(),
                        thread.getId(),
                        thread.getState()));
    }


}





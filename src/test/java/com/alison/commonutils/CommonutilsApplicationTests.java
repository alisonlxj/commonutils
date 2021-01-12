package com.alison.commonutils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class CommonutilsApplicationTests {

    @Test
    void contextLoads() {
    }


    static void test01_multiThreads(){

        List<Callable<String>> tasks = Lists.newArrayList();

        tasks.add(() -> {
            System.out.println("thread-01 -> start:" + System.currentTimeMillis());
            return "thread-01";
        });

        tasks.add(() -> {
            Thread.sleep(1000L);
            System.out.println("thread-02 -> start:" + System.currentTimeMillis());
            throw new Exception();
        });

        tasks.add(() -> {
            Thread.sleep(100L);
            System.out.println("thread-03 -> start:" + System.currentTimeMillis());
            return "thread-03";
        });

        System.out.println("main thread 01-> " + System.currentTimeMillis());

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Future<String>> collect = tasks.stream().map(t -> executorService.submit(t)).collect(Collectors.toList());

        System.out.println("main thread 02-> " + System.currentTimeMillis());

        collect.stream().map(fu -> tryCatch(() -> fu.get())).forEach(System.out::println);

    }


    static void test02_multiThreadsV2() {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread-01 -> start:" + System.currentTimeMillis());
            return "thread-01";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-02 -> start:" + System.currentTimeMillis());
            return "thread-02";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-03 -> start:" + System.currentTimeMillis());
            return "thread-03";
        });


        System.out.println("main thread 01-> " + System.currentTimeMillis());


        System.out.println("main thread 02-> " + System.currentTimeMillis());

        System.out.println(tryCatch(() -> future1.get()));
        System.out.println(tryCatch(() -> future2.get()));
        System.out.println(tryCatch(() -> future3.get()));


    }



    public static void main(String[] args) {
//        test01_multiThreads();
        test02_multiThreadsV2();
    }




    static <T> T tryCatch(Callable<T> var) {
        try {

            return var.call();

        } catch (Throwable th) {
            System.out.println("出错信息:" + th.toString() + ";\nCause:" + th.getCause());
        }
        return null;
    }

}

package com.alison.commonutils;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class CommonutilsApplicationTests {

    @Test
    void contextLoads() {

        List<Callable<String>> tasks = Lists.newArrayList();
        tasks.add(() -> "342");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future1 = executorService.submit(() -> System.out.println("32423"));
        Future<String> future2 = executorService.submit(() -> "534523");

        executorService.execute(() -> System.out.println("12345"));

//        Object o = future1.get();


    }




    private void _______________test_support_____________(){}



}

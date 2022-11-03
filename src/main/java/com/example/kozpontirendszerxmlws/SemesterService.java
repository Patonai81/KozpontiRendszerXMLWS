package com.example.kozpontirendszerxmlws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SemesterService {

    @Async
    public CompletableFuture<Integer> getFinancedSemesterNumber(Long externalStudentId) {
        String methodName = "getFinancedSemesterNumber Service";
        log.info("Thread name: " + Thread.currentThread().getName());

        Random random = new Random();
        int result = random.nextInt(0, 10);
        log.info("Returned remaining " + result + " for student " + externalStudentId);
        return CompletableFuture.completedFuture(result);
    }

}

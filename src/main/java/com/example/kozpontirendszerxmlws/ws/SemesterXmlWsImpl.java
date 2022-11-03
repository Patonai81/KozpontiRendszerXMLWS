package com.example.kozpontirendszerxmlws.ws;


import com.example.kozpontirendszerxmlws.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;
import org.springframework.stereotype.Service;

import javax.xml.ws.AsyncHandler;
import java.util.Random;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
@Slf4j
public class SemesterXmlWsImpl implements SemesterXmlWs {

    private final SemesterService semesterService;


    @UseAsyncMethod
    @Override
    public int getFinancedSemesterNumber(Long externalStudentId) {
        log.info("Sync method....");
        return 0;
    }


    public Future<Integer> getFinancedSemesterNumberAsync(Long externalStudentId, AsyncHandler<Integer> asyncHandler) {
        log.info("REAL ASYNC");
        log.info("Thread name controller: " + Thread.currentThread().getName());
        ServerAsyncResponse<Integer> response = new ServerAsyncResponse<>();
        semesterService.getFinancedSemesterNumber(externalStudentId).thenAccept(asyncResp -> {
            log.info("HANDLER Thread name controller: " + Thread.currentThread().getName());
            response.set(asyncResp);
            asyncHandler.handleResponse(response);
        });

        return response;

    }

}

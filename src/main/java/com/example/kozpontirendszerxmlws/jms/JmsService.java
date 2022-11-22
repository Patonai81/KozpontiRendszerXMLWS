package com.example.kozpontirendszerxmlws.jms;

import hu.webuni.studentregister202210.dto.FinancedSemesterRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Slf4j
@Service
public class JmsService {

    @Autowired
    private  JmsTemplate jmsTemplate;
    private static final Random random = new Random();
    public static final String REQUEST_QUEUE="SEMESTER_IN";



    public void remaining(FinancedSemesterRequestDTO financedSemesterRequestDTO, String replyTo){
        Long amount = random.nextLong(10L);
        jmsTemplate.convertAndSend(new ActiveMQTopic(replyTo.substring(8)),new FinancedSemesterRequestDTO(financedSemesterRequestDTO.getStudentId(), amount));
        log.info("Payment has been succesfully sent....");
    }


    @Transactional
    @JmsListener(destination = REQUEST_QUEUE, containerFactory = "queueListenerContainerFactory")
    public void onPayment(@Payload FinancedSemesterRequestDTO financedSemesterRequestDTO, @Header(JmsHeaders.REPLY_TO) String replyTo) {
        log.info("Message arrived" + financedSemesterRequestDTO);
        log.info("Header: "+replyTo);
        remaining(financedSemesterRequestDTO, replyTo);

    }

}

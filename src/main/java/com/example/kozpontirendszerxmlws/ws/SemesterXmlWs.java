package com.example.kozpontirendszerxmlws.ws;


import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

@WebService
public interface SemesterXmlWs {

    @ResponseWrapper(localName = "getFinancedSemesterNumberResponse", className = "java.lang.Integer")
    int getFinancedSemesterNumber(Long externalStudentId);

}

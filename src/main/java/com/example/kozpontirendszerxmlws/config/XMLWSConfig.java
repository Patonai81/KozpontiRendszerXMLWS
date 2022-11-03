package com.example.kozpontirendszerxmlws.config;


import com.example.kozpontirendszerxmlws.ws.SemesterXmlWs;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class XMLWSConfig {

    private final Bus bus;
    private final SemesterXmlWs semesterXmlWs;

    @Bean
    public Endpoint publishEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,semesterXmlWs);
        endpoint.publish("/semester");
        return endpoint;
    }
}

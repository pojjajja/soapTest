package com.yagodamalinka.soap;


import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ContinentRepository extends WebServiceGatewaySupport {

    private final String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

    private static final Logger log = LoggerFactory.getLogger(ContinentRepository.class);

    public CountryNameResponse getCountryByISOCode (String isoCode) {

        CountryName request = new CountryName();
        request.setSCountryISOCode(isoCode);

        log.info(String.format("Ищем страну по ISO коду говна - " + isoCode));

        CountryNameResponse response = (CountryNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request);

        System.out.println(response);

        return response;
    }

}

package com.example.demoh2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import pl.p4.sso.clients.common.mocking.fasade.common.mocking.fasade.MockingFacade;
import pl.p4.sso.clients.common.mocking.fasade.common.mocking.fasade.impl.MockingFacadeImpl;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WireMockExample {

    private static final int CRM_WIREMOCK_PORT = 2222;
    private static MockingFacade crmMockingFacade;
    //private String START_URL = "/kyc/service/%s"; home
    private String START_URL = "/home";

    @LocalServerPort
    private int port;

    @PostConstruct
    public void postConstruct() {
        RestAssured.port = port;
    }

    @BeforeAll
    public static void setup() {
        crmMockingFacade = MockingFacadeImpl.of("crm", CRM_WIREMOCK_PORT);
    }

    @Test
    @Order(1)
    public void test_service_expect_valid_response_when_request_is_valid() {
        crmMockingFacade.loadAllMocks("getServiceCorrectResponse48668387295");

        String nonce = given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format(START_URL, ""))
                .then()
                .statusCode(200).toString();
    }
}

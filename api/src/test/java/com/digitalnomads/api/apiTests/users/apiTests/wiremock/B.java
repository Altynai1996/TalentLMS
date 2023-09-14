package com.digitalnomads.api.apiTests.users.apiTests.wiremock;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class B {


    private WireMockServer wireMockServer;

    @BeforeClass
    public void setUpWireMock() {
        // Define the desired port and host for WireMock
        int port = 8080;
        String host = "localhost";

        // Create and start the WireMock server with the specified configuration
        wireMockServer = new WireMockServer(port);
        wireMockServer.start();

        // Configure stubs for your tests
        stubFor(get(urlEqualTo("/api/resource"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"Hello, World!\"}")
                )
        );
    }

    @Test
    public void testWireMock() {
        // Your test code that interacts with the WireMock server

        Response response = RestAssured.given()
                .baseUri("http://localhost:8080")
                .get("/api/resource");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @AfterClass
    public void tearDownWireMock() {
        // Stop the WireMock server after your tests are complete
        wireMockServer.stop();
    }
}
package com.klezovich.demo.mockserver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockServerInitialTest {

    private static Integer MOCK_SERVER_PORT = 1080;
    private static ClientAndServer mockServer;

    private RestTemplate restTemplate = getRestTemplate();

    @BeforeClass
    public static void startServer() {
        mockServer = startClientAndServer(MOCK_SERVER_PORT);
    }

    @Test
    public void testMockServerGet() {
        configureMockServer();
        var response = restTemplate.getForObject("/test", String.class);
        assertThat(response, is("response_body"));
        mockServer.verify(request().withPath("/test").withMethod("GET"));
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
            .rootUri("http://localhost:" + MOCK_SERVER_PORT)
            .build();
    }

    private void configureMockServer() {
        new MockServerClient("localhost", MOCK_SERVER_PORT)
            .when(
                request()
                    .withMethod("GET")
                    .withPath("/test")
            ).respond(
            response()
                .withBody("response_body")
                .withHeader("content-type", "application/json")
        );
    }
}

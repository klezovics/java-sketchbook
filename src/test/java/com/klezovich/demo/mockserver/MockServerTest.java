package com.klezovich.demo.mockserver;

import org.junit.jupiter.api.BeforeAll;
import org.mockserver.integration.ClientAndServer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class MockServerTest {
    private static Integer MOCK_SERVER_PORT = 1080;
    private static ClientAndServer mockServer;

    protected RestTemplate restTemplate = getRestTemplate();

    @BeforeAll
    public static void startServer() {
        mockServer = startClientAndServer(MOCK_SERVER_PORT);
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
            .rootUri("http://localhost:" + MOCK_SERVER_PORT)
            .build();
    }
}

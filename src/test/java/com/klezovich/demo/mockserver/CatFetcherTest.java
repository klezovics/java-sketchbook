package com.klezovich.demo.mockserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class CatFetcherTest extends MockServerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testFetchCatData() {
        configureMockServerToReturnCatData();
        var cat = restTemplate.getForObject("/cat", Cat.class);
        assertThat(cat.getName(), is("Blacky"));
        assertThat(cat.getColor(), is("black"));
    }

    private void configureMockServerToReturnCatData() {
        try {
            new MockServerClient("localhost", MOCK_SERVER_PORT)
                .when(
                    request().
                        withPath("/cat")
                        .withMethod("GET")
                )
                .respond(response()
                    .withBody(objectMapper.writeValueAsString(new Cat("Blacky", "black")))
                    .withHeader("content-type", "application/json")
                );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    static class Cat {

        private String name;
        private String color;

        public Cat() {
        }

        public Cat(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}

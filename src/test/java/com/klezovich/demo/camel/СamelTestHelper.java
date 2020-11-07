package com.klezovich.demo.camel;

import org.apache.camel.component.mock.MockEndpoint;

import java.util.Map;

public class СamelTestHelper {

    static private Map getFirstMessageHeaders(MockEndpoint endpoint) {
        return getNthMessageHeaders(endpoint, 0);
    }

    static String getFirstMessageBody(MockEndpoint endpoint) {
        return getNthMessageBody(endpoint, 0);
    }

    static Map getNthMessageHeaders(MockEndpoint endpoint, int index) {
        return endpoint
            .getReceivedExchanges()
            .get(index)
            .getIn()
            .getHeaders();
    }

    static String getNthMessageBody(MockEndpoint endpoint, int index) {
        return endpoint
            .getReceivedExchanges()
            .get(index)
            .getIn()
            .getBody(String.class);
    }
}

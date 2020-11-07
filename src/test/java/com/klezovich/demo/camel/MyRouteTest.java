package com.klezovich.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MyRouteTest extends CamelTestSupport {

    @Test
    public void testSendingDataToMockEndpoint() throws InterruptedException {
        template.sendBody("direct:start", "This is the body");
        getMockEndpoint("mock:end").expectedMessageCount(1);
        getMockEndpoint("mock:xml").expectedMessageCount(0);
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                    // format inhouse to csv using a bean
                    // and save it to a file
                    .to("mock:end");
            }
        };
    }
}

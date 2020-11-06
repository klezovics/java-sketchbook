package com.klezovich.demo.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class FileSystemRoute extends RouteBuilder {

    private final static Logger log = LoggerFactory.getLogger(FileSystemRoute.class);

    @Override
    public void configure() throws Exception {
        from("file:data/in?noop=true")
            .routeId("MyFileSystemRoute")
            .bean(new GreeterBean(), "greet")
            .filter(new IsBodyEmpty())
            .log("Moving file ${header.CamelFileName}")
            .choice()
            .when(header("CamelFileName").endsWith(".json"))
            .log("Moving to out-json")
            .wireTap("file:data/json-backup")
            .to("file:data/out-json")
            .endChoice()
            .otherwise()
            .process(new ToUppercaseProcessor())
            .to("file:data/out")
            .log("Body is ${body}")
            .end();
    }

    static class GreeterBean {

        private final static Logger log = LoggerFactory.getLogger(GreeterBean.class);

        public void greet() {
            log.info("Hello from greeter bean!");
        }
    }

    static class IsBodyEmpty implements Predicate {

        @Override
        public boolean matches(Exchange exchange) {
            var body = exchange.getIn().getBody(String.class);
            return body.length() != 0;
        }
    }

    static class IsJsonPredicate implements Predicate {

        @Override
        public boolean matches(Exchange exchange) {
            return ((String) exchange.getIn().getHeader("CamelFileName")).endsWith(".json");
        }
    }

    static class ToUppercaseProcessor implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
            var oldFileBody = exchange.getIn().getBody(String.class);
            var newFileBody = oldFileBody.toUpperCase();
            exchange.getIn().setBody(newFileBody, String.class);
        }
    }
}

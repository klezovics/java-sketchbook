package com.klezovich.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileSorter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/sorter/in?noop=true")
            .routeId("FileSortingRoute")
            .log("Moving file ${header.CamelFileName}")
            .choice()
            .when(header("CamelFileName").endsWith(".json"))
            .to("file:data/sorter/json").endChoice()
            .when(header("CamelFileName").endsWith(".xml"))
            .to("file:data/sorter/xml").endChoice()
            .when(header("CamelFileName").endsWith(".txt"))
            .to("file:data/sorter/txt").endChoice();
    }
}

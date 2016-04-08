/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;


/**
 *
 * @author robert.jasny
 */
public class MySpringBootRouterTest extends CamelTestSupport {
 
    @EndpointInject(uri = "mock:lower")
    protected MockEndpoint lowerEndpoint;
    @EndpointInject(uri = "mock:greater")
    protected MockEndpoint greaterEndpoint;
 
    @Produce(uri = "direct:start")
    protected ProducerTemplate template;
 
    @Override
    public boolean isDumpRouteCoverage() {
        return true;
    }
 
    @Test
    public void testSendLowerMessage1() throws Exception {
        String p = "{\"amount\":1,\"message\":\"Lower message...\"}";

        lowerEndpoint.expectedBodiesReceived(p);
        lowerEndpoint.expectedMessageCount(1);
 
        template.sendBody(p);
 
        lowerEndpoint.assertIsSatisfied();
    }
    
    @Test
    public void testSendGreaterMessage10() throws Exception {
        String p = "{\"amount\":10,\"message\":\"Greater message...\"}";

        lowerEndpoint.expectedMessageCount(0);
        //lowerEndpoint.expectedBodiesReceived(p);
        greaterEndpoint.expectedBodiesReceived(p);
        greaterEndpoint.expectedMessageCount(1);
 
        template.sendBody(p);
 
        lowerEndpoint.assertIsSatisfied();
        greaterEndpoint.assertIsSatisfied();
    }
    
    @Test
    public void testSendGreaterMessage11() throws Exception {
        String p = "{\"amount\":11,\"message\":\"Lower message...\"}";

        greaterEndpoint.expectedBodiesReceived(p);
        greaterEndpoint.expectedMessageCount(1);
 
        template.sendBody(p);
 
        greaterEndpoint.assertIsSatisfied();
    }
 
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:start")
                .choice().when().jsonpath("$.[?(@.amount < 10)]")
                .to("mock:lower")
                .otherwise()
                .to("mock:greater");
            }
        };
    }
}
    
    
  

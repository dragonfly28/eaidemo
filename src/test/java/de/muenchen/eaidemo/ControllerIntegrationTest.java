/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author robert.jasny
 */
public class ControllerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void testGetAnswer() {
        Payload p = new Payload();
        p.setAmount(99);
        p.setMessage("Hello World!");
        
        Payload answer = getEntity("/payload", p.getClass(), p);
        assertNotNull(answer);
        assertEquals(answer.getAmount(), 0);
        assertEquals(answer.getMessage(), "Default message...");
        
    }
    
    @Test
    public void testPostAnswer() {
        Payload p = new Payload();
        p.setAmount(99);
        p.setMessage("Hello World!");
        
        Payload answer = postEntity("/payload", p.getClass(), p);
        assertNotNull(answer);
        assertEquals(answer.getAmount(), 99);
        assertEquals(answer.getMessage(), "Hello World!");
        
    }

}

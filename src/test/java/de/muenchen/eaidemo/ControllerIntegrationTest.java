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
        assertEquals(answer.getMessage(), "Please post a payload like this example.");
        
    }
    
    @Test
    public void testPostAnswer() {
        Payload p = new Payload();
        p.setAmount(99);
        p.setMessage("Hello World!");
        
        String answer = new String();
        answer = postEntity("/payload", answer.getClass(), p);
        assertNotNull(answer);
        assertEquals(answer.toString(), "Payload stored to greater folder.");
        
    }

}

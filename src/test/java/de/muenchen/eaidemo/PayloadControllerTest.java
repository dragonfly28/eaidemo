/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robert.jasny
 */
public class PayloadControllerTest {
    
    public PayloadControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of uploadPayload method, of class PayloadController.
     */
    @Test
    public void testUploadPayload() {
        PayloadController instance = new PayloadController();
        Payload expResult = new Payload();
        expResult.setAmount(0);
        expResult.setMessage("Default message...");
        Payload result = instance.uploadPayload();
        assertNotEquals(expResult, result);
        assertEquals(expResult.getAmount(), result.getAmount());
        assertEquals(expResult.getMessage(), result.getMessage());
    }

    /**
     * Test of save method, of class PayloadController.
     */
    @Test
    public void testSave() {
        PayloadController instance = new PayloadController();
        Payload saveLoad = new Payload();
        Payload expResult = new Payload();
        expResult.setMessage("What is your message?");
        Payload result = instance.save(saveLoad);
        assertNotEquals(expResult, result);
        assertEquals(expResult.getAmount(), result.getAmount());
        assertEquals(expResult.getMessage(), result.getMessage());
    }
    
}

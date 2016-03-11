/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

/**
 *
 * @author robert.jasny
 */
public class Payload {
    
    private final int amount;
    private final String message;
    
    public Payload(int amount, String message) {
        this.amount = amount;
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
    
}

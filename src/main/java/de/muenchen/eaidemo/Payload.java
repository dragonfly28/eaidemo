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

    private int amount;
    private String message;

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author robert.jasny
 */
@RestController
@RequestMapping("/payload")
public class PayloadController {

    @Autowired
    private ProducerTemplate producer;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Payload uploadPayload() {
        //return "You can upload a payload by posting to this same URL.";
        Payload payload = new Payload();
        payload.setAmount(0);
        payload.setMessage("Please post a payload like this example.");
        return payload;
    }

    /**
     * TODO: change to void method
     *
     * @param payload
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    String save(@RequestBody Payload payload) {
        String result = new String();
        if (payload.getMessage().isEmpty()) {
            result = "What is your message?";
        } else {
            producer.sendBody("direct:uploaded", payload.toString());
            if (payload.getAmount() < 10) {
                result = "Payload stored to lower folder.";
            } else {
                result = "Payload stored to greater folder.";
            }
        }
        return result;
    }
}

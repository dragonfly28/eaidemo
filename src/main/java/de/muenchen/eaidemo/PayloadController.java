/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

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

//    @RequestMapping(method = RequestMethod.GET)
//    public void uploadPayload(@RequestParam(defaultValue = "0") int amount, @RequestParam(defaultValue = "What's the message?") String message) {
//    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Payload uploadPayload() {
        //return "You can upload a payload by posting to this same URL.";
        Payload payload = new Payload();
        payload.setAmount(0);
        payload.setMessage("Default message...");
        return payload;
    }

    /**
     *
     * @param payload
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Payload save(@RequestBody Payload payload) {
        Payload result = new Payload();
        result.setAmount(payload.getAmount());
        if (payload.getMessage().isEmpty()) {
            result.setMessage("What is your message?");
        } else {
            result.setMessage(payload.getMessage());
        }
        return result;
    }
}

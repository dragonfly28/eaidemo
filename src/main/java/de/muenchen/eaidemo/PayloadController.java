/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.eaidemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author robert.jasny
 */
@Controller
public class PayloadController {

    @RequestMapping(method = RequestMethod.GET)
    public void uploadPayload(@RequestParam(defaultValue = "0") int amount, @RequestParam(defaultValue = "What's the message?") String message) {
    }

    @RequestMapping(value = "/payload", method = RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "You can upload a payload by posting to this same URL.";
    }

    @RequestMapping(value = "/payload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadPayload(@RequestParam("payload") Payload payload) {
        if (payload.getMessage().isEmpty()) {
            return "What is your message?";
        } else {
            return "You uploaded a payload with message: " + payload.getMessage();
        }
    }
}

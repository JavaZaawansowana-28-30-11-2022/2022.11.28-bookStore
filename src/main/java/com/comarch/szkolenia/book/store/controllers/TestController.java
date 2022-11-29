package com.comarch.szkolenia.book.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String requestParams(@RequestParam String param1,
                                @RequestParam String param2,
                                @RequestParam String param3) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);

        return "main";
    }

    @RequestMapping(value = "/test2/{paramter1}/{p2}/{rok}", method = RequestMethod.GET)
    public String pathVariables(@PathVariable int p1,
                                @PathVariable int p2,
                                @PathVariable int rok) {
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(rok);

        return "main";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form(@RequestParam String login,
                        @RequestParam("pass") String password) {
        System.out.println("Dziala odbieranie formularza");
        System.out.println(login);
        System.out.println(password);
        return "main";
    }
}

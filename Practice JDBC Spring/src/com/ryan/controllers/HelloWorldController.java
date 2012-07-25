package com.ryan.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {

    private String message;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String,String> m = new HashMap<String, String>(); 
    	m.put("users", "Hello");
    	m.put("name", "Ryan");
        return new ModelAndView("welcomePage","welcomeMessage", m);
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
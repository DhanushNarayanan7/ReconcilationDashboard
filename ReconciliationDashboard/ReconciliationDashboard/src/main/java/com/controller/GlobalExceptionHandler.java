package com.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, ModelMap map) {

        map.addAttribute("message", "error! no file found");
        return "redirect:/fileUpload";

    }

}
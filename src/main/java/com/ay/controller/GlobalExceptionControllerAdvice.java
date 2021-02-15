package com.ay.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException e, Model model) {
        e.printStackTrace();
        model.addAttribute("errorMessage", e.getLocalizedMessage());
        return "Error";
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object methodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return e.getBindingResult().getAllErrors();
    }

    @ExceptionHandler(BindException.class)
    public String bindException(BindException e, HttpServletRequest request, Model model) {
        String refer = request.getHeader("Referer");
        e.getBindingResult().getAllErrors();
        int index = refer.indexOf("/", 7);
        String view = refer.substring(index + 1);

        model.addAttribute("errors", e.getAllErrors());

        e.printStackTrace();

        return view;
    }
}

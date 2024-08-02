package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = "Unknown error";

        if (statusCode != null) {
            switch (statusCode) {
                case 400:
                    errorMessage = "Bad Request";
                    break;
                case 401:
                    errorMessage = "Unauthorized";
                    break;
                case 403:
                    errorMessage = "Forbidden";
                    break;
                case 404:
                    errorMessage = "Page Not Found, the page you are looking for might have been removed, had its name changed, or is temporarily unavailable.";
                    break;
                case 500:
                    errorMessage = "Internal Server Error";
                    break;
                default:
                    errorMessage = "Error code: " + statusCode;
                    break;
            }
        }

        return String.format("Error code: %d, Message: %s", statusCode, errorMessage);
    }
}
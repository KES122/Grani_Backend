package com.example.demo.Files;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(description = "Иллюстрация работы")
@Controller
public class CustomErrorController implements ErrorController, CustomErrorController1 {

    @ApiOperation("Перенаправление на страницу ошибки")
    @RequestMapping("/error")
    public String handleError() {
        // Перенаправление на страницу ошибки или обработку ошибки
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
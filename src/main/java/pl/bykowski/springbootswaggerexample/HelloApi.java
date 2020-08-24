package pl.bykowski.springbootswaggerexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloApi {

    @Value("${message}")
    private String message;

    @GetMapping
    public String get() {
        return message;
    }
}



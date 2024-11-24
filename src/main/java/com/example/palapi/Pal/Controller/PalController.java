package com.example.palapi.Pal.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pals")
public class PalController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }
}

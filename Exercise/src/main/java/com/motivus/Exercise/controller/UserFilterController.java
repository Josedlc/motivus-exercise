package com.motivus.Exercise.controller;

import com.motivus.Exercise.service.UserFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserFilterController {

    @Autowired
    private UserFilterService userFilterService;

    @GetMapping("/filter")
    public String filtrarUsuarios(@RequestParam int min, @RequestParam int max){
        String outputFilePath = userFilterService.procesarUsuarios(min, max);
        return "Archivo generado: " + outputFilePath;
    }

}

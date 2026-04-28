/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luqmeys.devops_app;

/**
 *
 * @author LUQMAN_AF
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello DevOps - Simple Spring Boot App";
    }

    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"UP\"}";
    }
}

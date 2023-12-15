/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroclientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Pedro
 */
@Controller
public class HomeController {
    
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

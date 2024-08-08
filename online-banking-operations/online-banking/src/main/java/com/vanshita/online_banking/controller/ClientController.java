package com.vanshita.online_banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    // Add your methods for handling client-related requests here

    @GetMapping
    public String getClients() {
        return "List of clients"; // Example response
    }

    @PostMapping
    public String createClient(@RequestBody String client) {
        return "Client created"; // Example response
    }
}
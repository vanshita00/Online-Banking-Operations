package com.vanshita.online_banking.service;

import com.vanshita.online_banking.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientServiceTests {
    @Autowired
    private ClientService clientService;

    @Test
    public void testCreateClient() {
        Client client = new Client();
        client.setUsername("testuser");
        client.setPassword("password");
        client.setName("Test User");
        client.setDateOfBirth(LocalDate.of(1990, 1, 1));
        client.setInitialBalance(BigDecimal.valueOf(1000));
        client.setCurrentBalance(BigDecimal.valueOf(1000));

        Client createdClient = clientService.createClient(client);
        assertNotNull(createdClient);
        assertEquals("testuser", createdClient.getUsername());
    }

    @Test
    public void testTransferMoney() {
        // Implement test for money transfer with appropriate validations and mocks
    }
}


package com.vanshita.online_banking.task;

import com.vanshita.online_banking.model.Client;
import com.vanshita.online_banking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class InterestCalculationTask {



        @Autowired
        private ClientRepository clientRepository;

        @Scheduled(fixedRate = 60000) // Run every minute
        public void calculateInterest() {
            List<Client> clients = clientRepository.findAll();
            for (Client client : clients) {
                BigDecimal newBalance = client.getCurrentBalance().multiply(BigDecimal.valueOf(1.05));
                if (newBalance.compareTo(client.getMaxBalance()) <= 0) {
                    client.setCurrentBalance(newBalance);
                }
                clientRepository.save(client);
            }
        }
    }



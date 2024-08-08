package com.vanshita.online_banking.service;

import com.vanshita.online_banking.model.Client;
import com.vanshita.online_banking.model.Contact;
import com.vanshita.online_banking.repository.ClientRepository;
import com.vanshita.online_banking.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    public Client createClient(Client client) {
        client.setMaxBalance(client.getInitialBalance().multiply(BigDecimal.valueOf(2.07)));
        return clientRepository.save(client);
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }

    public void transferMoney(Long fromClientId, Long toClientId, BigDecimal amount) {
        // Fetch the clients involved in the transaction
        Optional<Client> fromClientOpt = clientRepository.findById(fromClientId);
        Optional<Client> toClientOpt = clientRepository.findById(toClientId);

        if (fromClientOpt.isPresent() && toClientOpt.isPresent()) {
            Client fromClient = fromClientOpt.get();
            Client toClient = toClientOpt.get();

            // Validate the transfer
            if (fromClient.getCurrentBalance().compareTo(amount) >= 0) {
                // Deduct from sender
                fromClient.setCurrentBalance(fromClient.getCurrentBalance().subtract(amount));

                // Add to receiver
                toClient.setCurrentBalance(toClient.getCurrentBalance().add(amount));

                // Save the updated balances
                clientRepository.save(fromClient);
                clientRepository.save(toClient);
            } else {
                throw new IllegalArgumentException("Insufficient balance for transfer.");
            }
        } else {
            throw new IllegalArgumentException("Client(s) not found.");
        }
    }

    public List<Client> searchClients(String name, LocalDate dateOfBirth) {
        return clientRepository.findByNameAndDateOfBirth(name, dateOfBirth);
    }
}

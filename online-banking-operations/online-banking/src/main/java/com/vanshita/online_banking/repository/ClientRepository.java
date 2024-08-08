package com.vanshita.online_banking.repository;

import com.vanshita.online_banking.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
    List<Client> findByNameAndDateOfBirth(String name, LocalDate dateOfBirth);
}



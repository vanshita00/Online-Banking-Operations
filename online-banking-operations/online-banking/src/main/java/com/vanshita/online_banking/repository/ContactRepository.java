package com.vanshita.online_banking.repository;

import com.vanshita.online_banking.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface ContactRepository extends JpaRepository<Contact, Long> {
        List<Contact> findByClientId(Long clientId);
    }



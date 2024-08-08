package com.vanshita.online_banking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "client_id", nullable = false)
        private Client client;

        @Column(nullable = false)
        private String type; // phone or email

        @Column(nullable = false)
        private String value;

        // Getters and Setters
    }



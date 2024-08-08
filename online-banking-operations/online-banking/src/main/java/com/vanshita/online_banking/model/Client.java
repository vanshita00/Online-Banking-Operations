package com.vanshita.online_banking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private LocalDate dateOfBirth;

        @Column(nullable = false)
        private BigDecimal initialBalance;

        @Column(nullable = false)
        private BigDecimal currentBalance;

        @Column(nullable = false)
        private BigDecimal maxBalance;

        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Contact> contacts = new HashSet<>();

        // Getters and Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public BigDecimal getInitialBalance() {
                return initialBalance;
        }

        public void setInitialBalance(BigDecimal initialBalance) {
                this.initialBalance = initialBalance;
        }

        public BigDecimal getCurrentBalance() {
                return currentBalance;
        }

        public void setCurrentBalance(BigDecimal currentBalance) {
                this.currentBalance = currentBalance;
        }

        public BigDecimal getMaxBalance() {
                return maxBalance;
        }

        public void setMaxBalance(BigDecimal maxBalance) {
                this.maxBalance = maxBalance;
        }

        public Set<Contact> getContacts() {
                return contacts;
        }

        public void setContacts(Set<Contact> contacts) {
                this.contacts = contacts;
        }
}

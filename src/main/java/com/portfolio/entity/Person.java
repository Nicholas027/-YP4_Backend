package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
    @Table(name = "person")
    public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "person_id")
        private Long personId;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Column(name = "phone")
        private String phone;

        @Column(name = "address")
        private String address;

        @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
        private List<Education> educationList;

        @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
        private List<User> userList;

        @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
        private List<Technology> technologyList;
    }


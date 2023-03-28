package com.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Table(name = "technology")
    public class Technology {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "technology_id")
        private Long technologyId;

        @Column(name = "technology_name")
        private String technologyName;

        @ManyToOne
        @JoinColumn(name = "person_id")
        @JsonIgnore
        private Person person;

    }


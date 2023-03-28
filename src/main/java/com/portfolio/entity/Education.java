package com.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "education")
    public class Education {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "education_id")
        private Long educationId;

        @Column(name = "institution")
        private String institution;

        @Column(name = "degree")
        private String degree;

        @Column(name = "field_of_study")
        private String fieldOfStudy;

        @Column(name = "start_date")
        private String startDate;

        @Column(name = "end_date")
        private String endDate;

        @ManyToOne
        @JoinColumn(name = "person_id")
        @JsonIgnore
        private Person person;

    }


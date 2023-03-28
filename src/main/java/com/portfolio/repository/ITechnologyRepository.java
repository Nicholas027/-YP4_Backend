package com.portfolio.repository;

import com.portfolio.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology, Long> {
}

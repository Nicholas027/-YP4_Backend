package com.portfolio.repository;

import com.portfolio.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education, Long> {
}

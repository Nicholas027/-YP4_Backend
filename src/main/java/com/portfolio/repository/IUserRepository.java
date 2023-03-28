package com.portfolio.repository;

import com.portfolio.entity.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}

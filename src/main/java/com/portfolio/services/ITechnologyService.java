package com.portfolio.services;

import com.portfolio.entity.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITechnologyService {
    public List<Technology> getTechnologies();
    public void addTechnology(Technology technology);
    public void deleteTechnology(Long id);
}

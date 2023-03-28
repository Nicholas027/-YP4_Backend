package com.portfolio.services.impl;

import com.portfolio.entity.Technology;
import com.portfolio.repository.ITechnologyRepository;
import com.portfolio.services.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITechnologyImpl implements ITechnologyService {
    @Autowired
    private ITechnologyRepository technologies;
    @Override
    public List<Technology> getTechnologies() {
        return this.technologies.findAll();
    }

    @Override
    public void addTechnology(Technology technology) {
        this.technologies.save(technology);
    }

    @Override
    public void deleteTechnology(Long id) {
        if(this.technologies.existsById(id))
            this.technologies.deleteById(id);
    }
}

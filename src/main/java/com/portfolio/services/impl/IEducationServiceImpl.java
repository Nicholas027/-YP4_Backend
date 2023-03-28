package com.portfolio.services.impl;

import com.portfolio.entity.Education;
import com.portfolio.repository.IEducationRepository;
import com.portfolio.services.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEducationServiceImpl implements IEducationService {
    @Autowired
    private IEducationRepository education;
    @Override
    public List<Education> getEducation() {
        return this.education.findAll();
    }

    @Override
    public void addEducation(Education education) {
        this.education.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        if(this.education.existsById(id))
            this.education.deleteById(id);
    }
}

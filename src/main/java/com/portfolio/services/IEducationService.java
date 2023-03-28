package com.portfolio.services;

import com.portfolio.entity.Education;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IEducationService {
    public List<Education> getEducation();
    public void addEducation(Education education);
    public void deleteEducation(Long id);
}

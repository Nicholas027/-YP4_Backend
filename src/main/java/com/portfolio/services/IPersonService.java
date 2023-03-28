package com.portfolio.services;

import com.portfolio.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {
    public List<Person> getPerson();
    public void editPerson(Person person);
}

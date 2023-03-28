package com.portfolio.services.impl;

import com.portfolio.entity.Person;
import com.portfolio.repository.IPersonRepository;
import com.portfolio.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPersonImpl implements IPersonService {
    @Autowired
    private IPersonRepository person;

    @Override
    public List<Person> getPerson() {
        return this.person.findAll();
    }

    @Override
    public void editPerson(Person person) {
            this.person.save(person);
    }
}

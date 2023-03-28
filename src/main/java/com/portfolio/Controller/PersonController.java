package com.portfolio.Controller;

import com.portfolio.entity.Person;
import com.portfolio.handlingErrors.ResourceNotFoundException;
import com.portfolio.repository.IPersonRepository;
import com.portfolio.security.AuthManager;
import com.portfolio.services.IPersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    private IPersonService service;
    @Autowired
    private AuthManager manager;

    @GetMapping("/person/get")
    public List<Person> getPerson(){
        return this.service.getPerson();
    }
    @PutMapping("/person/edit/{id}")
    public void editPerson(@RequestBody Person person, @PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (this.manager.validToken(request, response)) this.service.editPerson(person);
    }
}

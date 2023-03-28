package com.portfolio.Controller;


import com.portfolio.entity.Technology;
import com.portfolio.security.AuthManager;
import com.portfolio.services.ITechnologyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class TechnologiesController {
    @Autowired
    private ITechnologyService service;
    @Autowired
    private AuthManager manager;
    @CrossOrigin
    @GetMapping("/technologies/get")
    public List<Technology> getTechnologies() {
        return this.service.getTechnologies();
    }
    @CrossOrigin
    @PostMapping("/technologies/add")
    public void addTechnology(@RequestBody Technology technology, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(this.manager.validToken(request, response))
            this.service.addTechnology(technology);
    }

    @CrossOrigin
    @PutMapping("/technologies/edit")
    public void editTechnology(@RequestBody Technology technology, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(this.manager.validToken(request, response))
            this.service.addTechnology(technology);
    }

    @CrossOrigin
    @DeleteMapping("/technologies/delete/{id}")
    public void deleteTechnology(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(this.manager.validToken(request, response))
            this.service.deleteTechnology(id);
    }

}

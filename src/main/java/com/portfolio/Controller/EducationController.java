package com.portfolio.Controller;

import com.portfolio.entity.Education;
import com.portfolio.security.AuthManager;
import com.portfolio.services.IEducationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class EducationController {
    @Autowired
    private IEducationService service;
    @Autowired
    private AuthManager manager;

    @GetMapping("/education/get")
    public List<Education> getEducation() {
        return this.service.getEducation();
    }

    @PostMapping("/education/add")
    public void addEducation(@RequestBody Education education, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (manager.validToken(request, response))
            this.service.addEducation(education);
    }

    @PutMapping("/education/edit/")
    public void editEducation(@RequestBody Education education, HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        if (this.manager.validToken(request, response))
            this.service.addEducation(education);
    }

    @DeleteMapping("/education/delete/{id}")
    public void deleteEducation(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (this.manager.validToken(request, response)) {
            this.service.deleteEducation(id);
        }
    }


}

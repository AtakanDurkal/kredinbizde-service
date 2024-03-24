package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationRequest request) {
        return ResponseEntity.ok().body(applicationService.createApplication(request));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Application>> getApplicationsByEmail(@PathVariable String email) {
        List<Application> applications = applicationService.getApplicationsByEmail(email);
        if (applications != null && !applications.isEmpty()) {
            return ResponseEntity.ok().body(applications);
        } else {
            return ResponseEntity.notFound().build();
        }}

}

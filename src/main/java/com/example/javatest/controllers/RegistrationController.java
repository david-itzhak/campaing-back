package com.example.javatest.controllers;

import com.example.javatest.Dto.Request.RegistrationDto;
import com.example.javatest.Dto.Results.RegistrationResponse;
import com.example.javatest.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

/**
 * @author Dmitry Itskov
 */

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(value = "/marketing/ws/partner/{campaignId}", produces = "application/json")
    public RegistrationResponse createRegistration(@PathVariable String campaignId, @Valid @RequestBody RegistrationDto registrationDto) {
        return registrationService.createRegistration(campaignId, registrationDto);
    }

}

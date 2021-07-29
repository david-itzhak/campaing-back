package com.example.javatest.controllers;

import com.example.javatest.Dto.Request.RegistrationDto;
import com.example.javatest.Dto.Results.RegistrationResponse;
import com.example.javatest.Dto.Results.RegistrationStatus;
import com.example.javatest.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Dmitry Itskov
 */

@RestController
@RequiredArgsConstructor
@Validated
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(value = "/marketing/ws/partner/{campaignId}", produces = "application/json")
    public RegistrationStatus createRegistration(@PathVariable String campaignId, @Valid @RequestBody RegistrationDto registrationDto) {
        return registrationService.createRegistration(campaignId, registrationDto);
    }

    @GetMapping(value = "/marketing/ws/partner/name/{name}", produces = "application/json")
    public List<RegistrationResponse> getRegistrationByName(@PathVariable String name) throws Exception {
        return registrationService.getRegistrationByName(name);
    }

    @GetMapping(value = "/marketing/ws/partner/allregistration", produces = "application/json")
    public List<RegistrationResponse> getAllRegistration() throws Exception {
        return registrationService.getAllRegistration();
    }
}

package com.example.javatest.services;

import com.example.javatest.Dto.Request.RegistrationDto;
import com.example.javatest.Dto.Results.CampaignResponse;
import com.example.javatest.Dto.Results.RegistrationResponse;
import com.example.javatest.entities.Campaign;
import com.example.javatest.entities.Registration;
import com.example.javatest.repositories.CampaignRepo;
import com.example.javatest.repositories.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * @author Dmitry Itskov
 */
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepo registrationRepo;
    private final CampaignRepo campaignRepo;

    public RegistrationResponse createRegistration(String campaignId, RegistrationDto registrationDto) {
        Optional<Campaign> campaignOptional = Optional.ofNullable(campaignRepo.findByCampaignName(campaignId));
        if(!campaignOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign Not Found");
        }
        Registration registration = new Registration(registrationDto.getName(), registrationDto.getFirstName(), registrationDto.getMail(), registrationDto.getTelephone(), campaignOptional.get());
        Registration registrationRes = registrationRepo.save(registration);
        return new RegistrationResponse(registrationRes != null ? true : false);
    }
}

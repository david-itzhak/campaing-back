package com.example.javatest.services;

import com.example.javatest.Dto.Request.RegistrationDto;
import com.example.javatest.Dto.Results.RegistrationResponse;
import com.example.javatest.Dto.Results.RegistrationStatus;
import com.example.javatest.entities.Campaign;
import com.example.javatest.entities.Registration;
import com.example.javatest.repositories.CampaignRepo;
import com.example.javatest.repositories.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dmitry Itskov
 */
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepo registrationRepo;
    private final CampaignRepo campaignRepo;

    public RegistrationStatus createRegistration(String campaignId, RegistrationDto registrationDto) {
        Optional<Campaign> campaignOptional = Optional.ofNullable(campaignRepo.findByCampaignName(campaignId));
        if (campaignOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign #" + campaignId + " not Found");
        }
        if (!checkMandatoryFieldsIsProvided(campaignOptional.get().getMandatoryNames(), registrationDto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not provided mandatory field. Should be provided: " + Arrays.toString(campaignOptional.get().getMandatoryNames()));
        }
        Registration registration = getRegistration(registrationDto, campaignOptional.get());
        Registration registrationRes = registrationRepo.save(registration);
        return new RegistrationStatus(registrationRes != null);
    }

    private Registration getRegistration(RegistrationDto registrationDto, Campaign campaign) {
        return new Registration(
                capitalize(registrationDto.getName()),
                capitalize(registrationDto.getFirstName()),
                decapitalize(registrationDto.getMail()),
                registrationDto.getTelephone(),
                campaign);
    }

    private String capitalize(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private String decapitalize(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }
        return str.toLowerCase();
    }

    public List<RegistrationResponse> getRegistrationByName(String name) throws Exception {
        Optional<List<Registration>> registrationListOptional = Optional.ofNullable(registrationRepo.findByName(name.substring(0, 1).toUpperCase() + name.substring(1)));
        return registrationListOptional.isPresent()
                ? registrationListOptional.get().stream().map(this::convertrRegistrationToRegistrationResponse).collect(Collectors.toList())
                : throwException();
    }

    public List<RegistrationResponse> getAllRegistration() throws Exception {
        Optional<List<Registration>> registrationListOptional = Optional.ofNullable(registrationRepo.findAll());
        return registrationListOptional.isPresent()
                ? registrationListOptional.get().stream().map(this::convertrRegistrationToRegistrationResponse).collect(Collectors.toList())
                : throwException();
    }

    private boolean checkMandatoryFieldsIsProvided(String[] mandatoryNames, RegistrationDto registrationDto) {
        if (mandatoryNames.length == 0) {
            return true;
        }
        for (String mandatoryName : mandatoryNames) {
            if (registrationDto == null) {
                return false;
            }
            String str = (String) registrationDto.getersMap.get(mandatoryName).apply(registrationDto);
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    private RegistrationResponse convertrRegistrationToRegistrationResponse(Registration registration) {
        return new RegistrationResponse(
                registration.id,
                registration.name,
                registration.firstName,
                registration.mail,
                registration.telephone,
                registration.campaign.getCampaignName()
        );
    }

    private List<RegistrationResponse> throwException() throws Exception {
        throw new Exception();
    }
}

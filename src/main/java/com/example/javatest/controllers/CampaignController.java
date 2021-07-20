package com.example.javatest.controllers;

import com.example.javatest.Dto.Request.CampaignRequest;
import com.example.javatest.Dto.Results.CampaignResponse;
import com.example.javatest.repositories.CampaignRepo;
import com.example.javatest.services.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

/**
 * @author Dmitry Itskov
 */

@RestController
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping(value = "/marketing/ws/partner/campaign/{id}", produces = "application/json")
    public CampaignResponse createCampaign(@PathVariable CampaignRequest request) {
        return campaignService.createCampaign(request);
    }

    @GetMapping(value = "/marketing/ws/partner/campaign/{id}", produces = "application/json")
    public CampaignResponse getCampaign(@PathVariable String id) {
        return campaignService.getCampaign(id);
    }
}

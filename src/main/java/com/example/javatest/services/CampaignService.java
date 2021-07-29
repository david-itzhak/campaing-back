package com.example.javatest.services;

import com.example.javatest.Dto.Request.CampaignRequest;
import com.example.javatest.Dto.Results.CampaignResponse;
import com.example.javatest.entities.Campaign;
import com.example.javatest.repositories.CampaignRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dmitry Itskov
 */
@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepo campaignRepo;

    public CampaignResponse createCampaign(CampaignRequest campaignName) {
        Campaign campaign = campaignRepo.save(new Campaign(campaignName.getCampagnName(), campaignName.getMandatoryNames()));
        return new CampaignResponse(campaign.getCampaignName(), campaign.getMandatoryNames());
    }

    public CampaignResponse getCampaign(String campaignName) {
        Optional<Campaign> campaignOptional = Optional.ofNullable(campaignRepo.findByCampaignName(campaignName));
        return campaignOptional.map(this::convertCampaignToCampaignResponse).orElseGet(() -> new CampaignResponse("", new String[0]));
    }

    public List<CampaignResponse> getAllCampaign() {
        Optional<List<Campaign>> campaignListOptional = Optional.ofNullable(campaignRepo.findAll());
        return campaignListOptional.map(campaigns -> campaigns.stream().map(this::convertCampaignToCampaignResponse).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    private CampaignResponse convertCampaignToCampaignResponse (Campaign campaign) {
        return new CampaignResponse(campaign.getCampaignName(), campaign.getMandatoryNames());
    }
}

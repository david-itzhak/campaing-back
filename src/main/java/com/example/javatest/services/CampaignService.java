package com.example.javatest.services;

import com.example.javatest.Dto.Request.CampaignRequest;
import com.example.javatest.Dto.Results.CampaignResponse;
import com.example.javatest.entities.Campaign;
import com.example.javatest.repositories.CampaignRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Dmitry Itskov
 */
@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepo campaignRepo;

    public CampaignResponse createCampaign(String campaignName) {
        Campaign campaign = campaignRepo.save(new Campaign(campaignName));
        return new CampaignResponse(campaign.getCampaignName());
    }

    public CampaignResponse getCampaign(String campaignName) {
        Optional<Campaign> campaignOptional = Optional.ofNullable(campaignRepo.findByCampaignName(campaignName));
        return campaignOptional.isPresent() ? new CampaignResponse(campaignOptional.get().getCampaignName()) : new CampaignResponse("");
    }

}

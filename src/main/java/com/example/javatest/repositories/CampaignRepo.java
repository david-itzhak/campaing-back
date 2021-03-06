package com.example.javatest.repositories;

import com.example.javatest.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dmitry Itskov
 */
public interface CampaignRepo extends JpaRepository<Campaign, String> {
    Campaign findByCampaignName(String campagnName);
    List<Campaign> findAll();
}

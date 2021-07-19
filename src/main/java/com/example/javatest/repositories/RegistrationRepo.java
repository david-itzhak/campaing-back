package com.example.javatest.repositories;

import com.example.javatest.entities.Campaign;
import com.example.javatest.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dmitry Itskov
 */
public interface RegistrationRepo extends JpaRepository<Registration, Long>  {
    Registration findByName(String name);
    Registration findByMail(String mail);
    Registration findByTelephone(String telephone);
    List<Registration> findAllByCampaign(Campaign campaign);
}

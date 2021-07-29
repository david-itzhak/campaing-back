package com.example.javatest.Dto.Results;

import com.example.javatest.entities.Campaign;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Dmitry Itskov
 */
@AllArgsConstructor
public class RegistrationResponse {

    public long id;
    public String name;
    public String firstName;
    public String mail;
    public String telephone;
    public String campaign;

}

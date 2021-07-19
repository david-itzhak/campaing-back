package com.example.javatest.Dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Dmitry Itskov
 */
@Getter
public class RegistrationDto {

    @NotEmpty
    @NotNull
    @JsonProperty(value = "name", required = true)
    public String name;

    @NotEmpty
    @NotNull
    @JsonProperty(value = "firstName", required = true)
    public String firstName;

    @JsonProperty(value = "mail", required = false)
    public String mail;

    @JsonProperty(value = "telephone", required = false)
    public String telephone;

}

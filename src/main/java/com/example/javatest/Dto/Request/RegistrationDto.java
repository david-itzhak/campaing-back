package com.example.javatest.Dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "wrong format for field mail")
    @JsonProperty(value = "mail", required = false)
    public String mail;

    @Pattern(regexp="^ [+] * [(] {0,1} [0-9] {1,4} [)] {0,1} [- \\ s \\ ./ 0-9] * $", message = "wrong format for field telephone")
    @JsonProperty(value = "telephone", required = false)
    public String telephone;

}

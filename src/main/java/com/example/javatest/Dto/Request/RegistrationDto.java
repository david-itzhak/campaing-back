package com.example.javatest.Dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Dmitry Itskov
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistrationDto {

    public HashMap <String, Function> getersMap = new HashMap<>();

    {
        getersMap.put("name", (x) -> getName());
        getersMap.put("firstName", (x) -> getFirstName());
        getersMap.put("mail", (x) -> getMail());
        getersMap.put("telephone", (x) -> getTelephone());
    }

    @NotEmpty
    @NotNull
    @JsonProperty(value = "name", required = true)
    public String name;

    @NotEmpty
    @NotNull
    @JsonProperty(value = "firstName", required = true)
    public String firstName;

    @Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "wrong format for field mail")
    @JsonProperty(value = "mail", required = false)
    public String mail;

    @Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "wrong format for field telephone")
    @JsonProperty(value = "telephone", required = false)
    public String telephone;
}

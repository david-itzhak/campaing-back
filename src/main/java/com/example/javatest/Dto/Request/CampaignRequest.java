package com.example.javatest.Dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class CampaignRequest {
    @NotEmpty
    @NotNull
    @JsonProperty(value = "name", required = true)
    public String campagnName;
}

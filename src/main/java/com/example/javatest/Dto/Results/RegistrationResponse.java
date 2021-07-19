package com.example.javatest.Dto.Results;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author Dmitry Itskov
 */
//@AllArgsConstructor
    @Log4j2
public class RegistrationResponse {
    public RegistrationResponse(boolean status) {
        log.error("RegistrationRegistrationResponse status {}", status);
        this.status = status;
    }

    Boolean status;
}

package com.example.javatest.Dto.Results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Dmitry Itskov
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Log4j2
public class RegistrationStatus {
    public RegistrationStatus(boolean status) {
        log.info("RegistrationResponse status {}", status);
        this.status = status;
    }

    Boolean status;
}

package com.example.javatest.entities;

import lombok.*;
import org.apache.tomcat.util.buf.StringUtils;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author Dmitry Itskov
 */

@Entity
@Table(name = "campaigns")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Campaign {
    @Id
    @Column(name = "campaign", nullable = false, unique = true)
    String campaignName;

    @Column(name = "mandatoryNames", columnDefinition = "text")
    @Convert(converter = ArrayToStringConverter.class)
    private String[] mandatoryNames;
    public String[] getMandatoryNames() {
        return mandatoryNames;
    }
    public void setMandatoryNames(String[] mandatoryNames) {
        this.mandatoryNames = mandatoryNames;
    }

}

@Converter
class ArrayToStringConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        if (attribute == null || attribute.length == 0) {
            return "";
        }
        return String.join(",", attribute);
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return new String[0];
        }
        return dbData.split(",");
    }
}
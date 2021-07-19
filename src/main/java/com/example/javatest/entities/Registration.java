package com.example.javatest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Dmitry Itskov
 */
@Entity
@Table(name = "registrations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Registration {

    public Registration(String name, String firstName, String mail, String telephone, Campaign campaign) {
        this.name = name;
        this.firstName = firstName;
        this.mail = mail;
        this.telephone = telephone;
        this.campaign = campaign;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Setter(value = AccessLevel.NONE)
    long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "firstName", nullable = false)
    public String firstName;

    @Column(name = "mail", nullable = true)
    public String mail;

    @Column(name = "telephone", nullable = true)
    public String telephone;

    @ManyToOne
    @JoinColumn(name = "campaign", nullable = false)
    Campaign campaign;

}

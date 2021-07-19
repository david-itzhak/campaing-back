package com.example.javatest.entities;

import lombok.*;

import javax.persistence.*;

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
}

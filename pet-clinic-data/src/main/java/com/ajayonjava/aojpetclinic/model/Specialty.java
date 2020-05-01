package com.ajayonjava.aojpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SPECIALTY")
public class Specialty extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;
}

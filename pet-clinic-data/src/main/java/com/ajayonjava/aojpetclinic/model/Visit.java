package com.ajayonjava.aojpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VISIT")
public class Visit extends BaseEntity {

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }
}

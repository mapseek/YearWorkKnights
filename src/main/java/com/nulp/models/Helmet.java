package com.nulp.models;

import com.nulp.armour.HelmetType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "helmet")

public class Helmet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "cost")
    private Integer cost;

    @Basic
    @Column(name = "hardness")
    private Float hardness;

    @Basic
    @Column(name = "weight")
    private Float weight;

    @Basic
    @Column(name = "helmet_type")
    private String helmet_type;


    public Helmet(String name, Integer cost, Float hardness, Float weight, String helmet_type) {
        this.name = name;
        this.cost = cost;
        this.hardness = hardness;
        this.weight = weight;
        this.helmet_type = helmet_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helmet helmet = (Helmet) o;
        return Objects.equals(id, helmet.id) && Objects.equals(name, helmet.name) && Objects.equals(cost, helmet.cost) && Objects.equals(hardness, helmet.hardness) && Objects.equals(weight, helmet.weight) && Objects.equals(helmet_type, helmet.helmet_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, hardness, weight, helmet_type);
    }

}

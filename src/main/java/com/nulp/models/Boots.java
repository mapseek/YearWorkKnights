package com.nulp.models;

import javax.persistence.*;
import java.util.Objects;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boots")

public class Boots {

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

    public Boots(String name, Integer cost, Float hardness, Float weight) {
        this.name = name;
        this.cost = cost;
        this.hardness = hardness;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boots boots = (Boots) o;
        return Objects.equals(id, boots.id) && Objects.equals(name, boots.name) && Objects.equals(cost, boots.cost) && Objects.equals(hardness, boots.hardness) && Objects.equals(weight, boots.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, hardness, weight);
    }
}

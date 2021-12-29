package com.nulp.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

import lombok.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chestplate")

public class Chestplate {

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
    @Column(name = "max_addition_equipment")
    private Integer max_addition_equipment;

    @Basic
    @Column(name = "heart_crystal")
    private String heart_crystal;

    public Chestplate(String name, Integer cost, Float hardness, Float weight, Integer max_addition_equipment, String heart_crystal) {
        this.name = name;
        this.cost = cost;
        this.hardness = hardness;
        this.weight = weight;
        this.max_addition_equipment = max_addition_equipment;
        this.heart_crystal = heart_crystal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chestplate that = (Chestplate) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(hardness, that.hardness) && Objects.equals(weight, that.weight) && Objects.equals(max_addition_equipment, that.max_addition_equipment) && Objects.equals(heart_crystal, that.heart_crystal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, hardness, weight, max_addition_equipment, heart_crystal);
    }



}

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
@Table(name = "leggins")

public class Leggins {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "Name")
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
    @Column(name = "pocket_quantity")
    private Integer pocket_quantity;


    public Leggins(String name, Integer cost, Float hardness, Float weight, Integer pocket_quantity) {
        this.name = name;
        this.cost = cost;
        this.hardness = hardness;
        this.weight = weight;
        this.pocket_quantity = pocket_quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leggins leggins = (Leggins) o;
        return Objects.equals(id, leggins.id) && Objects.equals(name, leggins.name) && Objects.equals(cost, leggins.cost) && Objects.equals(hardness, leggins.hardness) && Objects.equals(weight, leggins.weight) && Objects.equals(pocket_quantity, leggins.pocket_quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, hardness, weight, pocket_quantity);
    }

}

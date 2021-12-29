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
@Table(name = "knight")

public class Knight {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "service_years")
    private Integer service_years;

    @Basic
    @Column(name = "armor_id")
    private Integer armor_id;

    public Knight(String name, Integer service_years, Integer armor_id) {
        this.name = name;
        this.service_years = service_years;
        this.armor_id = armor_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return Objects.equals(id, knight.id) && Objects.equals(name, knight.name) && Objects.equals(service_years, knight.service_years)  && Objects.equals(armor_id, knight.armor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, service_years, armor_id);
    }

}

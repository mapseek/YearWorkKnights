package com.nulp.models;

import javax.persistence.*;
import java.util.Objects;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "armor")

public class Armor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "helmet_id")
    private Integer helmet_id;

    @Basic
    @Column(name = "chestplate_id")
    private Integer chestplate_id;

    @Basic
    @Column(name = "leggins_id")
    private Integer leggins_id;

    @Basic
    @Column(name = "boots_id")
    private Integer boots_id;

    public Armor(Integer helmet_id, Integer chestplate_id, Integer leggins_id, Integer boots_id) {
        this.helmet_id = helmet_id;
        this.chestplate_id = chestplate_id;
        this.leggins_id = leggins_id;
        this.boots_id = boots_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return Objects.equals(id, armor.id) && Objects.equals(helmet_id, armor.helmet_id) && Objects.equals(chestplate_id, armor.chestplate_id) && Objects.equals(leggins_id, armor.leggins_id) && Objects.equals(boots_id, armor.boots_id) && Objects.equals(chestplate_id, armor.chestplate_id) && Objects.equals(leggins_id, armor.leggins_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, helmet_id, chestplate_id, leggins_id, boots_id, boots_id);
    }


}

package com.nulp.armour;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Helmet.class, name = "helmet"),
        @JsonSubTypes.Type(value = Chestplate.class, name = "chestplate"),
        @JsonSubTypes.Type(value = Leggings.class, name = "leggings"),
        @JsonSubTypes.Type(value = Boots.class, name = "boots"),
})
public abstract class Armor {

    protected String title;
    protected BigDecimal cost;
    protected double hardness;
    protected double weightKg;

    public Armor() {
        title = "Armor";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    @Override
    public String toString() {
        return "[" + title + "]" + "\n" +
                "\tcost: " + cost + "\n" +
                "\thardness: " + hardness + "\n" +
                "\tweightKg: " + weightKg;
    }

}

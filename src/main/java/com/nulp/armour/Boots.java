package com.nulp.armour;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Boots extends Armor {

    private boolean isHorseRideable;

    @JsonGetter("isHorseRideable")
    public boolean isHorseRideable() {
        return isHorseRideable;
    }

    public void setHorseRideable(boolean horseRideable) {
        isHorseRideable = horseRideable;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tis horse rideable: " + isHorseRideable;
    }
}

package com.nulp.armour;

public class Helmet extends Armor {

    private HelmetType helmetType;

    public HelmetType getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(HelmetType helmetType) {
        this.helmetType = helmetType;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\thelmet type: " + helmetType;
    }
}

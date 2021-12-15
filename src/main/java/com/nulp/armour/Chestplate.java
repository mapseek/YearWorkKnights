package com.nulp.armour;

public class Chestplate extends Armor {

    private double maxAdditionalEquipmentKg;
    private String heartCrystal;

    public double getMaxAdditionalEquipmentKg() {
        return maxAdditionalEquipmentKg;
    }

    public void setMaxAdditionalEquipmentKg(double maxAdditionalEquipmentKg) {
        this.maxAdditionalEquipmentKg = maxAdditionalEquipmentKg;
    }

    public String getHeartCrystal() {
        return heartCrystal;
    }

    public void setHeartCrystal(String heartCrystal) {
        this.heartCrystal = heartCrystal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tmax additional equipment [kg]: " + maxAdditionalEquipmentKg + "\n" +
                "\theart crystal: " + heartCrystal;
    }
}

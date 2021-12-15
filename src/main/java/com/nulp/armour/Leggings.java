package com.nulp.armour;

public class Leggings extends Armor {

    private int pocketsQuantity;

    public int getPocketsQuantity() {
        return pocketsQuantity;
    }

    public void setPocketsQuantity(int pocketsQuantity) {
        this.pocketsQuantity = pocketsQuantity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tpockets quantity: " + pocketsQuantity;
    }
}

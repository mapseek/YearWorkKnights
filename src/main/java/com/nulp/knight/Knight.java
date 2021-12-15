package com.nulp.knight;

import com.nulp.armour.Armor;

import java.util.List;

public class Knight {

    private String name;
    private List<Armor> armorList;
    private long serviceYears;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    public long getServiceYears() {
        return serviceYears;
    }

    public void setServiceYears(long serviceYears) {
        this.serviceYears = serviceYears;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Armor armor : armorList) {
            sb.append(armor).append("\n");
        }

        return "name: " + name + "\n" +
                "armor list:\n" + sb + "\n" +
                "service years: " + serviceYears;
    }
}


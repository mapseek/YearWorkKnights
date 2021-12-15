package com.nulp.command;

import com.nulp.armour.Armor;
import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAmmunitionByWeightCommand extends Command {

    private final String name = "sort";
    private final String desc = "sort ammunition by weight";
    private LifecycleController lc;

    public SortAmmunitionByWeightCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();

        List<Armor> ammunitionCopy = new ArrayList<>(lc.getKnight().getArmorList());
        ammunitionCopy.sort(Comparator.comparing(Armor::getWeightKg));

        responseEntity.addPair("sorted ammunition", ammunitionCopy);
        return responseEntity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

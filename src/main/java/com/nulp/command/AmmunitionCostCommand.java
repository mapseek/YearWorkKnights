package com.nulp.command;

import com.nulp.armour.Armor;
import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

import java.math.BigDecimal;

public class AmmunitionCostCommand extends Command {

    private final String name = "amcost";
    private final String desc = "displays total ammunition cost";
    private LifecycleController lc;

    public AmmunitionCostCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        BigDecimal totalCost = new BigDecimal(0);

        for (Armor armor : lc.getKnight().getArmorList()) {
            totalCost = totalCost.add(armor.getCost());
        }

        responseEntity.addPair("total ammunition cost", totalCost);
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

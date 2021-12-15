package com.nulp.command;

import com.nulp.armour.Armor;
import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchAmmunitionInCostDiapasonCommand extends Command {

    private final String name = "dsrch";
    private final String desc = "search ammunition in cost diapason";
    private LifecycleController lc;

    public SearchAmmunitionInCostDiapasonCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Left bound >> ");
        BigDecimal leftBound = scanner.nextBigDecimal();
        System.out.print("Right bound >> ");
        BigDecimal rightBound = scanner.nextBigDecimal();

        List<Armor> filteredAmmunition = new ArrayList<>();

        for (Armor armor : lc.getKnight().getArmorList()) {
            if(armor.getCost().compareTo(leftBound) > 0 && armor.getCost().compareTo(rightBound) < 0)
                filteredAmmunition.add(armor);
        }

        responseEntity.addPair("filtered ammunition", filteredAmmunition);
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

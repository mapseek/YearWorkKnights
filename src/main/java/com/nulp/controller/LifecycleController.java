package com.nulp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nulp.command.*;
import com.nulp.armour.Armor;
import com.nulp.knight.Knight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifecycleController {

//    private List<Armor> armorList = new ArrayList<>();
    private Knight knight;
    private final Map<String, Command> commands = new HashMap<>();

    {
        Command infoCommand = new HelpCommand(LifecycleController.this);
        Command exitCommand = new ExitCommand();
        Command loadFromFileCommand = new LoadFromFileCommand(LifecycleController.this);
        Command displayKnightCommand = new DisplayKnightCommand(LifecycleController.this);
        Command ammunitionCostCommand = new AmmunitionCostCommand(LifecycleController.this);
        Command sortAmmunitionByWeightCommand = new SortAmmunitionByWeightCommand(LifecycleController.this);
        Command searchAmmunitionByCostDiapason = new SearchAmmunitionInCostDiapasonCommand(LifecycleController.this);

        commands.put(infoCommand.getName(), infoCommand);
        commands.put(exitCommand.getName(), exitCommand);
        commands.put(loadFromFileCommand.getName(), loadFromFileCommand);
        commands.put(displayKnightCommand.getName(), displayKnightCommand);
        commands.put(ammunitionCostCommand.getName(), ammunitionCostCommand);
        commands.put(sortAmmunitionByWeightCommand.getName(), sortAmmunitionByWeightCommand);
        commands.put(searchAmmunitionByCostDiapason.getName(), searchAmmunitionByCostDiapason);
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Command> getCommands() {
        return commands;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    //    public void setArmourList(List<Armor> armorList) {
//        this.armorList = armorList;
//    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}

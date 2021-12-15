package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

public class DisplayKnightCommand extends Command {

    private final String name = "display";
    private final String desc = "displays knight and ammunition";
    private LifecycleController lc;

    public DisplayKnightCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.addPair("knight", lc.getKnight());
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

    public LifecycleController getLc() {
        return lc;
    }
}

package com.nulp.command;

import com.fasterxml.jackson.core.type.TypeReference;
import com.nulp.controller.LifecycleController;
import com.nulp.knight.Knight;
import com.nulp.response.ResponseEntity;
import com.nulp.armour.Armor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadFromFileCommand extends Command {

    private final String name = "lff";
    private final String desc = "Load data from file";

    private LifecycleController lc;

    public LoadFromFileCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity response = new ResponseEntity();

        Scanner scanner = new Scanner(System.in);
        System.out.print("File name >> ");
        String fname = scanner.nextLine();

        try {
            Knight knight = lc.getObjectMapper().readValue(new File(fname), new TypeReference<Knight>(){});
            lc.setKnight(knight);

            response.addPair("status", "loaded");
        } catch (IOException e) {
            e.printStackTrace();
            response.addPair("status", "failed");
        }

        return response;
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

package com.nulp.controllers;

import com.nulp.models.Armor;
import com.nulp.service.ArmorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/armor")

public class ArmorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArmorController.class);

    @Autowired
    private ArmorService armorService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Armor> getConference(@PathVariable(name = "id") Integer id) {
        if (armorService.getArmorID(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Armor>(armorService.getArmorID(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Armor>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Armor>>(armorService.getArmor(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Armor> createCity(@Valid @RequestBody Armor armor) {
        LOGGER.info("Success added Armor");
        return new ResponseEntity<Armor>(armorService.addArmor(armor), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Armor> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Armor armor) {
        if (armorService.getArmorID(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        armor.setId(id);
        return new ResponseEntity<Armor>(armorService.updateArmor(armor), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Armor> deleteConference(@PathVariable("id") Integer id) {
        if (armorService.getArmorID(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        armorService.deleteArmorByID(id);
        return ResponseEntity.noContent().build();
    }

}

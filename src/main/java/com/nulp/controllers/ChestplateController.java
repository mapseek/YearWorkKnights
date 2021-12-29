package com.nulp.controllers;

import com.nulp.models.Chestplate;
import com.nulp.service.ChestplateService;
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
@RequestMapping(path = "/chestplate")

public class ChestplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChestplateController.class);

    @Autowired
    private ChestplateService chestplateService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Chestplate> getConference(@PathVariable(name = "id") Integer id) {
        if (chestplateService.getChestplateId(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Chestplate>(chestplateService.getChestplateId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Chestplate>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Chestplate>>(chestplateService.getChestplate(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chestplate> createChestplate(@Valid @RequestBody Chestplate chestplate) {
        LOGGER.info("Success added chestplate");
        return new ResponseEntity<Chestplate>(chestplateService.addChestplate(chestplate), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chestplate> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Chestplate chestplate) {
        if (chestplateService.getChestplateId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        chestplate.setId(id);
        return new ResponseEntity<Chestplate>(chestplateService.updateChestplate(chestplate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Chestplate> deleteConference(@PathVariable("id") Integer id) {
        if (chestplateService.getChestplateId(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        chestplateService.deleteChestplateById(id);
        return ResponseEntity.noContent().build();
    }

}


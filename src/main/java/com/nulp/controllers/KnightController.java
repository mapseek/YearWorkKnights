package com.nulp.controllers;

import com.nulp.models.Knight;
import com.nulp.service.KnightService;
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
@RequestMapping(path = "/knight")

public class KnightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KnightController.class);

    @Autowired
    private KnightService knightService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Knight> getConference(@PathVariable(name = "id") Integer id) {
        if (knightService.getKnightId(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Knight>(knightService.getKnightId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Knight>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Knight>>(knightService.getKnight(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Knight> createKnightp(@Valid @RequestBody Knight knight) {
        LOGGER.info("Success added armor");
        return new ResponseEntity<Knight>(knightService.addKnight(knight), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Knight> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Knight knight) {
        if (knightService.getKnightId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        knight.setId(id);
        return new ResponseEntity<Knight>(knightService.updateKnight(knight), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Knight> deleteConference(@PathVariable("id") Integer id) {
        if (knightService.getKnightId(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        knightService.deleteKnightById(id);
        return ResponseEntity.noContent().build();
    }

}

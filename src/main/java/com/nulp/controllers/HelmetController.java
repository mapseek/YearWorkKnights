package com.nulp.controllers;

import com.nulp.models.Boots;
import com.nulp.models.Helmet;
import com.nulp.service.HelmetService;
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
@RequestMapping(path = "/helmet")

public class HelmetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelmetController.class);

    @Autowired
    private HelmetService helmetService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Helmet> getConference(@PathVariable(name = "id") Integer id) {
        if (helmetService.getHelmetId(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Helmet>(helmetService.getHelmetId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Helmet>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Helmet>>(helmetService.getHelmet(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Helmet> createHelmet(@Valid @RequestBody Helmet helmet) {
        LOGGER.info("Success added helmet");
        return new ResponseEntity<Helmet>(helmetService.addHelmet(helmet), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Helmet> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Helmet helmet) {
        if (helmetService.getHelmetId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        helmet.setId(id);
        return new ResponseEntity<Helmet>(helmetService.updateHelmet(helmet), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boots> deleteConference(@PathVariable("id") Integer id) {
        if (helmetService.getHelmetId(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        helmetService.deleteHelmetById(id);
        return ResponseEntity.noContent().build();
    }

}
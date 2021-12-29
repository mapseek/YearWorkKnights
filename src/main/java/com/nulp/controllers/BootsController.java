package com.nulp.controllers;

import com.nulp.models.Boots;
import com.nulp.service.BootsService;
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
@RequestMapping(path = "/boots")

public class BootsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootsController.class);

    @Autowired
    private BootsService bootsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Boots> getConference(@PathVariable(name = "id") Integer id) {
        if (bootsService.getBootsId(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Boots>(bootsService.getBootsId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Boots>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Boots>>(bootsService.getBoots(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boots> createBoots(@Valid @RequestBody Boots boots) {
        LOGGER.info("Success added boots");
        return new ResponseEntity<Boots>(bootsService.addBoots(boots), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boots> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Boots boots) {
        if (bootsService.getBootsId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        boots.setId(id);
        return new ResponseEntity<Boots>(bootsService.updateBoots(boots), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boots> deleteConference(@PathVariable("id") Integer id) {
        if (bootsService.getBootsId(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        bootsService.deleteBootsById(id);
        return ResponseEntity.noContent().build();
    }

}

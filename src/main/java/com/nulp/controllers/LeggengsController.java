package com.nulp.controllers;

import com.nulp.models.Leggins;
import com.nulp.service.LegginsService;
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
@RequestMapping(path = "/leggins")

public class LeggengsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeggengsController.class);

    @Autowired
    private LegginsService legginsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Leggins> getConference(@PathVariable(name = "id") Integer id) {
        if (legginsService.getLeggengsId(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Leggins>(legginsService.getLeggengsId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Leggins>> getConference() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Leggins>>(legginsService.getLeggengs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Leggins> createLeggengs(@Valid @RequestBody Leggins leggengs) {
        LOGGER.info("Success added leggengs");
        return new ResponseEntity<Leggins>(legginsService.addLeggengs(leggengs), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Leggins> updateConference(@PathVariable("id")final int id, @Valid @RequestBody final Leggins leggins) {
        if (legginsService.getLeggengsId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
        }
        LOGGER.info("Updated an item with id: " + id);
        leggins.setId(id);
        return new ResponseEntity<Leggins>(legginsService.updateLeggengs(leggins), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Leggins> deleteConference(@PathVariable("id") Integer id) {
        if (legginsService.getLeggengsId(id) == null) {
            LOGGER.info("Can't delete Item ");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        legginsService.deleteLeggengsById(id);
        return ResponseEntity.noContent().build();
    }

}

package com.isys.catz.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isys.catz.domain.Cat;
import com.isys.catz.domain.CatService;

@RestController
@RequestMapping("/api/v1/cats")
public class CatController {
    
    @Autowired
    public CatService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Cat> getCats() {
        return service.findAll();
    }
   
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Cat> getCat(@PathVariable("name") String name) {
        return service.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
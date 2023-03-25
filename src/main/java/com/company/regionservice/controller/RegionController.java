package com.company.regionservice.controller;

import com.company.regionservice.exception.RegionAlreadyExistsException;
import com.company.regionservice.exception.RegionNotFoundException;
import com.company.regionservice.model.Regions;
import com.company.regionservice.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionController {

    public final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Regions>> getRegions(@RequestParam(required = false) String name){
        return new ResponseEntity<>(regionService.getRegions(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regions> getRegion(@PathVariable String id) {
        return new ResponseEntity<>(getRegionById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Regions> createRegion(@RequestBody Regions newRegion){
        return new ResponseEntity<>(regionService.createRegion(newRegion), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable String id){
        regionService.deleteRegion(id);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRegion(@PathVariable String id, @RequestBody Regions newRegion){
        regionService.updateRegion(id,newRegion);
        return new ResponseEntity<>(OK);
    }




    private Regions getRegionById(String id) {
        return regionService.getRegionById(id);
    }


    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<String> handleRegionNotFoundException(RegionNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(RegionAlreadyExistsException.class)
    public ResponseEntity<String> handleRegionAlreadyExistsException(RegionAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), CONFLICT);
    }




}




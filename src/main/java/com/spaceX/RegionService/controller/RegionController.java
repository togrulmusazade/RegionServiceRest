package com.spaceX.RegionService.controller;

import com.spaceX.RegionService.exception.RegionAlreadyExistException;
import com.spaceX.RegionService.exception.RegionNotFoundException;
import com.spaceX.RegionService.model.Region;
import com.spaceX.RegionService.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regions")
@AllArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getRegions(@RequestParam(required = false) String name){
        return new ResponseEntity<>(regionService.getRegions(name), OK);
    }


    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region newRegion){
        return new ResponseEntity<>(regionService.createRegion(newRegion), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRegion(@PathVariable Integer id, @RequestBody Region newRegion){
        regionService.updateRegion(id, newRegion);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id){
        regionService.deleteRegion(id);
        return new ResponseEntity<>(OK);
    }





    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<String> handleRegionNotFoundException(RegionNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(RegionAlreadyExistException.class)
    public ResponseEntity<String> handleRegionAlreadyExistException(RegionAlreadyExistException ex){
        return new ResponseEntity<>(ex.getMessage(), CONFLICT);
    }




}




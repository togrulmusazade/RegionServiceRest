package com.spaceX.RegionService.service;


import com.spaceX.RegionService.exception.RegionAlreadyExistException;
import com.spaceX.RegionService.exception.RegionNotFoundException;
import com.spaceX.RegionService.model.Region;
import com.spaceX.RegionService.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getRegions(String name) {
        if(name==null){
            return regionRepository.findAll();
        } else {
            return regionRepository.findAllByName(name);
        }
    }

    public Region createRegion(Region newRegion) {
        Optional<Region> region = regionRepository.findByName(newRegion.getName());
        if (region.isEmpty()){
            return regionRepository.save(newRegion);
        } else {
            throw new RegionAlreadyExistException("Region already exist with name: "+ newRegion.getName());
        }


    }


    public void updateRegion(Integer id, Region newRegion) {
        Region oldRegion = getRegionById(id);
        oldRegion.setName(newRegion.getName());
        regionRepository.save(oldRegion);
    }


    public void deleteRegion(Integer id){
        regionRepository.deleteById(id);
    }


    public Region getRegionById(Integer id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("region not found with id: " + id));
    }

}




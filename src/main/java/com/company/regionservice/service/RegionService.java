package com.company.regionservice.service;

import com.company.regionservice.exception.RegionAlreadyExistsException;
import com.company.regionservice.exception.RegionNotFoundException;
import com.company.regionservice.model.Regions;
import com.company.regionservice.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    public final RegionRepository regionRepository;

    public List<Regions> getRegions(String name){
        if(name==null){
            return regionRepository.findAll();
        } else {
            return regionRepository.findAllByName(name);
        }
    }


    public Regions createRegion(Regions newRegion) {
        Optional<Regions> regionByName = regionRepository.findByName(newRegion.getName());
        if (regionByName.isPresent()){
            throw new RegionAlreadyExistsException("Region already exist with name:"+newRegion.getName());
        }
        return regionRepository.save(newRegion);
    }

    public void deleteRegion(String id) {
        regionRepository.deleteById(id);
    }

    public void updateRegion(String id, Regions newRegion) {
        Regions oldRegion = getRegionById(id);
        oldRegion.setName(newRegion.getName());
        regionRepository.save(oldRegion);
    }

    public Regions getRegionById(String id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("region not found with id: " + id));
    }

}




package com.company.regionservice.repository;

import com.company.regionservice.model.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Regions, String> {

    public Optional<Regions> findByName(String name);
    public List<Regions> findAllByName(String name);

    public Regions findRegionById(Integer id);

}

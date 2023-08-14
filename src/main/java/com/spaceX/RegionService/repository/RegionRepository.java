package com.spaceX.RegionService.repository;

import com.spaceX.RegionService.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
    List<Region> findAllByName(String name);

    Optional<Region> findByName(String name);
}




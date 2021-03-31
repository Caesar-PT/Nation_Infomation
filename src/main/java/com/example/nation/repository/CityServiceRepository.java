package com.example.nation.repository;

import com.example.nation.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityServiceRepository extends JpaRepository<City, Long> {
    List<City> findAllByName(String name);
}

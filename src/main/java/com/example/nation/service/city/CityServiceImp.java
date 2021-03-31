package com.example.nation.service.city;

import com.example.nation.model.City;
import com.example.nation.repository.CityServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService{
    @Autowired
    private CityServiceRepository cityServiceRepository;

    @Override
    public List<City> findAll() {
        return cityServiceRepository.findAll();
    }

    @Override
    public City save(City city) {
        return cityServiceRepository.save(city);
    }

    @Override
    public City findById(long id) {
        return cityServiceRepository.getOne(id);
    }

    @Override
    public City update(City city) {
        return cityServiceRepository.save(city);
    }

    @Override
    public boolean remove(long id) {
        cityServiceRepository.deleteById(id);
        return true;
    }

    @Override
    public List<City> findAllByName(String name) {
        return cityServiceRepository.findAllByName(name);
    }
}

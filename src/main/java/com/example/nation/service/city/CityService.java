package com.example.nation.service.city;

import com.example.nation.model.City;
import com.example.nation.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService extends IGeneralService<City> {
    List<City> findAllByName(String name);
}

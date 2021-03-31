package com.example.nation.service.nation;

import com.example.nation.model.Nation;
import com.example.nation.repository.NationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NationServiceImp implements NationService{
    @Autowired
    private NationServiceRepository nationServiceRepository;

    @Override
    public List<Nation> findAll() {
        return nationServiceRepository.findAll();
    }

    @Override
    public Nation save(Nation nation) {
        return nationServiceRepository.save(nation);
    }

    @Override
    public Nation findById(long id) {
        return nationServiceRepository.getOne(id);
    }

    @Override
    public Nation update(Nation nation) {
        return nationServiceRepository.save(nation);
    }

    @Override
    public boolean remove(long id) {
        nationServiceRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Nation> findAllByName(String name) {
        return null;
    }
}

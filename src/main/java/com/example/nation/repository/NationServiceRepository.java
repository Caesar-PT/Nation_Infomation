package com.example.nation.repository;

import com.example.nation.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationServiceRepository extends JpaRepository<Nation, Long> {
}

package com.nulp.repository;

import com.nulp.models.Chestplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChestplateRepository extends JpaRepository<Chestplate, Integer> {
}

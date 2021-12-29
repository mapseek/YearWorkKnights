package com.nulp.repository;

import com.nulp.models.Boots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootsRepository extends JpaRepository<Boots, Integer> {
}

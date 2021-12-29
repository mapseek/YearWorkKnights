package com.nulp.repository;

import com.nulp.models.Knight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnightpRepository extends JpaRepository<Knight, Integer> {
}

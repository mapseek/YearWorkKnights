package com.nulp.repository;

import com.nulp.models.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelmetRepository extends JpaRepository<Helmet, Integer> {
}

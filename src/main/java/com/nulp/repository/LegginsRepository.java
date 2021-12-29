package com.nulp.repository;

import com.nulp.models.Leggins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegginsRepository extends JpaRepository<Leggins, Integer> {
}
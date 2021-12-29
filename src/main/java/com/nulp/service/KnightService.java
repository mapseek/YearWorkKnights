package com.nulp.service;

import com.nulp.models.Helmet;
import com.nulp.models.Knight;
import com.nulp.repository.KnightpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class KnightService {

    @Autowired
    public com.nulp.repository.KnightpRepository KnightRepository;

    public Knight addKnight(final Knight knightp) {
        return KnightRepository.save (knightp);
    }

    public Knight updateKnight(final Knight knightp) {
        return KnightRepository.save(knightp);
    }

    public List<Knight> getKnight() {
        return KnightRepository.findAll();
    }

    public Knight getKnightId(final Integer ArmorID) {
        return KnightRepository.findById(ArmorID).orElse(null);
    }

    public void deleteKnightById(Integer ArmorID){
        KnightRepository.deleteById(ArmorID);
    }

}

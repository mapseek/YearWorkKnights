package com.nulp.service;

import com.nulp.models.Chestplate;
import com.nulp.models.Helmet;
import com.nulp.repository.HelmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class HelmetService {

    @Autowired
    public com.nulp.repository.HelmetRepository HelmetRepository;

    public Helmet addHelmet(final Helmet helmet) {
        return HelmetRepository.save(helmet);
    }

    public Helmet updateHelmet(final Helmet helmet) {
        return HelmetRepository.save(helmet);
    }

    public List<Helmet> getHelmet() {
        return HelmetRepository.findAll();
    }

    public Helmet getHelmetId(final Integer ID) {
        return HelmetRepository.findById(ID).orElse(null);
    }

    public void deleteHelmetById(Integer ID){
        HelmetRepository.deleteById(ID);
    }

}

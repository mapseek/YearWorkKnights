package com.nulp.service;

import com.nulp.models.Leggins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class LegginsService {

    @Autowired
    public com.nulp.repository.LegginsRepository legginsRepository;

    public Leggins addLeggengs(final Leggins leggins) {
        return legginsRepository.save(leggins);
    }

    public Leggins updateLeggengs(final Leggins leggins) {
        return legginsRepository.save(leggins);
    }

    public List<Leggins> getLeggengs() {
        return legginsRepository.findAll();
    }

    public Leggins getLeggengsId(final Integer ID) {
        return legginsRepository.findById(ID).orElse(null);
    }

    public void deleteLeggengsById(Integer ID){
        legginsRepository.deleteById(ID);
    }

}

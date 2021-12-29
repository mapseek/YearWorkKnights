package com.nulp.service;

import com.nulp.models.Boots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class BootsService {

    @Autowired
    public com.nulp.repository.BootsRepository BootsRepository;

    public Boots addBoots(final Boots boots) {
        return BootsRepository.save(boots);
    }

    public Boots updateBoots(final Boots boots) {
        return BootsRepository.save(boots);
    }

    public List<Boots> getBoots() {
        return BootsRepository.findAll();
    }

    public Boots getBootsId(final Integer ID) {
        return BootsRepository.findById(ID).orElse(null);
    }

    public void deleteBootsById(Integer ID){
        BootsRepository.deleteById(ID);
    }

}

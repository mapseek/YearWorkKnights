package com.nulp.service;

import com.nulp.models.Armor;
import com.nulp.models.Boots;
import com.nulp.models.Chestplate;
import com.nulp.repository.ChestplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class ChestplateService {

    @Autowired
    public com.nulp.repository.ChestplateRepository ChestplateRepository;

    public Chestplate addChestplate(final Chestplate chestplate) {
        return ChestplateRepository.save(chestplate);
    }

    public Chestplate updateChestplate(final Chestplate chestplate) {
        return ChestplateRepository.save(chestplate);
    }

    public List<Chestplate> getChestplate() {
        return ChestplateRepository.findAll();
    }

    public Chestplate getChestplateId(final Integer ID) {
        return ChestplateRepository.findById(ID).orElse(null);
    }

    public void deleteChestplateById(Integer ID){
        ChestplateRepository.deleteById(ID);
    }

}

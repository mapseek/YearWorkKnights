package com.nulp.service;

import com.nulp.models.Armor;
import com.nulp.repository.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope

public class ArmorService {

    @Autowired
    public ArmorRepository ArmorRepository;

    public Armor addArmor(final Armor armor) {
        return ArmorRepository.save(armor);
    }

    public Armor updateArmor(final Armor armor) {
        return ArmorRepository.save(armor);
    }

    public List<Armor> getArmor() {
        return ArmorRepository.findAll();
    }

    public Armor getArmorID(final Integer SetID) {
        return ArmorRepository.findById(SetID).orElse(null);
    }

    public void deleteArmorByID(Integer SetID){
        ArmorRepository.deleteById(SetID);
    }

}

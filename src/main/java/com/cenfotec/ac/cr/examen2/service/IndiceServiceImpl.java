package com.cenfotec.ac.cr.examen2.service;

import com.cenfotec.ac.cr.examen2.entities.Indice;
import com.cenfotec.ac.cr.examen2.entities.Jugador;
import com.cenfotec.ac.cr.examen2.repo.IndiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndiceServiceImpl implements IndiceService{
    @Autowired
    IndiceRepo indiceRepo;

    @Override
    public void registrarIndice(Indice indice) {
        indiceRepo.save(indice);
    }
    @Override
    public List<Indice> getByKeyId(Long keyword) {
        return indiceRepo.findByKeyId(keyword);
    }
}

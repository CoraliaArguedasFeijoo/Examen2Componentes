package com.cenfotec.ac.cr.examen2.service;

import com.cenfotec.ac.cr.examen2.entities.Indice;
import com.cenfotec.ac.cr.examen2.entities.Jugador;

import java.util.List;

public interface IndiceService {
    public void registrarIndice(Indice indice);
    public List<Indice> getByKeyId(Long keyword);
}

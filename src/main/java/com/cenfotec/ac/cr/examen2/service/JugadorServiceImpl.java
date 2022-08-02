package com.cenfotec.ac.cr.examen2.service;

import com.cenfotec.ac.cr.examen2.entities.Jugador;
import com.cenfotec.ac.cr.examen2.repo.JugadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    JugadorRepo personaRepo;

    @Override
    public void registrarPersona(Jugador persona) {
        personaRepo.save(persona);
    }

    @Override
    public List<Jugador> listarPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public void update(Jugador persona) {
        personaRepo.save(persona);
    }

    @Override
    public void delete(int id) {
        personaRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Jugador> getById(int id) {
        return personaRepo.findById(Long.valueOf(id));
    }

    public List<Jugador> getByKeyword(String keyword) {
        return personaRepo.findByKeyword(keyword);
    }

    public List<Jugador> getByKeyId(Long keyword) {
        return personaRepo.findByKeyId(keyword);
    }
}
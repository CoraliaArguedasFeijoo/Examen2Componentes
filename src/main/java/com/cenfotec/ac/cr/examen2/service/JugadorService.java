package com.cenfotec.ac.cr.examen2.service;

import com.cenfotec.ac.cr.examen2.entities.Jugador;
import java.util.List;
import java.util.Optional;

public interface JugadorService {
    public void registrarPersona(Jugador persona);
    public List<Jugador> listarPersonas();

    public void update(Jugador persona);
    public void delete(int id);

    public Optional<Jugador> getById(int id);

    public List<Jugador> getByKeyword(String keyword);

    public List<Jugador> getByKeyId(Long keyword);

}

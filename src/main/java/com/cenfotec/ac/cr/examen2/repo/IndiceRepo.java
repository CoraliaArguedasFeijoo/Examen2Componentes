package com.cenfotec.ac.cr.examen2.repo;

import com.cenfotec.ac.cr.examen2.entities.Indice;
import com.cenfotec.ac.cr.examen2.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndiceRepo extends JpaRepository<Indice, Long> {
    @Query(value = "select * from Indice s where s.id_usuario = :id", nativeQuery = true)
    List<Indice> findByKeyId(@Param("id") Long id);
}

package com.cenfotec.ac.cr.examen2.repo;

import com.cenfotec.ac.cr.examen2.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JugadorRepo extends JpaRepository<Jugador, Long> {

    @Query(value = "select * from Jugador s where s.nombre like %:keyword% or s.primer_apellido like %:keyword% or s.segundo_apellido like %:keyword%", nativeQuery = true)
    List<Jugador> findByKeyword(@Param("keyword") String keyword);
    @Query(value = "select * from Jugador s where s.id = :id", nativeQuery = true)
    List<Jugador> findByKeyId(@Param("id") Long id);
}

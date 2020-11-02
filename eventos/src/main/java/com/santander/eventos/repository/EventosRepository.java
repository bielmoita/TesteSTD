package com.santander.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.eventos.model.Eventos;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {
	public List<Eventos> findAllByTituloContainingIgnoreCase(String titulo);

}

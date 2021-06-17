package com.app.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.financas.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

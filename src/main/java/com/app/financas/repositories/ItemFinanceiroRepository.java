package com.app.financas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.financas.models.ItemFinanceiro;

@Repository
public interface ItemFinanceiroRepository extends JpaRepository<ItemFinanceiro, Long>{

	@Query("Select if from ItemFinanceiro if where if.categoria.id = :idCat order by descricao")
	public List<ItemFinanceiro> findAllByCategoria(@Param(value="idCat") Long idCategoria);
	
}

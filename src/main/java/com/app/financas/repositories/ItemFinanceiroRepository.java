package com.app.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.financas.models.ItemFinanceiro;

@Repository
public interface ItemFinanceiroRepository extends JpaRepository<ItemFinanceiro, Long>{

}

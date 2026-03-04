package com.miguel.cashflow.repository;

import com.miguel.cashflow.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}

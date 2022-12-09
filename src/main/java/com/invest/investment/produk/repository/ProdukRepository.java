package com.invest.investment.produk.repository;

import com.invest.investment.produk.entity.ProdukEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdukRepository extends JpaRepository<ProdukEntity, Long> {
    List<ProdukEntity> findByCategory(Long idCategory);
}
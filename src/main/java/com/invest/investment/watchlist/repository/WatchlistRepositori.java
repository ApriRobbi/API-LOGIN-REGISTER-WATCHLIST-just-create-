package com.invest.investment.watchlist.repository;

import com.invest.investment.watchlist.entity.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchlistRepositori extends JpaRepository<WatchlistEntity, Long> {
//    Optional<WatchlistEntity> findByUserIdAndProdukId(Long userId, Long produkId);
}

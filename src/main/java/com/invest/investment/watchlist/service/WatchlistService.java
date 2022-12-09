package com.invest.investment.watchlist.service;

import com.invest.investment.exception.PermintaanTidakDikabulkanException;
import com.invest.investment.produk.entity.ProdukEntity;
import com.invest.investment.produk.repository.ProdukRepository;
import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.repository.UserRepository;
import com.invest.investment.watchlist.entity.WatchlistEntity;
import com.invest.investment.watchlist.repository.WatchlistRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class WatchlistService {

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private WatchlistRepositori watchlistRepositori;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public WatchlistEntity create(Long userId, Long produkId){

        ProdukEntity produkEntity = produkRepository.findById(produkId)
                .orElseThrow(() -> new PermintaanTidakDikabulkanException("Produk dengan Id " + produkId + "tidak ditemukan"));

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new PermintaanTidakDikabulkanException("User dengan ID " + userId + "tidak ditemukan"));

//        Optional<WatchlistEntity>optional =watchlistRepositori.findByUserIdAndProdukId(userId, produkId);

        WatchlistEntity watchlist;
        watchlist = new WatchlistEntity();
        watchlist.setProdukEntity(produkEntity);
        watchlist.setUserEntity(userEntity);

        watchlistRepositori.save(watchlist);
        return watchlist;
    }
}

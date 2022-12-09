package com.invest.investment.watchlist.entity;

import com.invest.investment.produk.entity.ProdukEntity;
import com.invest.investment.produk.repository.ProdukRepository;
import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class WatchlistEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wachlist")
    private Long idWatchlist;

    @JoinColumn
    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private ProdukEntity produkEntity;
}

package com.invest.investment.user.entity;

import com.invest.investment.watchlist.entity.WatchlistEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String namaLengkap;

    private String password;

    private String email;

    private String alamat;

    private String nomorTelfon;

    public UserEntity(Long userId){
        this.userId =userId;
    }
}

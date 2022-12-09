package com.invest.investment.produk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "produk")
public class ProdukEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_produk")
    private String namaProduk;

    @Column(name = "deskripsi_produk")
    private String deskripsi;

    @Column(name = "deskripsi_produk_lengkap")
    private String deskripsi_lengkap;

    @Column(name = "harga_produk_string")
    private String harga;

    @Column(name = "category")
    private Long category;
}

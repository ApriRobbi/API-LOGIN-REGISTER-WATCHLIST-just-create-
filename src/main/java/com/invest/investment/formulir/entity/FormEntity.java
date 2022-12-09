package com.invest.investment.formulir.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "form")
public class FormEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name", nullable = false)
    private String fullname;
    @Column(name = "tanggal_lahir",nullable = false)
    private String tanggallahir;
    @Column(name = "phone_num",nullable = false)
    private String phonenum;
    @Column(name = "email_address",nullable = false)
    private String email;
    @Column(name = "home_address",nullable = false)
    private String address;
    @Column(name = "no_rek",nullable = false)
    private String norek;
    @Column(name = "jenis_asuransi",nullable = false)
    private String jenisasuransi;
    @Column(name = "nik_user",nullable = false)
    private String nik;
    @Column(name = "asuransi_bank",nullable = false)
    private String asuransibank;
}

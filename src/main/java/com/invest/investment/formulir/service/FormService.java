package com.invest.investment.formulir.service;

import com.invest.investment.exception.PermintaanTidakDikabulkanException;
import com.invest.investment.formulir.entity.FormEntity;
import com.invest.investment.formulir.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    //Mencari semua data formulir
    public List<FormEntity> carisemua(){
        return formRepository.findAll();
    }
    //input data
    public  FormEntity mengisidata(FormEntity formEntity){
        //validasi
        if (!StringUtils.hasText(formEntity.getAddress())){
            throw new PermintaanTidakDikabulkanException("Alamat Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(formEntity.getAsuransibank())){
            throw new PermintaanTidakDikabulkanException("Nama Bank Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(formEntity.getTanggallahir())){
            throw new PermintaanTidakDikabulkanException("Tanggal Lahir Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(formEntity.getJenisasuransi())){
            throw new PermintaanTidakDikabulkanException("Jenis Asuransi Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(formEntity.getFullname())){
            throw new PermintaanTidakDikabulkanException("Nama Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(formEntity.getEmail())){
            throw new PermintaanTidakDikabulkanException("Email Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(String.valueOf(formEntity.getNik()))){
            throw new PermintaanTidakDikabulkanException("NIK Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(String.valueOf(formEntity.getTanggallahir()))){
            throw new PermintaanTidakDikabulkanException("Tanggal Lahir Tidak Boleh Kosong");
        }
        if (!StringUtils.hasText(String.valueOf(formEntity.getNorek()))){
            throw new PermintaanTidakDikabulkanException("Nomor Rekening Tidak Boleh Kosong");
        }
        return formRepository.save(formEntity);
    }
    //DELETE
    public void deleteById(Long id){
        formRepository.deleteById(id);
    }
}

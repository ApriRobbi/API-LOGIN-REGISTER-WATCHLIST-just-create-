package com.invest.investment.user.service;

import com.invest.investment.exception.PermintaanTidakDikabulkanException;
import com.invest.investment.exception.TidakKetemuException;
import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public UserEntity findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new TidakKetemuException("Pengguna dengan ID " + id + " tidak ditemukan"));
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    //METHOD UNTUK CREATE USER
    public UserEntity create(UserEntity userEntity){

        if (!StringUtils.hasText(userEntity.getNamaLengkap())){
            throw new PermintaanTidakDikabulkanException("Nama Lengkap Harus Diisi");
        }

//        if (StringUtils.hasText(userEntity.getEmail())){
//            throw new PermintaanTidakDikabulkanException("Email harus diisi");
//        }

        if (!StringUtils.hasText(userEntity.getPassword())){
            throw new PermintaanTidakDikabulkanException("Password Harus Diisi");
        }

        if (userRepository.existsByEmail(userEntity.getEmail())){
            throw new PermintaanTidakDikabulkanException("Email " + userEntity.getEmail() + " sudah terdaftar");
        }

        return userRepository.save(userEntity);
    }

    public UserEntity edit(UserEntity userEntity){

        if (userEntity.getUserId() == null){
            throw new PermintaanTidakDikabulkanException("Id User harus diisi");
        }
        return userRepository.save(userEntity);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

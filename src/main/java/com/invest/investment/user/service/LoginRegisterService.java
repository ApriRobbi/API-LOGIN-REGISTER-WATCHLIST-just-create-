package com.invest.investment.user.service;

import com.invest.investment.user.dto.ApiResponse;
import com.invest.investment.user.dto.LoginDto;
import com.invest.investment.user.dto.RegisterDto;
import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginRegisterService {

    @Autowired
    UserRepository userRepository;

    public ApiResponse register(RegisterDto registerDto){

        ApiResponse apiResponse = new ApiResponse();

        UserEntity userEntity = new UserEntity();
        userEntity.setNamaLengkap(registerDto.getNamaLengkap());
        userEntity.setEmail(registerDto.getEmail());
        userEntity.setPassword(registerDto.getPassword());
        userEntity.setAlamat(registerDto.getAlamat());
        userEntity.setNomorTelfon(registerDto.getNomorTelfon());

        userEntity = userRepository.save(userEntity);

        apiResponse.setData(userEntity);

        return apiResponse;
    }

    public ApiResponse signin(LoginDto loginDto){

        ApiResponse apiResponse = new ApiResponse();

        UserEntity userEntity = userRepository.findByEmailAndPassword(
            loginDto.getEmail(), loginDto.getPassword());

        //perlu di hashmap untuk menunjukan data yaitu data entiti pada saat user berhasil login
        Map<String, Object> data = new HashMap<>();
        data.put("user", userEntity);

        if (userEntity == null){
            apiResponse.setData("USER TIDAK BISA LOGIN");
        } else {
            apiResponse.setData(data);
        }

        return apiResponse;
    }


}

package com.invest.investment.formulir.controller;

import com.invest.investment.formulir.entity.FormEntity;
import com.invest.investment.formulir.repository.FormRepository;
import com.invest.investment.formulir.service.FormService;
import com.invest.investment.produk.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class FormController {
    @Autowired
    private FormService formService;

    //Mencari semua formulir
    @GetMapping("/formulir")
    public List<FormEntity> carisemua(){return formService.carisemua();}

    //post data
    @PostMapping("/formulir")
    public FormEntity tambahdata(@RequestBody FormEntity formEntity){
        return formService.mengisidata(formEntity);
    }
    //Delete data
    @DeleteMapping("/formulir/{id}")
    public void deleteform(@PathVariable("id")Long formId){formService.deleteById(formId);}
}

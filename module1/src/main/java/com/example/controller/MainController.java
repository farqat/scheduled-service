package com.example.controller;

import com.example.model.Datas;
import com.example.repos.DatasRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/module1")
public class MainController {

    private final DatasRepo datasRepo;

    @GetMapping
    public Page<Datas> getAllDatas(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "15", required = false) Integer size,
            @RequestParam(value = "isSend", defaultValue = "true", required = false) boolean isSend
            ) {
        Pageable pageable = PageRequest.of(page, size);
        if(!isSend){
            return datasRepo.getAllFalse(pageable);
        }
        return datasRepo.getAllTrue(pageable);
    }


    @PostMapping
    public String addDatasList(List<Datas> datasList) {
        datasRepo.saveAllAndFlush(datasList);
        return "All data write successfuly";
    }
}

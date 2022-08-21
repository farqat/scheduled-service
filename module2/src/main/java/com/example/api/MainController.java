package com.example.api;

import com.example.model.Datas;
import com.example.repos.DatasRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/module2")
@RequiredArgsConstructor
public class MainController {

    private final DatasRepo datasRepo;

    @GetMapping
    public Page<Datas> getAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "25", required = false) Integer size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return datasRepo.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<String> saveDatas(@RequestBody Datas datas){
        if(datas !=null){
            datasRepo.saveAndFlush(datas);
            System.out.println("Saved message " + datas.getMessage() + " to database");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

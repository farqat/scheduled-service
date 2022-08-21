package com.example.service;

import com.example.model.Datas;
import com.example.model.DatasDTO;
import com.example.repos.DatasRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMessage {

    private final DatasRepo datasRepo;

    public void sendMessage(){
        List<Datas> all = datasRepo.findAll();
        List<Datas> collect = all.stream().filter(e -> !e.isSend()).collect(Collectors.toList());
        if(!collect.isEmpty()){
            RestTemplate rs = new RestTemplate();
            String url = "http://localhost:9001/api/v1/module2";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            for(Datas d: collect){
                DatasDTO data = new DatasDTO();
                data.setMessage(d.getMessage());
                HttpEntity<DatasDTO> request = new HttpEntity<>(data, headers);
                try{
                    ResponseEntity<DatasDTO> response = rs.postForEntity(url, request, DatasDTO.class);
                    if(response.getStatusCode() == HttpStatus.CREATED){
                        System.out.println("Successful " + data.getMessage());
                        d.setSend(true);
                        datasRepo.saveAndFlush(d);
                    }
                }catch (Exception e){
                    log.info(String.format("Service with url %s not working", url));

                }
            }

        }else{
            System.out.println("No Message to Send...");
        }
    }
}

package com.example;

import com.example.model.Datas;
import com.example.repos.DatasRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Moldule1
{
    public static void main( String[] args )
    {
        SpringApplication.run(Moldule1.class,args);
    }

    /*@Bean
    public CommandLineRunner runner(DatasRepo datasRepo){
        return args ->{
            List<Datas> list = datasRepo.findAll();
            for(Datas d: list){
                Random rd = new Random();
                d.setSend(rd.nextBoolean());
                datasRepo.saveAndFlush(d);
            }
        };
    }*/


}

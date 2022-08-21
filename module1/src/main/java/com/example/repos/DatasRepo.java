package com.example.repos;

import com.example.model.Datas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DatasRepo extends JpaRepository<Datas, Long> {

    @Query("select d FROM Datas d where d.isSend = true")
    Page<Datas> getAllTrue(Pageable pageable);

    @Query("select d FROM Datas d where d.isSend = false")
    Page<Datas> getAllFalse(Pageable pageable);
}

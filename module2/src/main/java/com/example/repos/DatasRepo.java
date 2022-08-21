package com.example.repos;

import com.example.model.Datas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatasRepo extends JpaRepository<Datas, Long> {
}

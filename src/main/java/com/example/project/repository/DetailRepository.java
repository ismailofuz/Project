package com.example.project.repository;

import com.example.project.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DetailRepository extends JpaRepository<Detail, UUID> {

    List<Detail> findAllByProduct_Id(Integer id);

    List<Detail> findAllByOrder_Id(UUID id);

}

package com.example.bassmaonline.Reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bassmaonline.entity.CommandeEntity;

public  interface CommandeReposotory extends JpaRepository<CommandeEntity, Long>  {
       CommandeEntity findByOrderId(Long orderId);

       @Query("SELECT r FROM CommandeEntity r WHERE r.adresse = :adresse ")
       List<CommandeEntity> getCommandeEntitiesByAdresse(@Param("adresse") String adresse);
       
}


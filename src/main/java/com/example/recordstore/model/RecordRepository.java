package com.example.recordstore.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepository extends JpaRepository<Record, Long> {
	@Query("SELECT p FROM Record p WHERE CONCAT(p.title, ' ', p.artist, ' ', p.year, ' ', p.condition, ' ',p.price) LIKE %?1%")
    List<Record>findByTitle(String title);
    
}
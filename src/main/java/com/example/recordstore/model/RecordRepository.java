package com.example.recordstore.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, Long> {
	
	@Query(value = "SELECT * FROM Record r WHERE r.title LIKE %:keyword% or r.artist LIKE %:keyword%", nativeQuery=true)
    List<Record>findByKeyword(@Param("keyword") String keyword);
    
}
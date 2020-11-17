package com.example.recordstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recordstore.model.Record;
import com.example.recordstore.model.RecordRepository;

@Service
public class RecordService {
    @Autowired
    private RecordRepository repo;
     
    public List<Record> findByKeyword(String keyword) {
    	return repo.findByKeyword(keyword);
    }
    
    public List<Record> getRecords(){
    	return repo.findAll();
    }
     
}

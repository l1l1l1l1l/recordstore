package com.example.recordstore.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recordstore.model.Record;
import com.example.recordstore.model.RecordRepository;

@Service
public class RecordService {
    @Autowired
    private RecordRepository repo;
     
    public List<Record> listAll(String title) {
        if (title != null) {
            return repo.findByTitle(title);
        }
        return repo.findAll();
    }
     
}

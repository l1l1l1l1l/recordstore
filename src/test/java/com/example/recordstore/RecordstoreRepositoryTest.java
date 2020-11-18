package com.example.recordstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.recordstore.model.Genre;
import com.example.recordstore.model.Record;
import com.example.recordstore.model.RecordRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RecordstoreRepositoryTest {
	
	@Autowired
	private RecordRepository repository;
	
    @Test
    public void findByTitleShouldReturnRecord() {
        List<Record> records = repository.findByKeyword("Kind of blue");
        
        assertThat(records).hasSize(1);
        assertThat(records.get(0).getArtist()).isEqualTo("Daves Miles");
    }
    
    @Test
    public void createNewRecord() {
    	Record record = new Record("A Fireside Chat With Lucifer", "Sun Ra", 1974, "Good", 20.99, new Genre("Jazz"));
    	repository.save(record);
    	assertThat(record.getId()).isNotNull();
    }    
    
    @Test
    public void deleteRecord() {
		repository.delete(repository.findByKeyword("Kind of blue").get(0));
		List<Record> records = repository.findByKeyword("Kind of blue");
		assertThat(records).hasSize(0);
	}
    
}

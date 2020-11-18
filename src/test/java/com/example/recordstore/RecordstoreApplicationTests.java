package com.example.recordstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.recordstore.model.UserRepository;
import com.example.recordstore.web.RecordController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecordstoreApplicationTests {
	
	@Autowired
	private RecordController recordController;

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(recordController).isNotNull();
		assertThat(userRepo).isNotNull();
	}

}
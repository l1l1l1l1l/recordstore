package com.example.recordstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.recordstore.model.Genre;
import com.example.recordstore.model.GenreRepository;
import com.example.recordstore.model.Record;
import com.example.recordstore.model.RecordRepository;
import com.example.recordstore.model.User;
import com.example.recordstore.model.UserRepository;

@SpringBootApplication
public class RecordStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(RecordStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecordStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recordDemo(RecordRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			
			// Create genres
			log.info("save a couple of records");
			grepository.save(new Genre("Rock"));
			grepository.save(new Genre("Metal"));
			grepository.save(new Genre("Indie"));
			grepository.save(new Genre("Jazz"));
			
			repository.save(new Record("Kind of blue", "Daves Miles", 1929, "Good", 15, grepository.findByName("Rock").get(0)));
			repository.save(new Record("jee", "joonas", 1945, "Good", 18.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("joo", "asdasd", 2415, "Good", 21.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("omena", "Sun Ra", 1234, "Good", 39.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("donitsi", "Sun Ra", 3516, "Good", 59.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("päärynä", "Sun Ra", 1269, "Good", 10.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("jeejee", "Sun Ra", 2844, "Good", 7.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("A Fireside Chat With Lucifer", "Sun Ra", 1945, "Good", 20.99, grepository.findByName("Metal").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "jorma@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "jaakko123@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all records");
			for (Record record : repository.findAll()) {
				log.info(record.toString());
			}

		};
	}
}
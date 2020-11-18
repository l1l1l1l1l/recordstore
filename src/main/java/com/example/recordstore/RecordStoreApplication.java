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
			grepository.save(new Genre("Funk"));
			grepository.save(new Genre("Reggae"));
			grepository.save(new Genre("Electronic"));
			grepository.save(new Genre("Blues"));
			grepository.save(new Genre("Jazz"));
			
			repository.save(new Record("Kind of blue", "Daves Miles", 1929, "Good", 15, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("In a silent way", "Daves Miles", 1929, "Good", 15, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("Four classic albums", "Daves Miles", 1929, "Good", 15, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("S&M2", "Metallica", 1945, "Good", 18.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("Master of puppets", "Metallica", 2007, "Good", 10.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("Decades", "Nightwish", 2415, "Good", 21.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("The repentless killogy", "Slayer", 2003, "Good", 19.99, grepository.findByName("Metal").get(0)));
			repository.save(new Record("Slow Rush", "Tame Impala", 1999, "Good", 10.99, grepository.findByName("Indie").get(0)));
			repository.save(new Record("Digital Shades", "M83", 1970, "Good", 7.99, grepository.findByName("Indie").get(0)));
			repository.save(new Record("Cease to Begin", "Band of horses", 2010, "Good", 7.99, grepository.findByName("Indie").get(0)));
			repository.save(new Record("Greatest hits I", "Queen", 2005, "Good", 15.99, grepository.findByName("Rock").get(0)));
			repository.save(new Record("Greatest hits II", "Queen", 2008, "Good", 15.99, grepository.findByName("Rock").get(0)));
			repository.save(new Record("Boom Chicka Boom", "Johnny Cash", 1950, "Good", 7.99, grepository.findByName("Rock").get(0)));
			repository.save(new Record("Abbey Road", "Beatles", 1960, "Good", 22, grepository.findByName("Rock").get(0)));
			repository.save(new Record("White album", "Beatles", 1978, "Good", 22, grepository.findByName("Rock").get(0)));
			repository.save(new Record("Nashville Skyline", "Bob Dylan", 1989, "Good", 26, grepository.findByName("Rock").get(0)));
			repository.save(new Record("Heliocentric Worlds Of Sun Ra Vol.1", "Sun Ra", 2020, "Good", 7.99, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("Swirling", "Sun Ra", 2844, "Good", 11.99, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("A Fireside Chat With Lucifer", "Sun Ra", 2006, "Good", 20.99, grepository.findByName("Jazz").get(0)));
			repository.save(new Record("Random Acces Memories", "Daft Punk", 2844, "Good", 11.99, grepository.findByName("Electronic").get(0)));
			repository.save(new Record("Alive", "Daft Punk", 2844, "Good", 11.99, grepository.findByName("Electronic").get(0)));
			repository.save(new Record("Daft Club", "Daft Punk", 2844, "Good", 11.99, grepository.findByName("Electronic").get(0)));
			repository.save(new Record("Toy", "Yello", 2844, "Good", 11.99, grepository.findByName("Electronic").get(0)));
			repository.save(new Record("Toych yllo", "Yello", 2844, "Good", 11.99, grepository.findByName("Electronic").get(0)));

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
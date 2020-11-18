package com.example.recordstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.recordstore.model.Genre;
import com.example.recordstore.model.GenreRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GenreRepositoryTest {
	@Autowired
	private GenreRepository grepository;
	
	@Test
	public void findByNameShouldReturnGenre() {
		List<Genre> genres = grepository.findByName("Rock");
		
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getName()).isEqualTo("Rock");
	}
	
	@Test
	public void createGenre() {
		Genre genre = new Genre("Jazz");
		grepository.save(genre);
		assertThat(genre.getGenreid()).isNotNull();
	}
	
	@Test
	public void deleteGenre() {
		grepository.delete(grepository.findByName("Metal").get(0));
		List<Genre> genres = grepository.findByName("Metal");
		assertThat(genres).hasSize(0);
	}
}
package com.example.recordstore.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Genre {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long genreId;
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Record> records;

	public Genre() {}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public Long getGenreid() {
		return genreId;
	}

	public void setGenreid(Long genreid) {
		this.genreId = genreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Record> getRecord() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreId + ", name=" + name + "]";
	}

}

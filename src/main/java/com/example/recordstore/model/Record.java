package com.example.recordstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Record {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private int year;
	private String condition;
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "genreid")
	@JsonManagedReference
    private Genre genre;
	
	public Record() {}

	public Record(String title, String artist, int year, String condition, double price, Genre genre) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.condition = condition;
		this.price = price;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
			return "Record [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + ", condition=" + condition
					+ ", price=" + price + ", genre=" + genre + "]";
		else
			return "Record [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + ", condition=" + condition
					+ ", price=" + price + "]";
	}
	
	
	
	
}
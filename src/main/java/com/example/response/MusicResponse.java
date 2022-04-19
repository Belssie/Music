package com.example.response;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.entity.Music;
import com.example.entity.Title;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MusicResponse {

	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false, unique = true)
	private long id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("author")
	private String author;
	
	@JsonIgnore
	private String genre;
	
	@JsonProperty("artist_first_name")
	private String artistFirstName;
	
	@JsonProperty("artist_last_name")
	private String artistLastName;

	private List<TitleResponse> titles;

	public MusicResponse(Music music) {
		super();
		this.id = music.getId();
		this.title = music.getTitle();
		this.author = music.getAuthor();
		this.genre = music.getGenre();
		
		this.artistFirstName = music.getArtist().getFirstName();
		this.artistLastName = music.getArtist().getLastName();
		
		if(music.getTitle() != null) {
			titles = new ArrayList<TitleResponse>();
			for (Title title : music.getTitles()) {
				titles.add(new TitleResponse(title));
			}
		}
	}
	
	
}

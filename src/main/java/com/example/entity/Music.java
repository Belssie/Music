package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.entity.Artist;

import com.example.request.CreateMusicRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "music")
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column (name ="title")
	private String title;
	
	@Column (name = "artist")
	private String author;
	
	@Column (name = "genre")
	private String genre;
	
	@OneToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@OneToMany(mappedBy = "music")
	private List<Title> titles;
	
	
	public Music(CreateMusicRequest createMusicRequest) {
		this.id = createMusicRequest.getId();
		this.title = createMusicRequest.getTitle();
		this.genre = createMusicRequest.getGenre();
	}
}

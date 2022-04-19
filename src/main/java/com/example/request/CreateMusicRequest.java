package com.example.request;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMusicRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false, unique = true)
	private Long id;
	
	@JsonProperty("title")
	@NotBlank(message = "Title is required")
	private String title;
	
	@NotBlank(message = "Author is required")
	private String author;

	private String genre;
	
	private String artistFirstName;
	
	private String artistLastName;
	
	private List<CreateTitleRequest> titles;
}

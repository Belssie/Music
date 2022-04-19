package com.example.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMusicRequest {

	@NotNull(message = "Music id is required")
	private Long id;
	
	private String title;
	
	private String author;
	
	private String genre;
}

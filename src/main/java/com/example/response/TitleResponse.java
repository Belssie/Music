package com.example.response;

import com.example.entity.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TitleResponse {

	private Long id;
	
	private String title;

	public TitleResponse(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public TitleResponse(Title title2) {
		
	}
}

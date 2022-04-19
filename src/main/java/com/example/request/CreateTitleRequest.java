package com.example.request;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTitleRequest {

	@Column(name = "title")
	private String title;
}

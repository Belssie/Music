package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "artist")
@Getter
@Setter
@NoArgsConstructor
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private Long artistId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
}

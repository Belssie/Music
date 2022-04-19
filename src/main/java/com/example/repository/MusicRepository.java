package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Music;


public interface MusicRepository extends JpaRepository <Music, Long>{

List<Music> findByTitle(String title);
	
	Music findByTitleAndGenre(String title, String genre);
	
	List<Music> findByTitleOrGenre(String title, String genre);
	
	List<Music> findByTitleIn(List<String> titles);
	
	List<Music> findByTitleContains(String title);
	
	List<Music> findByTitleStartsWith(String title);
	
	List<Music> findByTitleEndsWith(String title);
	
	@Query("From Music where title = :title and genre = :genre")
	Music getByTitleAndGenreJ(@Param ("title") String title, String genre);
	
	@Modifying
	@Transactional
	@Query("Update Music set genre = :genre where title = :title")
	Integer updateGenre(String title, String genre);
	
	@Modifying
	@Transactional
	@Query("Delete From Music where title = :title")
	Integer deleteMusicJpql(String title);
	
	List<Music> findByArtistFirstName(String artistFirstName);
	
	@Query("From Artist where artistFirstName = :artistFirstName")
	List<Music> getByArtistFirstName(String artistFirstName);
}

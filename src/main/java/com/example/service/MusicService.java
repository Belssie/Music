package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entity.Artist;
import com.example.entity.Music;
import com.example.entity.Title;
import com.example.repository.ArtistRepository;
import com.example.repository.MusicRepository;
import com.example.repository.TitleRepository;
import com.example.request.CreateMusicRequest;
import com.example.request.CreateTitleRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateMusicRequest;




@Service
public class MusicService {

	@Autowired
	MusicRepository musicRepository;
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	TitleRepository titleRepository;
	
	public List<Music> getAllMusic() {
		return musicRepository.findAll();
	}
	
	public Music createMusic(CreateMusicRequest createMusicRequest) {
		Music music = new Music(createMusicRequest);
		
		Artist artist = new Artist();
		artist.setFirstName(createMusicRequest.getArtistFirstName());
		artist.setLastName(createMusicRequest.getArtistLastName());
		
		artist = artistRepository.save(artist);
		
		music.setArtist(artist);
		music = musicRepository.save(music);
		
		List<Title> titles = new ArrayList<Title>();
		
		if (createMusicRequest.getTitle() != null) {
			for(CreateTitleRequest createTitleRequest : createMusicRequest.getTitles()) {
				Title title = new Title();
				title.setTitle(createTitleRequest.getTitle());
				title.setMusic(music);
				
				titles.add(title);
			}
			
			titleRepository.saveAll(titles);
		}
		music.setTitles(titles);
		
		return music;
	}
	
	public Music updateMusic (UpdateMusicRequest updateMusicRequest) {
		Music music = musicRepository.findById(updateMusicRequest.getId()).get();
		
		if(updateMusicRequest.getTitle() != null) { 
			music.setTitle(updateMusicRequest.getTitle());
		}
		
		music = musicRepository.save(music);
		
		return music;
	}

	public String deleteMusic(long id) {
		musicRepository.deleteById(id);
		return "Song has been deleted successfully";
	}
	
	public List<Music> getByTitle (String title){
		return musicRepository.findByTitle(title);
	}
	
	public Music getByTitleAndGenre (String title, String genre) {
		return musicRepository.findByTitleAndGenre(title, genre);
	}
	
	public List<Music> getByTitleOrGenre(String title, String genre){
		return musicRepository.findByTitleOrGenre(title, genre);
	}
	
	public List<Music> getByTitleIn (InQueryRequest inQueryRequest){
		return musicRepository.findByTitleIn(inQueryRequest.getTitles());
	}
	
	public List<Music> getAllWithPagination (int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return musicRepository.findAll(pageable).getContent();
	}
	
	public List<Music> getAllTitlesWithSorting(){
		Sort sort  = Sort.by(Sort.Direction.ASC, "title");
		
		return musicRepository.findAll(sort);
	}
	
	public List<Music> like(String title){
		return musicRepository.findByTitleContains(title);
	}
	
	public List<Music> startsWith(String title){
		return musicRepository.findByTitleStartsWith(title);
	}
	
	public List<Music> endsWith(String title){
		return musicRepository.findByTitleEndsWith(title);
	}
	
	public Music getByTitleAndGenreJ (String title, String genre) {
		return musicRepository.getByTitleAndGenreJ(title, genre);
	} 
	
	public Integer updateGenreJpql (String title,  String genre) {
		return musicRepository.updateGenre(title, genre);
	}
	
	public Integer deleteMusicJpql (String title) {
		return musicRepository.deleteMusicJpql(title);
	}
	
	public List<Music> getByArtistFirstName (String artistFirstName){
		return musicRepository.findByArtistFirstName(artistFirstName);
	}
	
	public List<Music> getByArtistFirstNameJpql (String artistFirstName){
		return musicRepository.getByArtistFirstName(artistFirstName);
	}
}

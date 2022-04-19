package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Music;
import com.example.request.InQueryRequest;
import com.example.request.UpdateMusicRequest;
import com.example.response.MusicResponse;
import com.example.service.MusicService;



@RestController
@RequestMapping("/api/music/")
public class MusicController {
	
	Logger logger = LoggerFactory.getLogger(MusicController.class);
	
	@Autowired
	MusicService musicService;
	
	@GetMapping("getAll")
	public List<MusicResponse> getAllMusic() {
		
		logger.error("Inside error");
		logger.warn("Inside warning");
		logger.info("Inside info");
		logger.debug("Inside debug");
		logger.trace("Inside trace");
		
		List<Music> musicList = musicService.getAllMusic();
		List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
		
	}
	
	@PutMapping("update")
	public MusicResponse updateMusic(@Valid @RequestBody UpdateMusicRequest updateMusicRequest) {
		Music music = musicService.updateMusic(updateMusicRequest);
		
		return new MusicResponse(music);
	}
	
	/*@DeleteMapping("delete")
	public String deleteMusic(@RequestParam long id) {
		return musicService.deleteMusic(id);
	}*/
	@DeleteMapping("delete/{id}")
	public String deleteMusic(@PathVariable long id) {
		return musicService.deleteMusic(id);
	}
	
	@GetMapping("getByTitle/{title}")
	public List<MusicResponse> getByTitle(@PathVariable String title){
	
		List<Music> musicList = musicService.getByTitle(title);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("getByTitleAndGenre/{title}/{genre}")
	public MusicResponse getByTitleAndGenre (@PathVariable String title, @PathVariable String genre) {
		return new MusicResponse(musicService.getByTitleAndGenre(title, genre));
	}
	
	@GetMapping("getByTitleOrGenre/{title}/{genre}")
	public List<MusicResponse> getByTitleOrGenre(@PathVariable String title, @PathVariable String genre){
		List<Music> musicList = musicService.getByTitleOrGenre(title, genre);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("getByTitleIn")
	public List<MusicResponse> getByTitleIn(@RequestBody InQueryRequest inQueryRequest){
		
		//logger.info("inQueryRequest = " + inQueryRequest);
		
		List<Music> musicList = musicService.getByTitleIn(inQueryRequest);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		logger.info("musicResponseList = " + musicResponseList);
		
		return musicResponseList;
	}
	
	@GetMapping ("getAllWithPagination")
	public List<MusicResponse> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Music> musicList = musicService.getAllWithPagination(pageNo, pageSize);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("getAllAccountsWithSorting")
	public List<MusicResponse> getAllAccountsWithSorting(){
        List<Music> musicList = musicService.getAllTitlesWithSorting();
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("like/{title}")
	public List<MusicResponse> like(@PathVariable String title){
        List<Music> musicList = musicService.like(title);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("startsWith/{title}")
	public List<MusicResponse> startsWith(@PathVariable String title){
        List<Music> musicList = musicService.startsWith(title);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("endsWith/{title}")
	public List<MusicResponse> endsWith(@PathVariable String title){
        List<Music> musicList = musicService.endsWith(title);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("getByTitleAndGenreJ/{title}/{genre}")
	public MusicResponse getByTitleAndGenreJ (@PathVariable String title, @PathVariable String genre) {
		return new MusicResponse(musicService.getByTitleAndGenreJ(title, genre));
	}
	
	
	@PutMapping("updateGenreWithJpql/{title}/{genre}")
	public String updateGenreWithJpql(@PathVariable String title, @PathVariable String genre) {
		return musicService.updateGenreJpql(title, genre)+ " Music updated";
	}
	
	@DeleteMapping("deleteByTitle/{title}")
	public String deleteMusicJpql(@PathVariable String title) {
		return musicService.deleteMusicJpql(title) + " Music deleted!";
	}
	
	@GetMapping("getByArtistFirstName/{artistFirstName}")
	public List<MusicResponse> getByArtistFirstName(@PathVariable String artistFirstName){
        List<Music> musicList = musicService.getByArtistFirstName(artistFirstName);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
	
	@GetMapping("getByArtistFirstNameJpql/{artistFirstName}")
	public List<MusicResponse> getByArtistFirstNameJpql(@PathVariable String artistFirstName){
        List<Music> musicList = musicService.getByArtistFirstNameJpql(artistFirstName);
		
        List<MusicResponse> musicResponseList = new ArrayList<MusicResponse>();
		
		musicList.stream().forEach(music -> {
			musicResponseList.add(new MusicResponse(music));
		});
		
		return musicResponseList;
	}
}

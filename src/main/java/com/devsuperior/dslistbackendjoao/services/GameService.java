package com.devsuperior.dslistbackendjoao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslistbackendjoao.dto.GameMinDTO;
import com.devsuperior.dslistbackendjoao.entities.Game;
import com.devsuperior.dslistbackendjoao.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	
	public List<GameMinDTO> findAll(){
		
		//List<Game> result = gameRepository.findAll();
		
		var result = gameRepository.findAll();
		
		//Converter um objeto Game em GameMinDTO com stream
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
		
	}
	
	
	/*
public List<Game> findAll(){
		
		//List<Game> result = gameRepository.findAll();
		
		var result = gameRepository.findAll();
		
		return result;
		
		
	}
*/

}

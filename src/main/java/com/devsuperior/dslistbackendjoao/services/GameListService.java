package com.devsuperior.dslistbackendjoao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistbackendjoao.dto.GameListDTO;
import com.devsuperior.dslistbackendjoao.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		//List<GameList> result = gameListRepository.findAll();
		var result = gameListRepository.findAll();
		
		//Converter um objeto GameList em GameListDTO com stream
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
		
	}
	
	
	/*
public List<Game> findAll(){
		
		//List<Game> result = gameRepository.findAll();
		
		var result = gameRepository.findAll();
		
		return result;
		
		
	}
*/

}

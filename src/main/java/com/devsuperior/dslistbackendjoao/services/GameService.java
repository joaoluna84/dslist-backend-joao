package com.devsuperior.dslistbackendjoao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistbackendjoao.dto.GameDTO;
import com.devsuperior.dslistbackendjoao.dto.GameMinDTO;
import com.devsuperior.dslistbackendjoao.projections.GameMinProjection;
import com.devsuperior.dslistbackendjoao.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		//Game result = gameRepository.findById(id).get();
		var result = gameRepository.findById(id).get();
		
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		//List<Game> result = gameRepository.findAll();
		var result = gameRepository.findAll();
		
		//Converter um objeto Game em GameMinDTO com stream
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		
		//Converter um objeto Game em GameMinDTO com stream
		List<GameMinProjection> result = gameRepository.searchByList(listId);
				
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	
	}
	
	
	/*
public List<Game> findAll(){
		
		//List<Game> result = gameRepository.findAll();
		
		var result = gameRepository.findAll();
		
		return result;
		
		
	}
*/

}

package com.generation.projetofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.projetofarmacia.model.CategoriaModel;
import com.generation.projetofarmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	
}
	

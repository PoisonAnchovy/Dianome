package com.dianome.Dianome.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dianome.Dianome.dtos.DianomeDto;
import com.dianome.Dianome.models.DianomeModel;
import com.dianome.Dianome.repositories.DianomeRepository;

import jakarta.validation.Valid;

@RestController
public class DianomeController {
	
	@Autowired
	DianomeRepository dianomeRepository;

	@GetMapping("/dianome")
	public ResponseEntity<List<DianomeModel>> listar(){
		List<DianomeModel> dianomeList = dianomeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(dianomeList);
	}
	
	@PostMapping("/dianome")
	public ResponseEntity<DianomeModel> salvar(@RequestBody @Valid DianomeDto dianomeDto){
		var dianomeModel = new DianomeModel();
		BeanUtils.copyProperties(dianomeDto, dianomeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(dianomeRepository.save(dianomeModel));
	}
	
	@GetMapping("/dianome/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<DianomeModel> dianome = dianomeRepository.findById(id);
		if(dianome.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dianome.get());
	}	
	
	@PutMapping("/dianome/{id}")
	public ResponseEntity<Object> atualizarDianome(@PathVariable(value="id") Integer id,
														@RequestBody @Valid DianomeDto dianomeDto) {
		Optional<DianomeModel> dianome = dianomeRepository.findById(id);
		if(dianome.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
		}
		var dianomeModel = dianome.get();
		BeanUtils.copyProperties(dianomeDto, dianomeModel);
		return ResponseEntity.status(HttpStatus.OK).body(dianomeRepository.save(dianomeModel));
		}

	@DeleteMapping("/dianome/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Integer id) {
			Optional<DianomeModel> dianome = dianomeRepository.findById(id);
			if(dianome.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
			}
			dianomeRepository.delete(dianome.get());
			return ResponseEntity.status(HttpStatus.OK).body("Funcionário excluído.");
	}	}	
	



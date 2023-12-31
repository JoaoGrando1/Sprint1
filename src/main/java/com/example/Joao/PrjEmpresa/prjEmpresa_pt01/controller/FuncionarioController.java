package com.example.Joao.PrjEmpresa.prjEmpresa_pt01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.entities.Funcionario;
import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.services.FuncionarioServices;



public class FuncionarioController {

	private final FuncionarioServices funcionarioService;

	@GetMapping("/home")
	public String paginaInicial( ) {
		return "index";
	}
	@Autowired
	public FuncionarioController(FuncionarioServices funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	@GetMapping("/{depnome}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long depnome) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(depnome);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}else {
			return ResponseEntity.notFound() .build();
		}
	}
	@DeleteMapping("/depnome{}")
	public void deleteLivro(@PathVariable Long depnome) {
		funcionarioService.deleteFuncionario(depnome);
	}


	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllfuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateLivro(@PathVariable Long depnome, @RequestBody Funcionario funcionario) {
	    return funcionarioService.updateFuncionario(depnome, funcionario);
	}


	}
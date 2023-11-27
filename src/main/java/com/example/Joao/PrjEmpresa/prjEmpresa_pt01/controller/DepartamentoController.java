package com.example.Joao.PrjEmpresa.prjEmpresa_pt01.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.entities.Departamento;
import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.services.DepartamentoServices;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
private final DepartamentoServices departamentoService;

@GetMapping("/home")
public String paginaInicial( ) {
	return "index";
}
@Autowired
public DepartamentoController(DepartamentoServices departamentoService) {
	this.departamentoService = departamentoService;
}
@PostMapping
public Departamento createDepartamento(@RequestBody Departamento departamento) {
	return departamentoService.saveDepartamento(departamento);
}

@GetMapping("/{depnome}")
public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depnome) {
	Departamento departamento = departamentoService.getDepartamentoById(depnome);
	if (departamento != null) {
		return ResponseEntity.ok(departamento);
	}else {
		return ResponseEntity.notFound() .build();
	}
}
@DeleteMapping("/depnome{}")
public void deleteLivro(@PathVariable Long depnome) {
	departamentoService.deleteDepartamento(depnome);
}


@GetMapping
public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
	String method = requestEntity.getMethod().name();
	String contentType = requestEntity.getHeaders().getContentType().toString();
	List<Departamento> departamento = departamentoService.getAlldepartamento();
	return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
			.body(departamento);
}

@PutMapping("/{id}")
public Departamento updateLivro(@PathVariable Long depnome, @RequestBody Departamento departamento) {
    return departamentoService.updateDepartamento(depnome, departamento);
}


}
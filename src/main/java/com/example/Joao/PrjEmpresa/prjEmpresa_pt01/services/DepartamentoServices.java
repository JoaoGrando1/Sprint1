package com.example.Joao.PrjEmpresa.prjEmpresa_pt01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.entities.Departamento;
import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.repositories.DepartamentoRepositorio;



public class DepartamentoServices {

	private final DepartamentoRepositorio DepartamentoRepositorio;
	
		@Autowired
		public DepartamentoServices(DepartamentoRepositorio departamentoRepositorio) {
			this.DepartamentoRepositorio = departamentoRepositorio;
		}
		
		public Departamento saveDepartamento(Departamento departamento) {
			return DepartamentoRepositorio.save(departamento);
		}
		
		public Departamento getDepartamentoById(Long depnome) {
			return DepartamentoFindById(depnome).orElse(null);
		}
		
		public List<Departamento> getAlldepartamento() {
			return DepartamentoRepositorio.findAll();
		}
		
		public void deleteDepartamento(Long depnome) {
			DepartamentoRepositorio.deleteById(depnome);
		}
		
		public Departamento updateDepartamento(Long depnome, Departamento novoDepartamento) {
			Optional<Departamento> departamentoOptional = DepartamentoRepositorio.findById(depnome);
			if (departamentoOptional.isPresent()) {
				Departamento departamentoExistente = departamentoOptional.get();
				departamentoExistente.setDepcodigo(novoDepartamento.getDepcodigo());
				return DepartamentoRepositorio.save(departamentoExistente);
			} else {
				return null;
			}
		}

	}
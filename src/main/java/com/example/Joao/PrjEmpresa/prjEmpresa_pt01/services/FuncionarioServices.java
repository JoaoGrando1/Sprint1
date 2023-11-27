package com.example.Joao.PrjEmpresa.prjEmpresa_pt01.services;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;

import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.entities.Funcionario;
import com.example.Joao.PrjEmpresa.prjEmpresa_pt01.repositories.FuncionarioRepositorio;

	public class FuncionarioServices {

		private final FuncionarioRepositorio funcionarioRepositorio;
		
			@Autowired
			public FuncionarioServices(FuncionarioRepositorio funcionarioRepositorio) {
				this.funcionarioRepositorio = funcionarioRepositorio;
			}
		
			public Funcionario saveFuncionario(Funcionario funcionario) {
				return funcionarioRepositorio.save(funcionario);
			}
			
			public Funcionario getFuncionarioById(Long funcodigo) {
				return funcionarioRepositorio.findById(funcodigo).orElse(null);
			}
		
			public List<Funcionario> getAllfuncionario() {
				return funcionarioRepositorio.findAll();
			}
			
			public void deleteFuncionario(Long depnome) {
				funcionarioRepositorio.deleteById(depnome);
			}
			
			public Funcionario updateFuncionario(Long depnome, Funcionario novoFuncionario) {
				Optional<Funcionario> funcionarioOptional = funcionarioRepositorio.findById(depnome);
				if (funcionarioOptional.isPresent()) {
					Funcionario funcionarioExistente = funcionarioOptional.get();
					funcionarioExistente.setFuncodigo(novoFuncionario.getFuncodigo());
					return funcionarioRepositorio.save(funcionarioExistente);
				} else {
					return null;
				}
			}

		}


package com.example.Joao.PrjEmpresa.prjEmpresa_pt01.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long funcodigo;

	private String funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	   private LocalDate funnascimento;
	
	private Double funsalario;
	public Funcionario() {
	}
	public Long getFuncodigo() {
		return funcodigo;
	}
	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}
	public String getFunnome() {
		return funnome;
	}
	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}
	public LocalDate getFunnascimento() {
		return funnascimento;
	}
	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}
	public Double getFunsalario() {
		return funsalario;
	}
	public void setFunsalario(Double funsalario) {
		this.funsalario = funsalario;
	}
	public Funcionario(Long funcodigo, String funnome, LocalDate funnascimento, Double funsalario) {
		super();
		this.funcodigo = funcodigo;
		this.funnome = funnome;
		this.funnascimento = funnascimento;
		this.funsalario = funsalario;
	}		
}
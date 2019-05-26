package com.example.money.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {

	private String descricao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVenciemntoDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVenciemntoAte;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataVenciemntoDe() {
		return dataVenciemntoDe;
	}
	public void setDataVenciemntoDe(LocalDate dataVenciemntoDe) {
		this.dataVenciemntoDe = dataVenciemntoDe;
	}
	public LocalDate getDataVenciemntoAte() {
		return dataVenciemntoAte;
	}
	public void setDataVenciemntoAte(LocalDate dataVenciemntoAte) {
		this.dataVenciemntoAte = dataVenciemntoAte;
	}
	
	
	
	
}

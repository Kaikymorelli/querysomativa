package com.Projetoquery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetoquery.entities.Aluno;

public interface AlunoRepository  extends JpaRepository <Aluno,Long> {

	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
	List<Aluno> findByRenda(double renda);
	List<Aluno> findByra(String ra);
	List<Aluno> findByCidadeAndRenda (String cidade, double renda);
}

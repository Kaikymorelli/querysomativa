package com.Projetoquery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetoquery.entities.Aluno;
import com.Projetoquery.repository.AlunoRepository;

@Service
public class AlunoService {

private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> getAllAluno() {
		return alunoRepository.findAll();
	}

	public Aluno getAlunoById(Long id) {
		Optional<Aluno> Aluno = alunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	//Query Method
	public List<Aluno> getAlunosPorCidade(String cidade){
		return alunoRepository.findByCidade(cidade);
	}
	//Query Method
	public List<Aluno> getAlunosPorNome(String nome){
	return alunoRepository.findByNome(nome);
		}
	//Query Method
		public List<Aluno> getAlunosPorRenda(double renda){
		return alunoRepository.findByRenda(renda);
	}
		//Query Method
				public List<Aluno> getAlunosPorRa(String ra){
				return alunoRepository.findByra(ra);
		}
				//Query Method
				public List<Aluno> buscarCidadeERenda(String cidade, double renda){
				return alunoRepository.findByCidadeAndRenda(cidade, renda);
		}

	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno updateAluno(Long id, Aluno updatedAluno) {
		Optional<Aluno> existingAluno = alunoRepository.findById(id);
		if (existingAluno.isPresent()) {
			updatedAluno.setId(id);
			return alunoRepository.save(updatedAluno);
		}
		return null;
	}

	public boolean deleteAluno(Long id) {
		Optional<Aluno> existingAluno = alunoRepository.findById(id);
		if (existingAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

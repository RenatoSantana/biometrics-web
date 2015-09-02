package br.gov.sspba.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;

import br.gov.sspba.domain.Funcionario;

public class FuncionarioService {

	public static Funcionario findFuncionarioByMatricula(String matricula) throws EmptyResultDataAccessException {
		
		TypedQuery<Funcionario> object = Funcionario.findFuncionariosByMatriculaEquals(matricula);	
		return object.getSingleResult();
	}
	
	
	public static  List<Funcionario> findFuncionarioByFilter (String matricula,String cpf ,String nome, String sobrenome,boolean autExpeditora)  throws EmptyResultDataAccessException {

		TypedQuery<Funcionario> list = Funcionario.findFuncionarioByFilter(matricula, cpf, nome, sobrenome,autExpeditora);	
		 return list.getResultList();
	}
	
	
}

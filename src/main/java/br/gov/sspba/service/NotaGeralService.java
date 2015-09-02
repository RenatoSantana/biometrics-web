package br.gov.sspba.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Notageral;

public class NotaGeralService {

	
	public static  List<Notageral> findNotaGeralByFilter (Funcionario idFuncionario)  throws EmptyResultDataAccessException {

		TypedQuery<Notageral> list = Notageral.findNotaGeralByFilter(idFuncionario);	
		 return list.getResultList();
	}
}

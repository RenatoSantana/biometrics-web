package br.gov.sspba.service;

import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.UserAccount;

public class UserAccountService {

	

	public static UserAccount findUserAccountsByUserNameEquals(String matricula) throws EmptyResultDataAccessException {
		
		TypedQuery<UserAccount> object = UserAccount.findUserAccountsByUserNameEquals(matricula);	
		return object.getSingleResult();
	}
	
}

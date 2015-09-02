package br.gov.sspba.service;

import javax.persistence.TypedQuery;

import br.gov.sspba.domain.Dadobiometrico;

public class DadoBiometricoService {
	
	
	public static Dadobiometrico findDadoBiometricoByMatricula(String matricula) {
		TypedQuery<Dadobiometrico> object = Dadobiometrico.findDadoBiometricoByMatricula(matricula);	
		return object.getSingleResult();
	}
}

package br.gov.sspba.bean;

import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

public interface BeanImpl {

	public void refreshList();
	
	public void save();
		
		
	public void update(ActionEvent event);
	
	public void delete(ActionEvent event);
	
	public void onCancel(RowEditEvent event);
	
	public void reset();
	
	
	 // =========================================================================
// ATTRIBUTES
// =========================================================================
	
	 // =========================================================================
  // CONSTRUCTORS
  // =========================================================================
	
	// =========================================================================
  // METHODS
  // =========================================================================
	
	 // =========================================================================
  // GETTERS & SETTERS
  // =========================================================================
	
}

package edu.school.mgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class UserRole {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;
	
	private String role;

	public int getIdRole() {
		return idRole;
	}
	
	public UserRole() {
		super();
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

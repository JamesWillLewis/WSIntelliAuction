package com.uct.cs.wsintelliauction.database.persistent.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="T_SECONDARY_USERS")
public class SecondaryUser {
	private Long id;
	
	public SecondaryUser() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

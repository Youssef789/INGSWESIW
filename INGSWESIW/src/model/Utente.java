package model;

import java.util.Date;

public class Utente {
	
	private Long id;
	private String name;
	private String username;
	private String email;
	private Date birthday;

	public Utente(String name,String username,String email) {
		this.name=name;
		this.username=username;
		this.email=email;
	}
	
	public Utente() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}

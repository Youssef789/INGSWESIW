package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Utente {
	
	
<<<<<<< HEAD
	private Long id;
=======
>>>>>>> refs/remotes/origin/master
	private String name;
	private String username;
	private String email;
<<<<<<< HEAD
	//!!!!!!!!
	private Set<Commento>commenti;
	private Set<Ricetta>ricette;
	List<Utente> followers = new LinkedList<Utente>();
	List<Utente> following = new LinkedList<Utente>();
=======
>>>>>>> refs/remotes/origin/master

	public Utente(String name,String username,String email) {
		this.name=name;
		this.username=username;
		this.email=email;
	}
	
	public Utente() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
}

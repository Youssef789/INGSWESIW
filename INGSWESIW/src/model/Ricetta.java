package model;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Ricetta {
	
	private Long id;
	private String title;
	private String category;
	private String imageName;
	private String imagePath;
	private String difficulty;
	private String preparationTime;
	private String ingredient;
	private String description;
	private String preparation;
	private Utente utente;
	
	private Set<Commento>comments;
	private Set<Voto>votes;
	
	public Ricetta() {
		
	}
	
	public Ricetta(String title,String category, String imageName,String imagePath,String difficulty,String preparationTime
			,String ingredient,String description,String preparation) {
		this.title=title;
		this.category=category;
		this.imageName=imageName;
		this.imagePath=imagePath;
		this.difficulty=difficulty;
		this.preparationTime=preparationTime;
		this.ingredient=ingredient;
		this.description=description;
		this.preparation=preparation;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Set<Commento> getComments() {
		return comments;
	}

	public void setComments(Set<Commento> comments) {
		this.comments = comments;
	}
	
	public void addComment(Commento comment) {
		if(comments == null) {
			comments=new HashSet<Commento>();
		}
		comments.add(comment);
	}
	
	public Set<Voto> getVotes() {
		return votes;
	}

	public void setVotes(Set<Voto> votes) {
		this.votes = votes;
	}
	
	public void addvote(Voto vote) {
		if(votes == null) {
			votes=new HashSet<Voto>();
		}
		votes.add(vote);
	}

	@Override
	public String toString() {
		return super.toString();
	}



}

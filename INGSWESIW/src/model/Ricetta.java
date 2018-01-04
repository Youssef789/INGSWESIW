package model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Set;

import javax.servlet.http.Part;

public class Ricetta {
	
	private Long id;
	private String title;
	private String category;
	private InputStream image;
	private String difficulty;
	private String preparationTime;
	private String ingredient;
	private String description;
	private String preparation;
	private Set<Commento>commenti;
	
	public Ricetta() {
		
	}
	
	public Ricetta(String title,String category, InputStream image,String difficulty,String preparationTime
			,String ingredient,String description,String preparation) {
		this.title=title;
		this.category=category;
		this.image=image;
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
	public  InputStream getImage() {
		return image;
	}
	public void setImage( InputStream inputStream) {
		this.image = inputStream;
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
	@Override
	public String toString() {
		return super.toString();
	}



}

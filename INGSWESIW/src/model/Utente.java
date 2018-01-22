package model;
import java.util.HashSet;
import java.util.Set;

public class Utente {
	
	

	private Long id;
	private String name;
	private String username;
	private String email;
	
	
	private Set<Commento>comments;
	private Set<Ricetta>recipes;
	private Set<Voto>votes;

	
	/////////////////
	private Set<Utente>followers;
	private Set<Utente>following;
	

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

	public Set<Ricetta> getRecipes(){
		return recipes;
	}
	public void setRecipe(Set<Ricetta>recipes) {
		this.recipes=recipes;
	}
	public void addRecipe(Ricetta recipe) {
		if(recipes == null) {
			recipes=new HashSet<Ricetta>();
		}
		recipes.add(recipe);
	}
	
	public Set<Commento> getComments(){
		return comments;
	}
	public void setComments(Set<Commento>comments) {
		this.comments=comments;
	}
	public void addComment(Commento comment) {
		if(comments == null) {
			comments=new HashSet<Commento>();
		}
		comments.add(comment);
	}
	
	
	public Set<Utente> getFollowers(){
		return followers;
	}
	public void setFollowers(Set<Utente>followers) {
		this.followers=followers;
	}
	public void addFollower(Utente follower) {
		if(followers == null) {
			followers=new HashSet<Utente>();
		}
		followers.add(follower);
	}
	
	
	public Set<Utente> getFollowing(){
		return following;
	}
	public void setFollowing(Set<Utente>following) {
		this.following=following;
	}
	public void addFollowing(Utente follow) {
		if(following == null) {
			following=new HashSet<Utente>();
		}
		following.add(follow);
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
		return "name: "+name +" "+"username: "+username+" "+"email: "+email;
	}
	
	
}

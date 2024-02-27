package db.models;

public class User {
	
	private String nom ; 
	private int gain ;
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User()
	{
		super();
	}
	
	public User(String nom, int gain) {
		super();
		this.nom = nom;
		this.gain = gain;
	}
	
	public User(String nom, int gain,String role) {
		super();
		this.nom = nom;
		this.gain = gain;
		this.role = role;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getGain() {
		return gain;
	}
	public void setGain(int gain) {
		this.gain = gain;
	} 
	
	

}

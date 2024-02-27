package db.models;

public class User {
	
	private String nom ; 
	private int gain ;
	
	
	public User()
	{
		super();
	}
	
	public User(String nom, int gain) {
		super();
		this.nom = nom;
		this.gain = gain;
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

package db.models;

public class User {
	
	private String nom ; 
	private int gain ;
	private boolean isBlackList ; 
	
	
	public User()
	{
		super();
	}
	
	public User(String nom) {
		super();
		this.nom = nom;
	}
	
	public User(String nom, int gain) {
		super();
		this.nom = nom;
		this.gain = gain;
	}
	
	public User(String nom, int gain, boolean isBlackList) {
		super();
		this.nom = nom;
		this.gain = gain;
		this.isBlackList = isBlackList;
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

	public boolean isBlackList() {
		return isBlackList;
	}

	public void setBlackList(boolean isBlackList) {
		this.isBlackList = isBlackList;
	}

	@Override
	public String toString() {
		return "{\"nom\":\"" + nom + "\", \"gain\":" + gain + ", \"isBlackList\":" + isBlackList + "}";
	} 
	
	
}

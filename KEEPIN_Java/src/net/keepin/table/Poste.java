package net.keepin.table;


public class Poste {
	private int id;
	private String libelle;
	public Poste(int pID, String pLibelle) {
		this.id = pID;
		setLibelle(pLibelle);
	}

	private int getId() {
		return this.id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String toString()
	{
		return getLibelle();
	}



}


public class Caracteristique {
	
	private String idCaracteristique;
	private char sexe;
	private char idTranche;
	private char idCategorie;
	
	public Caracteristique (String idc, char s, char idtr, char idcat) {
		this.idCaracteristique = idc;
		this.sexe = s;
		this.idTranche = idtr;
		this.idCategorie = idcat;
	}

	public String getIdCaracteristique() {
		return idCaracteristique;
	}

	public void setIdCaracteristique(String idCaracteristique) {
		this.idCaracteristique = idCaracteristique;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public char getIdTranche() {
		return idTranche;
	}

	public void setIdTranche(char idTranche) {
		this.idTranche = idTranche;
	}

	public char getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(char idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	
}

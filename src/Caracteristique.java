
public class Caracteristique {

	private String idCaracteristique;
	private String sexe;
	private String idTranche;
	private String idCategorie;

	public Caracteristique (String idc, String s, String idtr, String idcat) {
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getIdTranche() {
		return idTranche;
	}

	public void setIdTranche(String idTranche) {
		this.idTranche = idTranche;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}


}

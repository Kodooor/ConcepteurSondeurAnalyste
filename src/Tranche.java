
public class Tranche {
	private String idTranche;
	private int valeurDebut;
	private int valeurFin;

	public Tranche (String idtr, int vd, int vf) {
		this.idTranche = idtr;
		this.valeurDebut = vd;
		this.valeurFin = vf;
	}

	public String getIdTranche() {
		return idTranche;
	}

	public int getValeurDebut() {
		return valeurDebut;
	}

	public int getValeurFin() {
		return valeurFin;
	}


}

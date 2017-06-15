
public class RoleUtilisateur {
	private String identifiantRole;
	private String nomRole;

	public RoleUtilisateur (String idr, String nr) {
		this.identifiantRole = idr;
		this.nomRole = nr;
	}

	public String getIdentifiantRole() {
		return identifiantRole;
	}

	public String getNomRole() {
		return nomRole;
	}


}

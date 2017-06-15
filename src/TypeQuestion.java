
public class TypeQuestion {

	private String idTypeQuestion;
	private String intituleTypeQuestion;
	private String typeReponse;

	static String CHOIXUNIQUE = "u";
	static String CHOIXMULTIPLE = "m";
	static String CLASSEMENT = "c";
	static String NOTE = "n";
	static String REPONSELIBRE = "l";

	public TypeQuestion (String idtq, String itq, String tr) {
		this.idTypeQuestion = idtq;
		this.intituleTypeQuestion = itq;
		this.typeReponse = tr;
	}

	public String getIdTypeQuestion() {
		return idTypeQuestion;
	}

	public void setIdTypeQuestion(String idTypeQuestion) {
		this.idTypeQuestion = idTypeQuestion;
	}

	public String getIntituleTypeQuestion() {
		return intituleTypeQuestion;
	}

	public void setIntituleTypeQuestion(String intituleTypeQuestion) {
		this.intituleTypeQuestion = intituleTypeQuestion;
	}

	public String getTypeReponse() {
		return typeReponse;
	}

	public void setTypeReponse(String typeReponse) {
		this.typeReponse = typeReponse;
	}


}

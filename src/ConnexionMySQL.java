import java.sql.*;

public class ConnexionMySQL {
	ModeleAccueil BDaccueil;
	ModeleAnalyste BDanalyste;
	ModeleAccueilSondeur BDaccueilSondeur;
	ModeleConcepteur BDConcepteur;
	Connection mysql=null;
  boolean connecte=false;
	public ConnexionMySQL(String nomServeur, String nomBase, String nomLogin, String motDePasse) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver mySql non trouvé");
			mysql=null;
			return;
		}
		try{
			mysql = DriverManager.getConnection("jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin,motDePasse);
			connecte=true;
			BDaccueil = new ModeleAccueil(this);
			BDanalyste = new ModeleAnalyste(this);
			BDaccueilSondeur = new ModeleAccueilSondeur(this);
			BDConcepteur = new ModeleConcepteur(this);
		}
		catch(SQLException e){
			System.out.println("Echec de connexion!");
			System.out.println(e.getMessage());
			mysql=null;
			return;
		}
	}

}

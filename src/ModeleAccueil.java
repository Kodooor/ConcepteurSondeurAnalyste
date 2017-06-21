import java.io.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;
/**
 * Model de l'accueil
 * @author Sofiane et Lucas
 *
 */

public class ModeleAccueil {
	ConnexionMySQL laConnexion;
	Statement st;
	/**
	 * Constructeur qui va creer le modele et gerer les récuperation de donnees
	 * @param ConnexionMySQL permet l'acces a la base de donnees
	 */
	ModeleAccueil(ConnexionMySQL laConnexion){
	this.laConnexion=laConnexion;
	try{
	  st=laConnexion.mysql.createStatement();
	}
	catch(SQLException e){
	  System.out.println("Problème de création de statement");
	  System.out.println("Voici le message SQl: "+e.getMessage());
	  st=null;
	}
  }
	/**
	 * Méthode qui va recuperer le role de l'utilisateur en fonction du login et du mot de passe
	 * @param String,String le login et mot de passe de l'utilisateur
	 * @return le role de l'utilisateur
	 */
	int VerifBD(String log, String mdp){
		try{
      // execution de la requête
      ResultSet rs=st.executeQuery("SELECT idR from UTILISATEUR WHERE login = '" + log + "' and motdepasse = '" + mdp+"'");
      // chargement de la 1 er ligne de résultat
      rs.next();
			int res=rs.getInt(1);
			rs.close();
			return res;
    }
      catch(SQLException e){
        System.out.println("Echec de la requête");
        System.out.println("Voici le message SQL: "+e.getMessage());
        return -1;
      }
   }
	 /**
 	 * Méthode qui va recuperer le nom et le prenom de l'utilisateur en fonction du login et du mot de passe
 	 * @param String,String le login et mot de passe de l'utilisateur
 	 * @return la liste avec le nom et le prenom de l'utilisateur
 	 */
	 ArrayList<String> getInfoUtilisateur(String log, String mdp){
		 ArrayList<String> liste = new ArrayList<String>();
				try{
					 // execution de la requête
					 ResultSet rs=st.executeQuery("SELECT nomU from UTILISATEUR WHERE login = '" + log + "' and motdepasse = '" + mdp+"'");
					 // chargement de la 1 er ligne de résultat
					 rs.next();
					 String nom=rs.getString(1);
					 rs.close();
					 ResultSet rss=st.executeQuery("SELECT prenomU from UTILISATEUR WHERE login = '" + log + "' and motdepasse = '" + mdp+"'");
					 rss.next();
					 String prenom=rss.getString(1);
					 rss.close();
					 ResultSet id=st.executeQuery("SELECT idU from UTILISATEUR WHERE login = '" + log + "' and motdepasse = '" + mdp+"'");
					 id.next();
					 int nombre =id.getInt(1);
					 id.close();
					 ResultSet role=st.executeQuery("SELECT idR from UTILISATEUR WHERE login = '" + log + "' and motdepasse = '" + mdp+"'");
					 role.next();
					 int roleU =role.getInt(1);
					 role.close();
					 liste.add(nom);liste.add(prenom);liste.add(""+nombre);liste.add(""+roleU);
					 return liste;
				}
				catch(SQLException e){
					System.out.println("Echec de la requête");
					System.out.println("Voici le message SQL: "+e.getMessage());
					return null;
				}
		 }

}

import java.io.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;
/**
 * Model du jeu motus
 * @author IUT'O dpt Informatique
 *
 */

public class ModeleAccueil {
	ConnexionMySQL laConnexion;
	Statement st;
	
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
}

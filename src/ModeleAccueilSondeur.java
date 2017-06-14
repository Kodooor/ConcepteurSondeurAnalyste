import java.io.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;
/**
 * Model du jeu motus
 * @author IUT'O dpt Informatique
 *
 */

public class ModeleAccueilSondeur {
	ConnexionMySQL laConnexion;
	Statement st;

	ModeleAccueilSondeur(ConnexionMySQL laConnexion){
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

	Questionnaire GetQuestionnaire(){
	     try{
        // execution de la requête
        ResultSet rs=st.executeQuery("SELECT * from QUESTIONNAIRE where Etat = 'S' LIMIT 1");
        // chargement de la 1 er ligne de résultat

        rs.next();
        Questionnaire res = new Questionnaire(rs.getInt(1),rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getInt(6));
        return res;
      }
      catch(SQLException e){
        System.out.println("Echec de la requête");
        System.out.println("Voici le message SQL: "+e.getMessage());
        return null;
      }
   }
   //Fonction en cours de codage, non terminée
   /*ArrayList<Sonde> GetListeSonde(int idPan){
     ArrayList<Sonde> res = new ArrayList<Sonde>();
     try{
      // execution de la requête
      ResultSet rs=st.executeQuery("select * from SONDE natural join CONSTITUER natural join PANEL where idPan ="+idPan);
      // chargement de la 1 er ligne de résultat

      while(rs.next()){
      Sonde s = new Sonde(rs.getInt(1),rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getInt(6));
      res.add(s);
      }

    }
    catch(SQLException e){
      System.out.println("Echec de la requête");
      System.out.println("Voici le message SQL: "+e.getMessage());
      return null;
    }
  }*/

}

import java.io.*;
import java.util.ArrayList;
import java.sql.*;
/**
 * Model du jeu motus
 * @author IUT'O dpt Informatique
 *
 */

public class ModeleConcepteur {
	ConnexionMySQL laConnexion;
	Statement st;
	EasySond easySond;

	ModeleConcepteur(ConnexionMySQL laConnexion){
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
  public ArrayList<Questionnaire> listeDesQuestionnaires(){
	      ArrayList<Questionnaire> listeQuestionnaire= new ArrayList<Questionnaire>();
	  try{
	    ResultSet rs = st.executeQuery("Select * from QUESTIONNAIRE where Etat = \'C\'");
	    while(rs.next()){
	      Questionnaire q = new Questionnaire(rs.getInt(1), rs.getString(2),
	      rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getInt(6));
	      listeQuestionnaire.add(q);
	    }
	    return listeQuestionnaire;
	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return null;
	  }
		public Client getClient(int numQ){
		  try{
		    ResultSet rs = st.executeQuery("Select * from CLIENT NATURAL JOIN QUESTIONNAIRE where idQ = '" + numQ + "'");
				rs.next();
		    Client c = new Client(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7),rs.getString(8));
				rs.close();
				return c;
		  }
		  catch(SQLException e){
		    System.out.println(e);
		  }
		  return null;
		  }
}

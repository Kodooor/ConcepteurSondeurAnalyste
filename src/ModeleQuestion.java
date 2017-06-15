import java.io.*;
import java.util.ArrayList;
import java.sql.*;
/**
 * Model du jeu motus
 * @author IUT'O dpt Informatique
 *
 */

public class ModeleQuestion {
	ConnexionMySQL laConnexion;
	Statement st;
	EasySond easySond;

	ModeleQuestion(ConnexionMySQL laConnexion){
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
  public int getNumQuestionActuel(int idQ){
	  try{
	    ResultSet rs = st.executeQuery("Select IFNULL(MAX(numQ), 0) from QUESTION where idQ = '" + idQ + "'");
      rs.next();
      int num = rs.getInt(1) + 1;
      rs.close();
	    return num;

	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return -1;
	  }

}

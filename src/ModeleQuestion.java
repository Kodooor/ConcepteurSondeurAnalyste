import java.io.*;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
	    ResultSet rs = st.executeQuery("Select IFNULL(MAX(numQ), 0) from QUESTION where idQ = " + idQ);
      rs.next();
      int num = rs.getInt(1);
      rs.close();
      ++num;
      System.out.println(num);
	    return num;

	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return -1;
	  }

	public int ajouteChoixM(VueModificationsQuestionnaireConcepteur vueC) {
		  int questionactuel = vueC.numeroQuestion;
		  ArrayList<JTextField> listerep = vueC.listeJtext;
		  try{
			  String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "','"+  10 + "','"+ 'm' +"')";
		      st.executeUpdate(texte);
		      for(int i = 0; i<listerep.size();++i){
		    	  String req = "insert into VALPOSSIBLE values(" + vueC.numQ + ","+ questionactuel + ",'" + i+1 + "','"+  listerep.get(i).getText() +"')";
			      st.executeUpdate(req);
		      }
		  }
	      catch(SQLException e){
		         System.out.println("Problème insertion du joueur ");
		         System.out.println("Voici le message SQL: "+e.getMessage());
		   }
		   return 0;
	}
}


import java.io.*;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Model de l'ajout d'informations dans la base de données
 * @author Sofiane et Lucas
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
	/**
	 * Méthode qui va recuperer le numéro de la derniere question
	 * @param Int l'identifiant du questionnaire
	 * @return int le numéro de la nouvelle question 
	 */
  public int getNumQuestionActuel(int idQ){
	  try{
	    ResultSet rs = st.executeQuery("Select IFNULL(MAX(numQ), 0) from QUESTION where idQ = " + idQ);
      rs.next();
      int num = rs.getInt(1);
      rs.close();
      ++num;
	    return num;

	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return -1;
	  }
	/**
	 * Méthode qui va ajouter toutes les informations pour le type Choix Multiples
	 * @param VueModificationsQuestionnaireConcepteur la vue de l'ajout de question
	 */
	public void ajouteChoixM(VueModificationsQuestionnaireConcepteur vueC) {
		  int questionactuel = vueC.numeroQuestion;
		  ArrayList<JTextField> listerep = vueC.listeJtext;
		  try{
			  String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "',null,'"+ 'm' +"')";
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
	}
	/**
	 * Méthode qui va ajouter toutes les informations pour le type Choix Unique
	 * @param VueModificationsQuestionnaireConcepteur la vue de l'ajout de question
	 */
	public void ajouteChoixU(VueModificationsQuestionnaireConcepteur vueC) {
		int questionactuel = vueC.numeroQuestion;
		ArrayList<JTextField> listerep = vueC.listeJtext;
		try{
			String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "',null,'"+ 'u' +"')";
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
	}
	/**
	 * Méthode qui va ajouter toutes les informations pour le type Classement
	 * @param VueModificationsQuestionnaireConcepteur la vue de l'ajout de question
	 */
	public void ajouteChoixC(VueModificationsQuestionnaireConcepteur vueC) {
		int questionactuel = vueC.numeroQuestion;
		ArrayList<JTextField> listeTextNote = vueC.listeTextNote;
		try{
			String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "',null,'"+ 'c' +"')";
		    st.executeUpdate(texte);
		    for(int i = 0; i<listeTextNote.size();++i){
		    	int num = i +1;
		    	String req = "insert into VALPOSSIBLE values(" + vueC.numQ + ","+ questionactuel + "," + num + ",'"+  listeTextNote.get(i).getText() +"')";
			    st.executeUpdate(req);
		    }
		}
	    catch(SQLException e){
	    	System.out.println("Problème insertion du joueur ");
		    System.out.println("Voici le message SQL: "+e.getMessage());
		}
	}
	/**
	 * Méthode qui va ajouter toutes les informations pour le type Libre
	 * @param VueModificationsQuestionnaireConcepteur la vue de l'ajout de question
	 */
	public void ajouteChoixL(VueModificationsQuestionnaireConcepteur vueC) {
		int questionactuel = vueC.numeroQuestion;
		try{
			String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "',null,'"+ 'l' +"')";
		    st.executeUpdate(texte);
		}
	    catch(SQLException e){
	    	System.out.println("Problème insertion du joueur ");
		    System.out.println("Voici le message SQL: "+e.getMessage());
		}
	}
	/**
	 * Méthode qui va ajouter toutes les informations pour le type Note
	 * @param VueModificationsQuestionnaireConcepteur la vue de l'ajout de question
	 */
	public void ajouteChoixN(VueModificationsQuestionnaireConcepteur vueC) {
		int questionactuel = vueC.numeroQuestion;
		try{
			String texte = "insert into QUESTION values(" + vueC.numQ + ","+ questionactuel + ",'" + vueC.texteQ.getText() + "',"+ Integer.parseInt(vueC.note.getText())+",'"+ 'n' +"')";
		    st.executeUpdate(texte);
		}
	    catch(SQLException e){
	    	System.out.println("Problème insertion du joueur ");
		    System.out.println("Voici le message SQL: "+e.getMessage());
		}
	}
}


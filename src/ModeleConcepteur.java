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

public class ModeleConcepteur {
	ConnexionMySQL laConnexion;
	Statement st;
	EasySond easySond;
	/**
	 * Constructeur qui va creer le modele et gerer les récuperation de donnees
	 * @param ConnexionMySQL permet l'acces a la base de donnees
	 */
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
	/**
	 * Méthode qui va recuperer la liste des questionnaire
	 * @return la liste des questionnaire
	 */
  public ArrayList<Questionnaire> listeDesQuestionnaires(){
	      ArrayList<Questionnaire> listeQuestionnaire= new ArrayList<Questionnaire>();
	  try{
	    ResultSet rs = st.executeQuery("Select * from QUESTIONNAIRE where Etat = \'C\'");
	    while(rs.next()){
	      Questionnaire q = new Questionnaire(rs.getInt(1), rs.getString(2),
	      rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
	      listeQuestionnaire.add(q);
	    }
			rs.close();
	    return listeQuestionnaire;
	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return null;
	  }
		/**
		 * Méthode qui va recuperer le clien en fonction d'un questionnaire
		 * @param Int l'identifiant du questionnaire
		 * @return le Client
		 */
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
			public ArrayList<Question> getQuestion(int numQ){
				ArrayList<Question> liste = new ArrayList<Question>();
				try{
					ResultSet rs = st.executeQuery("Select * from QUESTION where idQ = '" + numQ + "'");
					while(rs.next()){
						Question c = new Question(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getString(5));
						liste.add(c);
					}
					rs.close();
					return liste;
				}
				catch(SQLException e){
					System.out.println(e);
				}
				return null;
				}
			public boolean vide(Questionnaire q) {
				try{
					ResultSet rs = st.executeQuery("select count(*) FROM QUESTION where idQ = '" + q.getNumeroQuestionnaire() + "'");
					rs.next();
					int res = rs.getInt(1);
					rs.close();
					if(res == 0){
						return true;
					}
				}
				catch(SQLException e){
					System.out.println(e);
				}
				return false;
			}
			public void supprimerQuestion(int idQ, int i) {
			      try{
			          st.executeUpdate("delete from VALPOSSIBLE where idQ = " + idQ+ " and numQ = "+i);
			          st.executeUpdate("delete from QUESTION where idQ = " + idQ+ " and numQ = "+i);
			        }
			        catch(SQLException e){
			          System.out.println("Voici le message SQL: "+e.getMessage());
			        }
			}




}

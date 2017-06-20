import java.io.*;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Model du Concepteur
 * @author Sofiane et Lucas
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
		 * Méthode qui va recuperer le client en fonction d'un questionnaire
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
		 /**
		 * Méthode qui va recuperer la liste des question en fonction d'un Questionnaire
	 	 * @param int le numéro du questionnaire
	 	 * @return la liste des questions
	 	 */
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
			
			 /**
			 * Méthode qui va vérifier si le Questionnaire à déjà des Questions
		 	 * @param Questionnaire le questionnaire
		 	 * @return false, true (non vide / vide)
		 	 */
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
			
			 /**
			 * Méthode qui va supprimer une question d'un Questionnaire
		 	 * @param int, int l'iD du Questionnaire, L'id de la question
		 	 */
			public void supprimerQuestion(int idQ, int i) {
			      try{
			          st.executeUpdate("delete from VALPOSSIBLE where idQ = " + idQ+ " and numQ = "+i);
			          st.executeUpdate("delete from QUESTION where idQ = " + idQ+ " and numQ = "+i);
			        }
			        catch(SQLException e){
			          System.out.println("Voici le message SQL: "+e.getMessage());
			        }
			}
			
			 /**
			 * Méthode qui va envoyer le Questionnaire aux sondeurs
		 	 * @param int l'iD questionnaire
		 	 */
			public void EnvoyerQuestionnaire(int numQ) {
			      try{
					  ResultSet rs = st.executeQuery("Select * from QUESTIONNAIRE where idQ = '" + numQ + "'");
					  rs.next();
				      Questionnaire q = new Questionnaire(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
				      rs.close();
				      q.setEtatQuestionnaire("S");
					  PreparedStatement ps = laConnexion.mysql.prepareStatement("update QUESTIONNAIRE set Titre=?, Etat=?, numC=?, idU=?, idPan=? where idQ = "+ numQ);
			          ps.setString(1, q.getTitreQuestionnaire());
			          ps.setString(2, q.getEtatQuestionnaire());
			          ps.setInt(3, q.getNumClient());
			          ps.setInt(4, q.getIdentifiantUtilisateur());
			          ps.setInt(5, q.getIdentifiantPanel());
			          ps.executeUpdate();
			        }
			        catch(SQLException e){
			          System.out.println("Voici le message SQL: "+e.getMessage());
			        }
			      }
			
			 /**
			 * Méthode qui va ajouter un Client
		 	 * @param int, String, String, String, int, String, String, String les informations du Client
		 	 */
			public void ajouterClient(int num, String raison, String ad1, String ad2, int codePost, String ville, String tele, String mail) {
			      try{
					  String texte = "insert into CLIENT values(" + num + ",'"+ raison + "','" + ad1 + "', '"+ ad2+"'," + codePost + ", '"+ville+"', '" +tele + "', '"+ mail+"')" ;
				      st.executeUpdate(texte);
			        }
			        catch(SQLException e){
			          System.out.println("Voici le message SQL: "+e.getMessage());
			        }
			     }
			 /**
			 * Méthode qui va ajouter un Questionnaire
		 	 * @param int, String, int, int, int les informations du Questionnaire
		 	 */
			public void ajouterQuestionnaire(int idQ, String Titre, int numC,int role, int idPan){
			      try{
					  String texte = "insert into QUESTIONNAIRE values(" + idQ + ",'"+ Titre + "',\'C\', "+ numC+"," + role + ", "+idPan+")" ;
				      st.executeUpdate(texte);
			        }
			        catch(SQLException e){
			          System.out.println("Voici le message SQL: "+e.getMessage());
			        }
			     }



}

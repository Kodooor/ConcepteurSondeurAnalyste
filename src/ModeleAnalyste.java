import java.io.*;
import java.util.ArrayList;
import java.sql.*;
/**
 * Model du jeu motus
 * @author IUT'O dpt Informatique
 *
 */

public class ModeleAnalyste {
	ConnexionMySQL laConnexion;
	Statement st;
	EasySond easySond;
	
	ModeleAnalyste(ConnexionMySQL laConnexion){
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
	    ResultSet rs = st.executeQuery("Select * from QUESTIONNAIRE where Etat = \'A\'");
	    while(rs.next()){
	      Questionnaire q = new Questionnaire(rs.getInt(1), rs.getString(2),
	      rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
	      listeQuestionnaire.add(q);
	    }
	    return listeQuestionnaire;
	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return null;
	  }
	
	public ArrayList<Question> listeDesQuestion(int numQ){
	      ArrayList<Question> listeQuestion= new ArrayList<Question>();
	  try{
	    ResultSet rs = st.executeQuery("Select * from QUESTION where idQ = " + numQ);
	    while(rs.next()){
	      Question questionC = new Question(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
	      listeQuestion.add(questionC);
	    }
	    return listeQuestion;
	  }
	  catch(SQLException e){
	    System.out.println(e);
	  }
	  return null;
	  }
	public Question getQuestion(int idQ,int numQ){
		Question questionC = null;
		try{
			ResultSet rs = st.executeQuery("Select * from QUESTION where idQ = " + idQ +" and numQ = "+ numQ  );
		    while(rs.next()){
		      questionC = new Question(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
		    }
			return questionC;
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return null;
	}
}

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
	    rs.close();
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
	    rs.close();
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
		    rs.close();
			return questionC;
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return null;
	}
	
	public ArrayList<Repondre> getListeReponses(Question q){
		ArrayList<Repondre> listeRes = new ArrayList<Repondre>();
		try{
			ResultSet rs = st.executeQuery("Select * from REPONDRE where idQ = " + q.getNumeroQuestionnaire() + " and numQ = "+ q.getIdQuestion());
			while(rs.next()){
				Repondre reponse = new Repondre(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
				listeRes.add(reponse);
			}
			rs.close();
			return listeRes;
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return null;
	}
	
	public ArrayList<Tranche> getTranches(){
		ArrayList<Tranche> listeRes = new ArrayList<Tranche>();
		try{
			ResultSet rs = st.executeQuery("Select * from TRANCHE");
			while(rs.next()){
				Tranche tranche = new Tranche(rs.getString(1),rs.getInt(2),rs.getInt(3));
				listeRes.add(tranche);
			}
			rs.close();
			return listeRes;
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return null;
	}
	
	public HashMap<String,String> genererColonneGauche(Question q){
		HashMap<String,String> dicoRes = new HashMap<String,String>();
		switch(q.getIdTypeQuestion()){
		case "u":try{
					ResultSet rs = st.executeQuery("Select idV,Valeur from VALPOSSIBLE where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion());
					while(rs.next()){
						int idval = rs.getInt(1);
						String val = rs.getString(2);
						dicoRes.put(val,idval+"");
					}
					rs.close();
				}
				catch(SQLException e){
					System.out.println(e);
				}
				break;
		case "m":try{
					ResultSet rs = st.executeQuery("Select idV,Valeur from VALPOSSIBLE where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion());
					while(rs.next()){
						int idval = rs.getInt(1);
						String val = rs.getString(2);
						dicoRes.put(val,idval+"");
					}
					rs.close();
					}
				catch(SQLException e){
					System.out.println(e);
				}
				break;
		/*case "c":ArrayList<String> listeTemp = new ArrayList<String>();
				try{
					ResultSet rs = st.executeQuery("Select idV,Valeur from VALPOSSIBLE where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion());
					while(rs.next()){
						String val = rs.getString(1);
						listeTemp.add(val);
						}
					rs.close();
					for(int i=1;i<q.getMaxValeur()+1;i++){
						for(String elem:listeTemp){
							listeRes.add(elem + " " + i);
						}
					}
				}
				catch(SQLException e){
					System.out.println(e);
				}
				break;*/
		case "n":for(int i=0;i<q.getMaxValeur()+1;i++){
					dicoRes.put(""+i,""+i);
				}
				break;
		case "l":ArrayList<Repondre> listeR= getListeReponses(q);
				for(Repondre elem:listeR){
					if(!dicoRes.containsKey(elem.getValeur())){
						dicoRes.put(elem.getValeur(),elem.getValeur());
					}
				}
				break;
		}
		return dicoRes;
	}

/*	public ArrayList<String> getValeursTableau(Question q){
		ArrayList<String> listeGauche = genererColonneGauche(q);
		ArrayList<Tranche> listeTranches = getTranches();
		ArrayList<String> listeValeurs = new ArrayList<String>();
		for(String elem:listeGauche){
			for(Tranche t:listeTranches){
				
			}
		}
		return listeValeurs;
	}*/
	
	public int getNbpersonnes(String valeur, int debut, int fin,Question q,HashMap<String,String> dico){
		int res=0;
		switch(q.getIdTypeQuestion()){
		 case "n":try{
					ResultSet rs = st.executeQuery("Select count(*) from TRANCHE natural join CARACTERISTIQUE natural join REPONDRE "
							+"where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion()+" and valDebut = "+debut+" and valFin = "+
							fin+" and valeur='"+valeur+"'");
					rs.next();
					res=rs.getInt(1);
					rs.close();
					}
				   catch(SQLException e){
						System.out.println(e);
					}
		 			break;
		 case "l":try{
				ResultSet rs = st.executeQuery("Select count(*) from TRANCHE natural join CARACTERISTIQUE natural join REPONDRE "
						+"where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion()+" and valDebut = "+debut+" and valFin = "+
						fin+" and valeur='"+valeur+"'");
				rs.next();
				res=rs.getInt(1);
				rs.close();
				}
			   catch(SQLException e){
					System.out.println(e);
				}
		 		break;
		 case "u":try{
				ResultSet rs = st.executeQuery("Select count(*) from TRANCHE natural join CARACTERISTIQUE natural join REPONDRE "
						+"where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion()+" and valDebut = "+debut+" and valFin = "+
						fin+" and valeur='"+dico.get(valeur)+"'");
				rs.next();
				res=rs.getInt(1);
				rs.close();
				}
			   catch(SQLException e){
					System.out.println(e);
				}
		 		break;
		 /*case "m":try{
			 	ResultSet chaineChoix= st.executeQuery("Select valeur from REPONDRE where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion() );
				ResultSet rs = st.executeQuery("Select count(*) from TRANCHE natural join CARACTERISTIQUE natural join REPONDRE"
						+"where idQ = " + q.getNumeroQuestionnaire() + " and numQ = " + q.getIdQuestion()+" and valDebut="+debut+" and valFin="+
						fin+" valeur="+dico.get(valeur));
				rs.next();
				res=rs.getInt(1);
				rs.close();
				}
			   catch(SQLException e){
					System.out.println(e);
				}
		 		break;*/
		}
		return res;
	}
}

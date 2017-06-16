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
        Questionnaire res = new Questionnaire(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
				rs.close();
        return res;
      }
      catch(SQLException e){
        System.out.println("Echec de la requête 1 ");
        System.out.println("Voici le message SQL: "+e.getMessage());
        return null;
      }
   }

	 ArrayList<Sonde> GetListeSonde(int idPan){
     ArrayList<Sonde> res = new ArrayList<Sonde>();
     try{
      // execution de la requête
      ResultSet rs=st.executeQuery("select * from SONDE natural join CONSTITUER natural join PANEL where idPan = "+idPan);
      // chargement de la 1 er ligne de résultat

      while(rs.next()){
      Sonde s = new Sonde(rs.getInt(2),rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7));
      res.add(s);
      }
			rs.close();
			return res;
    }
    catch(SQLException e){
      System.out.println("Echec de la requête 2 ");
      System.out.println("Voici le message SQL: "+e.getMessage());
      return null;
    }
  }

	ArrayList<Question> GetListeQuestion(int numQ){
		ArrayList<Question> res = new ArrayList<Question>();
		try{
		 // execution de la requête
		 ResultSet rs=st.executeQuery("select * from QUESTION where idQ = "+numQ);
		 // chargement de la 1 er ligne de résultat

		 while(rs.next()){
		 Question q = new Question(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5));
		 res.add(q);
		 }
		 rs.close();
		 return res;
	 }
	 catch(SQLException e){
		 System.out.println("Echec de la requête 3 ");
		 System.out.println("Voici le message SQL: "+e.getMessage());
		 return null;
	 }
	}

	ArrayList<ValeurPossible> GetListeValeurPossible(int numQuestionnaire, int idQuestion){
		ArrayList<ValeurPossible> res = new ArrayList<ValeurPossible>();
		try{
		 // execution de la requête
		 ResultSet rs=st.executeQuery("select * from VALPOSSIBLE where numQ = "+idQuestion+" and idQ = "+numQuestionnaire);
		 // chargement de la 1 er ligne de résultat

		 while(rs.next()){
		 ValeurPossible vp = new ValeurPossible(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4));
		 res.add(vp);
		 }
		 rs.close();
		 return res;
	 }
	 catch(SQLException e){
		 System.out.println("Echec de la requête 4 ");
		 System.out.println("Voici le message SQL: "+e.getMessage());
		 return null;
	 }
	}

	int insererRepondre(Repondre r){
		try{
			PreparedStatement ps = laConnexion.mysql.prepareStatement("insert into REPONDRE values(?,?,?,?)");
			ps.setInt(1, r.getIdQuestionnaire());
			ps.setInt(2, r.getNumQuestion());
			ps.setString(3, r.getIdCaracteristique());
			ps.setString(4, r.getValeur());
			ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("Problème insertion de la réponse ");
			System.out.println("Voici le message SQL: "+e.getMessage());
		}
		return 0;
	}

	void majQuestionnaire(int idQ){
		try{
			PreparedStatement ps = laConnexion.mysql.prepareStatement("update QUESTIONNAIRE set numLicJ = 'A' where idQ = "+idQ);
		}
		catch(SQLException e){
			System.out.println("Problème modification du joueur ");
			System.out.println("Voici le message SQL: "+e.getMessage());
		}
	}

}

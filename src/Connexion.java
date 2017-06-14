import java.util.Scanner;
import java.io.*;

public class Connexion{
  private Scanner sc=null;


  public Connexion(){
    sc = new Scanner(System.in);
  }

  public ConnexionMySQL connexion(String ip){
    /* Saisie du login et du mot de passe MySQL */
    String loginMySQL=saisieString("Votre login MySQL :");
    String mdpMySQL;
    Console cons=System.console();
    char[] mdp=cons.readPassword("%s","Votre mot de passe :");
    if (mdp!=null)
    mdpMySQL=new String(mdp);
    else
    mdpMySQL=new String();

    // ici creation d'une connexion à MySQL
    String nomServeur = ip;
    String nomBase = "dbfilleul";
    ConnexionMySQL newConnection = null;
    if(ip.equals("localhost") || ip.equals("0.0.0.0")){
      newConnection = new ConnexionMySQL(nomServeur, "sondage", "filleul", "lulujaune");
    }
    else{
      newConnection = new ConnexionMySQL("192.168.82.168", nomBase, loginMySQL, mdpMySQL);
    }

    if(newConnection.connecte){
      System.out.println("Connexion reussie");
    }
    return newConnection;
  }

  String saisieString(String prompt){
    System.out.print(prompt+' ');
    String res= sc.nextLine();
    return res;
  }
}

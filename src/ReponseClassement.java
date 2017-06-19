import java.util.*;
public class ReponseClassement implements Reponse{
  ArrayList<String> listeReponseClasse;
  String typeReponse;
  ReponseClassement(ArrayList<String> listeReponseClasse){
    this.listeReponseClasse=listeReponseClasse;
    this.typeReponse="c";
  }
  public ArrayList<String> getReponse(){
	  return this.listeReponseClasse;
  }
  public String getType(){
	  return this.typeReponse;
  }
}

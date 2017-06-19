import java.util.*;
public class ReponseClassement implements Reponse{
  ArrayList<String> listeReponseClasse;
  String typeReponse;
  ReponseClassement(ArrayList<String> listeReponseClasse){
    this.listeReponseClasse=listeReponseClasse;
    this.typeReponse="c";
  }
}

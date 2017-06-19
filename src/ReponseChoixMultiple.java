import java.util.*;
public class ReponseChoixMultiple implements Reponse{
  ArrayList<Integer> listeReponse;
  String typeReponse;
  ReponseChoixMultiple(ArrayList<Integer> listeReponse){
    this.listeReponse=listeReponse;
    this.typeReponse="m";
  }
}

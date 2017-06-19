public class ReponseLibre implements Reponse{
  String reponse;
  String typeReponse;
  ReponseLibre(String reponse){
    this.reponse=reponse;
    this.typeReponse="l";
  }
  public String getReponse(){
	  return this.reponse;
  }
  public String getType(){
	  return this.typeReponse;
  }
}

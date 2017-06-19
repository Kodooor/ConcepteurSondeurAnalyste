public class ReponseNote implements Reponse{
  int note;
  String typeReponse;
  ReponseNote(int note){
    this.note=note;
    this.typeReponse="n";
  }
  public int getReponse(){
	  return this.note;
  }
  public String getType(){
	  return this.typeReponse;
  }
}

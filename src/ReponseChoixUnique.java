public class ReponseChoixUnique implements Reponse{
  int numReponse;
  String typeReponse;
  ReponseChoixUnique(int numReponse){
    this.numReponse=numReponse;
    this.typeReponse="u";
  }
  public int getReponse(){
	  return this.numReponse;
  }
  public String getType(){
	  return this.typeReponse;
  }
}

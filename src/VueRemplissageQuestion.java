import javax.swing.*;
import java.util.*;

public class VueRemplissageQuestion extends JPanel{
	String typeQuestion;
	int NumReponse;
	ArrayList<String> listeReponseClasse;
	ArrayList<Integer> listeNumReponse;
	String note;
	ArrayList<ValeurPossible> listeValeur;
	int maxValeur;
	ArrayList<JRadioButton> buttonGroup;
	ArrayList<JCheckBox> checkBoxs;
	ArrayList<JComboBox<String>> comboList;
	JTextField text;
	JComboBox<String> combo;
	
	VueRemplissageQuestion(String typeQuestion,ArrayList<ValeurPossible> listeValeur,int maxValeur){
		this.buttonGroup= new ArrayList<JRadioButton>();
		this.listeReponseClasse= new ArrayList<String>();
		this.listeNumReponse= new ArrayList<Integer>();
		this.listeValeur= new ArrayList<ValeurPossible>();
		this.checkBoxs= new ArrayList<JCheckBox>();
		this.comboList= new ArrayList<JComboBox<String>>();
		this.typeQuestion=typeQuestion;
		this.listeValeur=listeValeur;
		this.maxValeur=maxValeur;
		
		switch(this.typeQuestion){
			//choix unique
			case "u":	ButtonGroup panelChoix=new ButtonGroup();
					for(int i=0; i < listeValeur.size() ; i++){
								JRadioButton c =new JRadioButton("" + listeValeur.get(i).getValeur());
								this.add(c);
								panelChoix.add(c);
								this.buttonGroup.add(c);
					}
						break;
			//choix multiple
			case "m":for(int i=0;i < listeValeur.size() ; i++){
							 JCheckBox  c =new JCheckBox(listeValeur.get(i).getValeur());
							 checkBoxs.add(c);
							 this.add(c);
					 }
						break;
			//classement
			case "c": 	for (int i = 1 ; i <= maxValeur ; i++){
								JLabel label = new JLabel("Numéro "+i);
								this.add(label);
								String [] liste2= new String[listeValeur.size()];
								for (int j = 0 ; j < listeValeur.size(); ++j){
									liste2[j] = listeValeur.get(j).getValeur();
								}
								JComboBox <String> maListe2=new JComboBox <String> (liste2);
								this.comboList.add(maListe2);
								this.add(maListe2);
							}

						break;
			//réponse libre
			case "l":JTextField maZone=new JTextField(100);
			this.text=maZone;
			this.add(maZone);
						break;
			//note
			case "n":String [] liste2= new String[maxValeur+1];
						 for (int i=0; i <= maxValeur ; i++){
							 liste2[i] = ""+i;
						 }
						 JComboBox <String> maListe2=new JComboBox <String> (liste2);
						 this.combo=maListe2;
						 this.add(maListe2);
						break;
	}
	}
	
 	String getType(){
		return this.typeQuestion;
	}
	

}

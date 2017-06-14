/*import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class VueAnalyste extends JFrame {
	
	VueAccueilAnalyste vueAccueilAnalyste;
	
	VueCreerAnalyse vueCreerAnalyse;

	EasySond easySond;
	
	ModeleAnalyste modeleAnalyste;
	
	
	public VueAnalyste() {
		super("Analyste");
		this.setSize(getToolkit().getScreenSize());
		// conteneur principal
		Container cont=this.getContentPane();
		//ICI RAJOUTER CE QU'IL FAUT POUR AFFICHER LE FORMULAIRE
		this.easySond = new EasySond();
		this.modeleAnalyste = new ModeleAnalyste(this.easySond.basededonnes);
		ArrayList<Questionnaire> listequestionnaire = modeleAnalyste.listeDesQuestionnaires();
		//afficherVueCreerAnalyse();
		this.setVisible(true);
	}
	
	void afficherVueAccueilAnalyste(){
		vueAccueilAnalyste=new VueAccueilAnalyste();
		Container cont = this.getContentPane();
		cont.removeAll();
		cont.add(vueAccueilAnalyste);
		cont.validate();
		cont.repaint();
	}
	
	
}
*/
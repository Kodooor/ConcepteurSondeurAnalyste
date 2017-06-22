import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ControleurAnalyseQuestion implements ActionListener{
	
	VueEtudeQuestion vueEtudeQuestion;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurAnalyseQuestion(VueEtudeQuestion vueEtudeQuestion) {
		super();
		this.vueEtudeQuestion = vueEtudeQuestion;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(((JButton)arg0.getSource()).getText().equals("Brut")){
			vueEtudeQuestion.genererTableau();
		}
		else if(((JButton)arg0.getSource()).getText().equals("Bâtons")){
			vueEtudeQuestion.genererBatons();
		}
		else if(((JButton)arg0.getSource()).getText().equals("Camembert")){
			vueEtudeQuestion.genererCamembert();
		}
		else if(((JButton)arg0.getSource()).getText().equals("Graphique")){
			vueEtudeQuestion.genererGraphique();
		}
		else if(((JButton)arg0.getSource()).getText().equals("Annuler")){
			this.vueEtudeQuestion.vca.creerFenetre();
		}
		else if(((JButton)arg0.getSource()).getText().equals("Valider")){
			this.vueEtudeQuestion.vca.setMap(this.vueEtudeQuestion.getTexte(),this.vueEtudeQuestion.question.getIdQuestion());
			this.vueEtudeQuestion.vca.creerFenetre();
		}
	}	

}

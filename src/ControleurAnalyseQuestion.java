import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Controleur de la page Analyse d'une question
 * @author Hugo, Warren et Chloé
 *
 */

public class ControleurAnalyseQuestion implements ActionListener{

	VueEtudeQuestion vueEtudeQuestion;

	/**
	 * Constructeur qui donne un acces a la vue de l'analyse d'une question d'un questionnaire
	 * @param vueEtudeQuestion de type VueEtudeQuestion est la vue de l'analyse d'une question d'un questionnaire
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
	}

}

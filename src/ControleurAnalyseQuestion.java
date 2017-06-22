import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


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
		EasySond fenetrePrincipale=(EasySond) vueEtudeQuestion.getRootPane().getParent();
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
			int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez-vous vraiment annuler votre analyse?", "Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				this.vueEtudeQuestion.vca.creerFenetre();
			}
		}
		else if(((JButton)arg0.getSource()).getText().equals("Valider")){
			int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez-vous vraiment valider votre analyse?", "Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				this.vueEtudeQuestion.vca.setMap(this.vueEtudeQuestion.getTexte(),this.vueEtudeQuestion.question.getIdQuestion());
				this.vueEtudeQuestion.vca.creerFenetre();
			}
		}
	}	

}

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurModificationsQuestionnaireConcepteur implements ActionListener{

	/**
	 * acces a la vue accueil
	 */
	private VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurModificationsQuestionnaireConcepteur(VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur) {
		super();
		this.vueModificationsQuestionnaireConcepteur = vueModificationsQuestionnaireConcepteur;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    if(((JButton) arg0.getSource()).getText().equals("Retour")){
	    	int retour = JOptionPane.showOptionDialog(vueModificationsQuestionnaireConcepteur.sond, "Voulez - vous vraiment quitter ?","Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				vueModificationsQuestionnaireConcepteur.sond.vueAccueilConcepteur.vuecreationConcepteur.afficherVueCreationQuestionnaire(vueModificationsQuestionnaireConcepteur.sond,vueModificationsQuestionnaireConcepteur.numQ);
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("OK")){
			vueModificationsQuestionnaireConcepteur.panelReponse(vueModificationsQuestionnaireConcepteur.choixvoulu,Integer.parseInt(vueModificationsQuestionnaireConcepteur.textnb.getText()));
		}
		else if(((JButton) arg0.getSource()).getText().equals("Valider")){
			int retour = JOptionPane.showOptionDialog(vueModificationsQuestionnaireConcepteur.sond, "Voulez - vous vraiment valider la question ?","Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				vueModificationsQuestionnaireConcepteur.valider();
				vueModificationsQuestionnaireConcepteur.sond.vueAccueilConcepteur.afficherVueCreationQuestionnaire(vueModificationsQuestionnaireConcepteur.sond,vueModificationsQuestionnaireConcepteur.numQ);
			}
		}
	}
}

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
			int retour = JOptionPane.showOptionDialog(this.vueModificationsQuestionnaireConcepteur.sond, "Voulez - vous vraiment quitter ?","Attention !!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
      	this.vueModificationsQuestionnaireConcepteur.sond.vueAccueilConcepteur.vuecreationConcepteur.afficherVueCreationQuestionnaire(this.vueModificationsQuestionnaireConcepteur.sond,this.vueModificationsQuestionnaireConcepteur.numQ);
    }
	}
		else{
			JOptionPane.showMessageDialog(this.vueModificationsQuestionnaireConcepteur.sond, "nique ta race petit fdp !");

	}
}
}

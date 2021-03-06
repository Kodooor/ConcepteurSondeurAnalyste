import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurCreationQuestionnaire implements ActionListener{

	/**
	 * acces a la vue de création d'un Questionnaire
	 */
	private VueCreationQuestionnaire vueCreationQuestionnaire;

	/**
	 * Constructeur qui donne un acces a la vue de l'ajout de Question
	 * vue Acceuil du Questionnaire
	 * @param vueCreationQuestionnaire la vue de création d'un Questionnaire
	 */
	public ControleurCreationQuestionnaire(VueCreationQuestionnaire vueCreationQuestionnaire) {
		super();
		this.vueCreationQuestionnaire = vueCreationQuestionnaire;
	}
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=this.vueCreationQuestionnaire.sond;
	    if(((JButton) arg0.getSource()).getText().equals("Quitter")){
	    	int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez - vous vraiment quitter ?","Attention !!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				fenetrePrincipale.afficherVueModule(fenetrePrincipale.role, fenetrePrincipale.idU,fenetrePrincipale.Nom,fenetrePrincipale.Prenom);
			}
	    }
	    else if(((JButton) arg0.getSource()).getText().equals("Ajouter Question")){
	    	this.vueCreationQuestionnaire.afficherVueModificationsQuestionnaireConcepteur(fenetrePrincipale,this.vueCreationQuestionnaire.numQ);
	    }
		else if(((JButton) arg0.getSource()).getText().equals("Publier")){
			int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez - vous vraiment publier votre Questionnaire  ?", "Publication",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				vueCreationQuestionnaire.BDConcepteur.EnvoyerQuestionnaire(vueCreationQuestionnaire.numQ);
				fenetrePrincipale.afficherVueModule(fenetrePrincipale.role, fenetrePrincipale.idU,fenetrePrincipale.Nom,fenetrePrincipale.Prenom);
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Supprimer")){
			vueCreationQuestionnaire.BDConcepteur.supprimerQuestion(vueCreationQuestionnaire.numQ,Integer.parseInt(((JButton) arg0.getSource()).getName()));
			vueCreationQuestionnaire.sond.vueAccueilConcepteur.afficherVueCreationQuestionnaire(vueCreationQuestionnaire.sond,vueCreationQuestionnaire.numQ);
		}
		else{
			JOptionPane.showMessageDialog(fenetrePrincipale, "Votre questionnaire à bien été sauvegarder !");
			vueCreationQuestionnaire.sond.afficherVueModule(fenetrePrincipale.role, fenetrePrincipale.idU, fenetrePrincipale.Nom, fenetrePrincipale.Prenom);
		}
    }
}

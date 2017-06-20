import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurComboBox implements ActionListener{

	/**
	 * acces a la vue d'ajout de question d'un Questionnaire
	 */
	private VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'ajout de Question
	 * Ou l'accueil d'un Questionnaire
	 * @param vueModificationsQuestionnaireConcepteur la vue de L'ajout de Question
	 */
	public ControleurComboBox(VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur) {
		super();
		this.vueModificationsQuestionnaireConcepteur = vueModificationsQuestionnaireConcepteur;
	}
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
   if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix simple")){
		 this.vueModificationsQuestionnaireConcepteur.choixvoulu = 1;
	 }
	 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix multiples")){
		 this.vueModificationsQuestionnaireConcepteur.choixvoulu = 0;
	}
	else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix libre")){
		this.vueModificationsQuestionnaireConcepteur.choixvoulu = 2;
		this.vueModificationsQuestionnaireConcepteur.libre();
 }
 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Classement")){
	 this.vueModificationsQuestionnaireConcepteur.choixvoulu = 3;
 }
 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Note")){
	 this.vueModificationsQuestionnaireConcepteur.choixvoulu = 4;
	 this.vueModificationsQuestionnaireConcepteur.note();
 }
   }

}

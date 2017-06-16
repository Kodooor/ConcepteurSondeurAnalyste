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
	 * acces a la vue accueil
	 */
	private VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurComboBox(VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur) {
		super();
		this.vueModificationsQuestionnaireConcepteur = vueModificationsQuestionnaireConcepteur;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
   if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix simple")){
		 this.vueModificationsQuestionnaireConcepteur.panelReponse(1,50);
	 }
	 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix multiples")){
		this.vueModificationsQuestionnaireConcepteur.panelReponse(0,10);
	}
	else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Choix libre")){
	 this.vueModificationsQuestionnaireConcepteur.panelReponse(2,20);
 }
 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Classement")){
	this.vueModificationsQuestionnaireConcepteur.panelReponse(3,5);
 }
 else if(((String)(((JComboBox) arg0.getSource()).getSelectedItem())).equals("Note")){
	this.vueModificationsQuestionnaireConcepteur.panelReponse(4,50);
 }
   }
}

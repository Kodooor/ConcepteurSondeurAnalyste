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
		 vueModificationsQuestionnaireConcepteur.panelReponse(vueModificationsQuestionnaireConcepteur.milieumilieu,"Choix simple",50);
	 }
   }
}

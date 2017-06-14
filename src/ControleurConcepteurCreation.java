import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurConcepteurCreation implements ActionListener{

	/**
	 * acces a la vue accueil
	 */
	private VueCreationConcepteur vueCreationConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurConcepteurCreation(VueCreationConcepteur vueCreationConcepteur) {
		super();
		this.vueCreationConcepteur = vueCreationConcepteur;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//vueCreationConcepteur.afficherVueCreationQuestionnaire(vueCreationConcepteur.numQ);
	}
}

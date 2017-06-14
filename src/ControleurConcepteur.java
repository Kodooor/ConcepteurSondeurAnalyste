import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurConcepteur implements ActionListener{

	/**
	 * acces a la vue accueil
	 */
	private VueAccueilConcepteur vueAccueilConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurConcepteur(VueAccueilConcepteur vueAccueilConcepteur) {
		super();
		this.vueAccueilConcepteur = vueAccueilConcepteur;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vueAccueilConcepteur.afficherVueInfoQuestionnaire(Integer.parseInt(((JButton) arg0.getSource()).getName()));
	}
}

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
		if((((JButton) arg0.getSource()).getText()).equals("Modifier")){
			vueAccueilConcepteur.afficherVueCreationQuestionnaire(vueAccueilConcepteur.sond, Integer.parseInt(((JButton) arg0.getSource()).getName()));
		}
		else if((((JButton) arg0.getSource()).getName()).equals("ajout")){
			vueAccueilConcepteur.afficherVueAjoutSociete(vueAccueilConcepteur.sond);
		}
		else if((((JButton) arg0.getSource()).getName()).equals("ajoutq")){
			vueAccueilConcepteur.afficherVueAjoutQuestionnaire(vueAccueilConcepteur.sond);
		}
		else{
			vueAccueilConcepteur.afficherVueInfoQuestionnaire(Integer.parseInt(((JButton) arg0.getSource()).getName()));			
		}
	}
}

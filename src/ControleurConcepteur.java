import java.awt.event.*;
import javax.swing.JOptionPane;

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
		EasySond fenetrePrincipale=(EasySond) vueAccueilConcepteur.getRootPane().getParent();
		JOptionPane.showMessageDialog(fenetrePrincipale, "HAHAHHAHAHAHHAHA");
	}
}

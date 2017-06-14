import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurPasser implements ActionListener{

	/**
	 * acces a la vue Chargement
	 */
	private VueChargement vueChargement;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil
	 * @param vueChargement la vue du chargement
	 */
	public ControleurPasser(VueChargement vueChargement) {
		super();
		this.vueChargement = vueChargement;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vueChargement.getRootPane().getParent();
		fenetrePrincipale.afficherVueAccueil();
	}

}

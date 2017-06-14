import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurAccueil implements ActionListener{

	/**
	 * acces a la vue accueil
	 */
	private VueAccueil vueAccueil;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurAccueil(VueAccueil vueAccueil) {
		super();
		this.vueAccueil = vueAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vueAccueil.getRootPane().getParent();
		if(!vueAccueil.textfield.estComplet()){
			JOptionPane.showMessageDialog(fenetrePrincipale, "Aucun utilisateur connus ! Veuillez essayer à nouveau !");
		}
		else{
			fenetrePrincipale.afficherVueModule(fenetrePrincipale.basededonnes.BDaccueil.VerifBD(vueAccueil.textfield.getLogin(),new String(vueAccueil.textfield.getMdp()), 0),fenetrePrincipale.basededonnes.BDaccueil.VerifBD(vueAccueil.textfield.getLogin(),new String(vueAccueil.textfield.getMdp()), 2));
		}
	}
}

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
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vueAccueil.getRootPane().getParent();
		if(!vueAccueil.textfield.estComplet()){
			JOptionPane.showMessageDialog(fenetrePrincipale, "Aucun utilisateur connus ! Veuillez essayer à nouveau !");
		}
		else{
			String login = vueAccueil.textfield.getLogin();
			String motdepasse = new String(vueAccueil.textfield.getMdp());
			fenetrePrincipale.afficherVueModule(Integer.parseInt(fenetrePrincipale.basededonnes.BDaccueil.getInfoUtilisateur(login,motdepasse).get(2)),Integer.parseInt(fenetrePrincipale.basededonnes.BDaccueil.getInfoUtilisateur(login,motdepasse).get(3)),fenetrePrincipale.basededonnes.BDaccueil.getInfoUtilisateur(login,motdepasse).get(0),fenetrePrincipale.basededonnes.BDaccueil.getInfoUtilisateur(login,motdepasse).get(1));
		}
	}
}

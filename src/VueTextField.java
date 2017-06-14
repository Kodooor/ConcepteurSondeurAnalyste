import java.awt.*;

import javax.swing.*;


/**
 * Vue permettant la saisie du nom et du prenom
 * @author Sofiane et Lucas
 * 
 */
public class VueTextField extends JPanel {
	/**
	 * champ de texte pour le login
	 */
	private JTextField login;
	/**
	 * Champ de texte pour le mot de passe
	 */
	private JPasswordField mdp;
	/**
	 * Constructeur qui créer la vue sans initialiser le login ni le mdp. Dans ce cas les champs sont actives
	 */
	public VueTextField() {
		super();
		this.init();
	}
	/**
	 * initialisation effective du JPanel
	 */
	private void init(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		PanelTextAvecEtiquette pn= new PanelTextAvecEtiquette("Login:",20);
		PanelTextMDP pp= new PanelTextMDP("Mot de passe:", 20);
		this.login = pn.getJTextField();
		this.mdp = pp.getJPasswordField();
		this.add(pn);
		this.add(pp);
		this.setBackground(new Color(78,217,255));
	}
	/**
	 * permet de recuperer le login choisi par l'utilisateur
	 * @return le login
	 */
	String getLogin(){
		return this.login.getText();
	}
	/**
	 * permet de recuperer le mot de passe choisi par l'utilisateur
	 * @return le mot de passe
	 */
	char[] getMdp(){
		return this.mdp.getPassword();
	}
	/**
	 * permet de savoir si le nom et le prenom sont bien renseignes
	 * @return true si les deux champs contiennent des valeur
	 */
	boolean estComplet(){
		if (this.getLogin().equals("") || this.getMdp().equals(""))
			return false;
		return true;
	}
	
}

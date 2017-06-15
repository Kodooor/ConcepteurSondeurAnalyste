import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleurMaison implements ActionListener{
	
	EasySond easysond;
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueEnTete la vue de l'entete
	 */
	public ControleurMaison(EasySond easysond) {
		super();
		this.easysond=easysond;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.easysond.afficherVueModule(this.easysond.role, this.easysond.Nom, this.easysond.Prenom);
	}

}

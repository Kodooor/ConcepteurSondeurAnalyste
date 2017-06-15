import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleurMaison implements ActionListener{
	
	VueEnTete vueEnTete;
	EasySond easysond;
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueEnTete la vue de l'entete
	 */
	public ControleurMaison(VueEnTete vueEnTete,EasySond easysond) {
		super();
		this.vueEnTete=vueEnTete;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.easysond.afficherVueModule(Integer.parseInt(this.vueEnTete.role), this.vueEnTete.nom, this.vueEnTete.prenom);
	}

}

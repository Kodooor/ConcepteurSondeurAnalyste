import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleurEtudeQuestion implements ActionListener{
	
	VueCreerAnalyse vueCreerAnalyste;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurEtudeQuestion(VueCreerAnalyse vueCreerAnalyste) {
		super();
		this.vueCreerAnalyste = vueCreerAnalyste;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		vueCreerAnalyste.afficherVueEtudeQuestion(((JButton)arg0.getSource()).getName());
	}

}

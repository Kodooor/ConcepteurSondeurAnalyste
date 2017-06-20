import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Controleur de la page Creer une Analyse
 * @author Hugo, Warren et Chloé
 *
 */

 public class ControleurEtudeQuestion implements ActionListener{

	VueCreerAnalyse vueCreerAnalyste;

	/**
	 * Constructeur qui donne un acces a la vue de l'etude d'une question
	 * @param vueCreerAnalyste de type VueCreerAnalyse est la vue de la création d'une analyste
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

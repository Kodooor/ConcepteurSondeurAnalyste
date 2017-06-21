import java.awt.Container;
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
		if(((JButton)arg0.getSource()).getText().equals("Annuler")){
			Container cont = this.vueCreerAnalyste.vaa.sond.getContentPane();
			cont.removeAll();
			this.vueCreerAnalyste.vaa.afficherVueCreerAnalyse(((JButton)arg0.getSource()).getName());
			cont.add(this.vueCreerAnalyste.vaa);
			cont.validate();
			cont.repaint();
		}
		if(((JButton)arg0.getSource()).getText().equals("Selectionner")){
			vueCreerAnalyste.afficherVueEtudeQuestion(((JButton)arg0.getSource()).getName());
		}
	}

}

import java.awt.Container;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleurCreerAnalyste implements ActionListener{
	
	VueAccueilAnalyste vueAccueilAnalyste;
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurCreerAnalyste(VueAccueilAnalyste vueAccueilAnalyste) {
		super();
		this.vueAccueilAnalyste = vueAccueilAnalyste;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(((JButton)arg0.getSource()).getText().equals("Créer")){
			this.vueAccueilAnalyste.afficherVueCreerAnalyse(((JButton)arg0.getSource()).getName());
		}
		if(((JButton)arg0.getSource()).getText().equals("Retour")){
			Container cont = this.vueAccueilAnalyste.sond.getContentPane();
			cont.removeAll();
			this.vueAccueilAnalyste = new VueAccueilAnalyste(this.vueAccueilAnalyste.sond);
			cont.add(this.vueAccueilAnalyste);
			cont.validate();
			cont.repaint();
		}
	}
}

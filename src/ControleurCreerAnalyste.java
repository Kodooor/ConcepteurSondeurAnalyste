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
		EasySond fenetrePrincipale=this.vueAccueilAnalyste.sond;
		// TODO Auto-generated method stub
		if(((JButton)arg0.getSource()).getText().equals("Créer")){
			this.vueAccueilAnalyste.afficherVueCreerAnalyse(((JButton)arg0.getSource()).getName());
		}
		if(((JButton)arg0.getSource()).getText().equals("Retour")){
			int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez-vous vraiment annuler votre analyse, aucune donnée ne sera sauvegardée!", "Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				Container cont = this.vueAccueilAnalyste.sond.getContentPane();
				cont.removeAll();
				this.vueAccueilAnalyste = new VueAccueilAnalyste(this.vueAccueilAnalyste.sond);
				cont.add(this.vueAccueilAnalyste);
				cont.validate();
				cont.repaint();
			}
		}
	}
}

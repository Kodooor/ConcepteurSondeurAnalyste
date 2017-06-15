import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Controleur des bouton de l'accueil
 * @author Romain
 *
 */

public class ControleurAccueilSondeur implements ActionListener{

	//model manquant

	VueAccueilSondeur vueAccueilSondeur;

	/**
	 * Constructeur qui permet de fixer la vue et le modele
	 * //param motus le modele
	 * @param vueAccueilSondeur la vue
	 */
	public ControleurAccueilSondeur(VueAccueilSondeur vueAccueilSondeur) {
		super();
		this.vueAccueilSondeur=vueAccueilSondeur;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(((JButton) arg0.getSource()).getText())
		{
			case "Accéder au questionnaire"  :this.vueAccueilSondeur.refreshRemplissage();
																				break;
			case "Passer au sondé suivant "  :this.vueAccueilSondeur.changerSonde();
																				break;
      case "    Appeler le sondé    "  :this.vueAccueilSondeur.refresh(true);
             	 													break;
      case "Appel en cours (annuler)"  :this.vueAccueilSondeur.refresh(false);
               													break;
			default    :break;
		}
	}
}

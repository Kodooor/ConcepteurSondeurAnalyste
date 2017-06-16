import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Controleur des bouton de l'accueil Sondeur
 * @author Romain
 *
 */

public class ControleurAccueilSondeur implements ActionListener{

	/**
	* vue qui contien les bouton a faire fonctionner
	*/
	VueAccueilSondeur vueAccueilSondeur;

	/**
	 * Constructeur qui permet de fixer la vue
	 * @param vueAccueilSondeur la vue Accueil Sondeur
	 */
	public ControleurAccueilSondeur(VueAccueilSondeur vueAccueilSondeur) {
		super();
		this.vueAccueilSondeur=vueAccueilSondeur;
	}

	/**
	*fait fonctionner les bouton de vueAccueilSondeur
	*/
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

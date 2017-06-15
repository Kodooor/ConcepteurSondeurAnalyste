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

public class ControleurRemplissageSondage implements ActionListener{

	//model manquant

	VueRemplissageSondage vueRemplissageSondage;

	/**
	 * Constructeur qui permet de fixer la vue et le modele
	 * @param vueRemplissageSondage la vue
	 */
	public ControleurRemplissageSondage(VueRemplissageSondage vueRemplissageSondage) {
		super();
		this.vueRemplissageSondage=vueRemplissageSondage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(((JButton) arg0.getSource()).getText())
		{
			case "Accéder au questionnaire"  :
																				break;
			case "Passer au sondé suivant "  :
																				break;
      case "    Appeler le sondé    "  :
             	 													break;
			default    :break;
		}
	}
}

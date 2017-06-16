import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Controleur des bouton du remplissage Sondage
 * @author Romain
 *
 */

public class ControleurRemplissageSondage implements ActionListener{

	/**
	* vue qui contien les bouton a faire fonctionner
	*/
	VueRemplissageSondage vueRemplissageSondage;

	/**
	 * Constructeur qui permet de fixer la vue et le modele
	 * @param vueRemplissageSondage la vue Remplissage Sondage
	 */
	public ControleurRemplissageSondage(VueRemplissageSondage vueRemplissageSondage) {
		super();
		this.vueRemplissageSondage=vueRemplissageSondage;
	}

	/**
	*fait fonctionner les bouton de vueRemplissageSondage
	*/
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(((JButton) arg0.getSource()).getText())
		{
			case "<-------"  :vueRemplissageSondage.questionChangement(-1);
													break;
			case "Racrocher"  :vueRemplissageSondage.refreshAccueil();
													break;
      case "------->"  :vueRemplissageSondage.questionChangement(1);
             	 						break;
			default    :break;
		}
	}
}

import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurDeco implements ActionListener{
	private VueEnTete vueEnTete;
	/**
	 * Constructeur qui donne un acces a la deconnection
	 * @param vueEnTete 
	 */
	public ControleurDeco(VueEnTete vueEnTete) {
		super();
		this.vueEnTete = vueEnTete;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vueEnTete.getRootPane().getParent();
		int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "You really want to quit?", "Quit?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
		if(retour==0){
			fenetrePrincipale.dispose();
		}
	}
}

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurAjout implements ActionListener{

	/**
	 * acces a la vue Chargement
	 */
	private VueAjoutSociete vue;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'accueil
	 * @param vueChargement la vue du chargement
	 */
	public ControleurAjout(VueAjoutSociete vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vue.getRootPane().getParent();
	    if(((JButton) arg0.getSource()).getText().equals("Retour")){
	    	vue.sond.afficherVueModule(vue.sond.role, vue.sond.Nom, vue.sond.Prenom);
	    }
	    else{
	    	vue.ajouter();
	    	JOptionPane.showMessageDialog(fenetrePrincipale, "Client le Client à bien été ajouté !");
	    	vue.sond.afficherVueModule(vue.sond.role, vue.sond.Nom, vue.sond.Prenom);
	    }
	}

}

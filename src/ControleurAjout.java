import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton ajout societe
 * @author Sofiane et Lucas
 *
 */
public class ControleurAjout implements ActionListener{

	/**
	 * acces a la vue Ajout Societe
	 */
	private VueAjoutSociete vue;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'ajout de societe
	 * @param vueAjoutSociete la vue de l'ajout de societe
	 */
	public ControleurAjout(VueAjoutSociete vue) {
		super();
		this.vue = vue;
	}
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
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

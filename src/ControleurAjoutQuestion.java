import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurAjoutQuestion implements ActionListener{

	/**
	 * acces a la vue Ajout Questionnaire
	 */
	private VueAjoutQuestionnaire vue;
	
	/**
	 * Constructeur qui donne un acces a la vue de l'ajout de Questionnaire
	 * @param VueAjoutQuestionnaire la vue de l'ajout de Questionnaire
	 */
	public ControleurAjoutQuestion(VueAjoutQuestionnaire vue) {
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
	    	vue.sond.afficherVueModule(vue.sond.role,vue.sond.idU, vue.sond.Nom, vue.sond.Prenom);
	    }
	    else{
	    	vue.ajouter();
	    	JOptionPane.showMessageDialog(fenetrePrincipale, "Le Questionnaire à bien été ajouté !");
	    	vue.sond.afficherVueModule(vue.sond.role,vue.sond.idU, vue.sond.Nom, vue.sond.Prenom);
	    }
	}

}

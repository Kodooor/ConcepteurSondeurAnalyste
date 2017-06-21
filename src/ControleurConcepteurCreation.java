import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurConcepteurCreation implements ActionListener{

	/**
	 * acces a la vue accueil d'un Questionnaire
	 */
	private VueCreationConcepteur vueCreationConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un Questionnaire
	 * @param vueCreationConcepteur la vue de l'accueil de Creation d'un Questionnaire
	 */
	public ControleurConcepteurCreation(VueCreationConcepteur vueCreationConcepteur) {
		super();
		this.vueCreationConcepteur = vueCreationConcepteur;
	}
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
    if(((JButton) arg0.getSource()).getText().equals("Retour")){
      Container cont=this.vueCreationConcepteur.sond.getContentPane();
			cont.removeAll();
			VueAccueilConcepteur vueAccueilConcepteur = new VueAccueilConcepteur(this.vueCreationConcepteur.sond);
			cont.add(vueAccueilConcepteur);
			cont.validate();
			cont.repaint();
    }
    else{
      vueCreationConcepteur.afficherVueCreationQuestionnaire(vueCreationConcepteur.sond, vueCreationConcepteur.numQ);
    }
	}
}

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurCreationQuestionnaire implements ActionListener{

	/**
	 * acces a la vue accueil
	 */
	private VueCreationQuestionnaire vueCreationQuestionnaire;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil d'un module en fonction du
	 * role de l'utilisateur
	 * @param VueAccueil la vue de l'accueil
	 */
	public ControleurCreationQuestionnaire(VueCreationQuestionnaire vueCreationQuestionnaire) {
		super();
		this.vueCreationQuestionnaire = vueCreationQuestionnaire;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
    if(((JButton) arg0.getSource()).getText().equals("Retour")){
      Container cont=this.vueCreationQuestionnaire.sond.getContentPane();
			cont.removeAll();
			VueCreationConcepteur vueCreationConcepteur = new VueCreationConcepteur(this.vueCreationQuestionnaire.sond, this.vueCreationQuestionnaire.numQ);
			cont.add(vueCreationConcepteur);
			cont.validate();
			cont.repaint();
    }
		else{
			Container cont=this.vueCreationQuestionnaire.sond.getContentPane();
			cont.removeAll();
			VueCreationQuestionnaire vueCreationQuestionnaire = new VueCreationQuestionnaire(this.vueCreationQuestionnaire.sond, this.vueCreationQuestionnaire.numQ);
			cont.add(vueCreationQuestionnaire);
			cont.validate();
			cont.repaint();
		}

	}
}

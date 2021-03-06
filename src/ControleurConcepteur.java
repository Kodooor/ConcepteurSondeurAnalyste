import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
/**
 * Controleur du bouton passer du chargement
 * @author Sofiane et Lucas
 *
 */
public class ControleurConcepteur implements ActionListener{

	/**
	 * acces a la vue accueil Concepteur
	 */

	private VueAccueilConcepteur vueAccueilConcepteur;

	/**
	 * Constructeur qui donne un acces a la vue de l'accueil Concepteur
	 * de l'ajout de Questionnaire ou de Client
	 * @param VueAccueilConcepteur la vue de l'accueil Concepteur
	 */
	public ControleurConcepteur(VueAccueilConcepteur vueAccueilConcepteur) {
		super();
		this.vueAccueilConcepteur = vueAccueilConcepteur;
	}
	/**
	 * method qui en fontion du bouton préssé fait une action
	 * @param arg0 le bouton préssé
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EasySond fenetrePrincipale=(EasySond) vueAccueilConcepteur.getRootPane().getParent();
		if((((JButton) arg0.getSource()).getText()).equals("Modifier")){
			vueAccueilConcepteur.afficherVueCreationQuestionnaire(vueAccueilConcepteur.sond, Integer.parseInt(((JButton) arg0.getSource()).getName()));
		}
		else if((((JButton) arg0.getSource()).getText()).equals("Supprimer")){
			int retour = JOptionPane.showOptionDialog(fenetrePrincipale, "Voulez - vous vraiment supprimer le questionnaire ?", "Attention !",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
			if(retour==0){
				vueAccueilConcepteur.sond.basededonnes.BDConcepteur.supprimerQuestionnaire(Integer.parseInt((((JButton) arg0.getSource()).getName())));
			}
			vueAccueilConcepteur.sond.afficherVueModule(vueAccueilConcepteur.sond.idU, vueAccueilConcepteur.sond.role, vueAccueilConcepteur.sond.Nom, vueAccueilConcepteur.sond.Prenom);
		}
		else if((((JButton) arg0.getSource()).getName()).equals("ajout")){
			vueAccueilConcepteur.afficherVueAjoutSociete(vueAccueilConcepteur.sond);
		}
		else if((((JButton) arg0.getSource()).getName()).equals("ajoutq")){
			vueAccueilConcepteur.afficherVueAjoutQuestionnaire(vueAccueilConcepteur.sond);
		}
		else{
			vueAccueilConcepteur.afficherVueInfoQuestionnaire(Integer.parseInt(((JButton) arg0.getSource()).getName()));			
		}
	}
}

import java.awt.*;
import javax.swing.*;
import java.nio.file.Paths;
import java.awt.Color;

public class EasySond extends JFrame {
/**
 * Classe qui cree l'application
 * @author Sofiane et Lucas
 *
 */

  /**
	* vue qui gere le chargement du module Concepteur
  */
  VueAccueilConcepteur vueAccueilConcepteur;
  /**
	* vue qui gere le chargement du module Sondeur
  */
  VueAccueilSondeur vueAccueilSondeur;
  /**
	 * vue qui gere le chargement du module Analyste
	*/
	VueAccueilAnalyste vueAccueilAnalyste;
  	//VueCreerAnalyse vueCreerAnalyse;
	/**
	 * Modele Base de données
	 */
	ConnexionMySQL basededonnes;
	/**
	 * vue qui gere le chargement de l'application
	 */
	VueChargement vueChargement;
	/**
	 * vue qui gere la page d'accueil
	 */
	VueAccueil vueAccueil;

	/**
	 * Constructeur qui va creer une vue pour le formulaire et un modele de motus ainsi que le menu
	 *
	 */
	public EasySond() {
		super("EasySond");
	    this.setSize(getToolkit().getScreenSize());
	    this.setLocationRelativeTo(null);
	    this.validate();
	    this.setVisible(true);
	    String nomServeur="192.168.82.168";
	    String nomBase="dbfilleul";
	    basededonnes = new ConnexionMySQL(nomServeur,nomBase,"filleul","lulujaune");
		// conteneur principal
		Container cont=this.getContentPane();
		//ICI RAJOUTER CE QU'IL FAUT POUR AFFICHER LA PAGE DE CHARGEMENT
		afficherVueChargement();
		//cont.add(vueChargement);
		this.setVisible(true);
	}

	/**
	 * affiche la page de chargement
	 * Dans cette methode on va creer une nouvelle vue chargement
	 */
	void afficherVueChargement(){
		Container cont=this.getContentPane();
		cont.removeAll();
		vueChargement = new VueChargement();
		cont.add(vueChargement);
		cont.setBackground(new Color(78,217,255));
		cont.validate();
		cont.repaint();
	}
	Container getCont(){
		return this.getContentPane();
	}
	/**
	 * remplace la vue chargement par la vue de l'accueil
	 */
	void afficherVueAccueil(){
		Container cont=this.getContentPane();
		cont.removeAll();
		vueAccueil = new VueAccueil();
		cont.add(vueAccueil);
		cont.setBackground(new Color(78,217,255));
		cont.validate();
		cont.repaint();
	}
	void afficherVueModule(int role){
		if(role == 1){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilConcepteur = new VueAccueilConcepteur();
			cont.add(vueAccueilConcepteur);
			cont.setBackground(new Color(78,217,255));
			cont.validate();
			cont.repaint();
		}
		else if(role == 2){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilSondeur = new VueAccueilSondeur(this);
			cont.add(vueAccueilSondeur);
			cont.setBackground(new Color(78,217,255));
			cont.validate();
			cont.repaint();
		}
		else if(role == 3){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilAnalyste = new VueAccueilAnalyste(this);
			cont.add(vueAccueilAnalyste);
			//vueCreerAnalyse = new VueCreerAnalyse();
			//cont.add(vueCreerAnalyse);
			cont.setBackground(new Color(78,217,255));
			cont.validate();
			cont.repaint();			
		}
	}

	public static void main(String[] args){
		EasySond aff=new EasySond();

	}
}

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
	 * Nom de l'utilisateur
	 */
	String Nom;
  /**
   * Prenom de l'utilisateur
   */
  String Prenom;
  /**
   * Role de l'utilisateur
   */
  int role;
  int idU;

  /**
   * COULEUR DE L APPLI
   */
  Color couleur;
	/**
	 * Constructeur qui va creer une vue pour le chargement et les modeles dont on a besoin
	 *
	 */
	public EasySond() {
		super("EasySond");
	  this.setSize(getToolkit().getScreenSize());
	  this.setLocationRelativeTo(null);
	  this.validate();
	  this.setVisible(true);
    this.couleur = new Color(78,217,255);
	  String nomServeur="192.168.82.168";
	  String nomBase="dbfilleul";
	  basededonnes = new ConnexionMySQL(nomServeur,nomBase,"filleul","lulujaune");
		Container cont=this.getContentPane();
		afficherVueChargement();
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
		cont.validate();
		cont.repaint();
	}
	/**
	 * remplace la vue chargement par la vue de l'accueil
	 */
	void afficherVueAccueil(){
		Container cont=this.getContentPane();
		cont.removeAll();
		vueAccueil = new VueAccueil();
		cont.add(vueAccueil);
		cont.validate();
		cont.repaint();
	}
  /**
  * Remplace les vue par les vue d'accueil pour chaque module
  * @param Int,String,String le role, le nom et le prenom de l'utilisateur
  */
	void afficherVueModule(int utilisateur,int role, String nom, String prenom){
    this.Nom = nom;
    this.Prenom = prenom;
    this.role = role;
    this.idU = utilisateur;
    System.out.println(this.Nom);
    System.out.println(this.Prenom);
    System.out.println(this.role);
    System.out.println(this.idU);

		if(role == 1){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilConcepteur = new VueAccueilConcepteur(this);
			cont.add(vueAccueilConcepteur);
			cont.validate();
			cont.repaint();
		}
		else if(role == 2){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilSondeur = new VueAccueilSondeur(this);
			cont.add(vueAccueilSondeur);
			cont.validate();
			cont.repaint();
		}
		else if(role == 3){
			Container cont=this.getContentPane();
			cont.removeAll();
			vueAccueilAnalyste = new VueAccueilAnalyste(this);
			cont.add(vueAccueilAnalyste);
			cont.validate();
			cont.repaint();
		}
	}

	public static void main(String[] args){
		EasySond aff=new EasySond();

	}
}

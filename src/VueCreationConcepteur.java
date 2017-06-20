import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

/**
 * Vue permettant l'affichage des informations du Questionnaire
 * @author Sofiane et Lucas
 *
 */

public class VueCreationConcepteur extends JPanel {
	JButton bout;
	JButton boutt;
	EasySond sond;
	int numQ;
	JPanel bidon4;
	JPanel milieumilieu;
	Client c;
	ControleurConcepteurCreation cc;
  VueCreationQuestionnaire vueCreationQuestionnaire;
	/**
	 * Constructeur des informations d'un Questionnaire
	 */
	public VueCreationConcepteur(EasySond sond,int numQ) {
		super();
		this.sond=sond;
		this.numQ=numQ;
		this.cc = new ControleurConcepteurCreation(this);
		this.c = this.sond.basededonnes.BDConcepteur.getClient(this.numQ);
		this.setLayout(new BorderLayout());
		this.add(hautt(),"North");
		this.add(milieu(),"Center");
	}
	/**
	 * Méthode qui change la vue actuel par celle de l'acceuil du Questionnaire
	 * @param EasySond, int l'application et le numéro du Questionnaire
	 */
	void afficherVueCreationQuestionnaire(EasySond sond, int num){
		Container cont=this.sond.getContentPane();
		cont.removeAll();
		this.vueCreationQuestionnaire = new VueCreationQuestionnaire(this.sond,num);
		cont.add(vueCreationQuestionnaire);
		cont.validate();
		cont.repaint();
	}
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
	Component hautt(){
		VueEnTete haut=new VueEnTete(this.sond,"Société ","Concepteur",this.sond.Nom,this.sond.Prenom);
		return haut;
}
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
	Component milieu(){
		JPanel milieu = new JPanel(new BorderLayout());
		milieu.setBackground(this.sond.couleur);
		this.add(milieu,"Center");
		JPanel milieumilieu = new JPanel();
		milieumilieu.setLayout(new BoxLayout(milieumilieu,BoxLayout.Y_AXIS));
		milieumilieu.setBackground(Color.WHITE);
		informations(milieumilieu);
		milieu.add(milieumilieu,"Center");

		JPanel bidon1 = new JPanel();
		bidon1.setBackground(this.sond.couleur);
		bidon1.setPreferredSize(new Dimension(40,40));
		milieu.add(bidon1,"North");

		JPanel bidon2 = new JPanel();
		bidon2.setBackground(this.sond.couleur);
		bidon2.setPreferredSize(new Dimension(100,100));
		milieu.add(bidon2,"West");

		JPanel bidon3 = new JPanel();
		bidon3.setBackground(this.sond.couleur);
		bidon3.setPreferredSize(new Dimension(100,100));
		milieu.add(bidon3,"East");

		JPanel bidon4 = new JPanel();
		bidon4.setBackground(this.sond.couleur);
		bidon4.setPreferredSize(new Dimension(70,70));
		bouton(bidon4);
		milieu.add(bidon4,"South");
		return milieu;
}
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
private void bouton(JPanel bidon4){
		JPanel bouton = new JPanel(new FlowLayout());
		JButton bout1 = new JButton("Retour");
		JButton bout2= new JButton("Creer Questionnaire");
		bouton.add(bout1);
		bout1.addActionListener(this.cc);
		bout2.addActionListener(this.cc);
		bouton.add(bout2);
		bidon4.add(bouton);
}
/**
 * Méthodes qui vont ajouter la vue 
 */
private void informations(JPanel milieumilieu){
	milieumilieu.setBorder(new TitledBorder("Informations : "));


		JPanel nomSociete = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text2 = new JLabel("Nom Societe : ");
		JLabel nom = new JLabel(c.getRaisonSociale());
    nomSociete.add(text2);
		nomSociete.add(nom);
		milieumilieu.add(nomSociete);
		
		JPanel idClient = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text23 = new JLabel("ID Societe : ");
		JLabel id = new JLabel(""+c.getNumeroClient());
		idClient.add(text23);
		idClient.add(id);
		milieumilieu.add(idClient);
		
		JPanel numTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text13 = new JLabel("Numéro de Téléphone : ");
		JLabel numtel = new JLabel(c.getNumeroTelephone());
		numTel.add(text13);
		numTel.add(numtel);
		milieumilieu.add(numTel);
		
		JPanel nomDirecteur = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text3 = new JLabel("Addresse Mail : ");
		JLabel nomDir = new JLabel(c.getEmail());
    nomDirecteur.add(text3);
		nomDirecteur.add(nomDir);
		milieumilieu.add(nomDirecteur);

		JPanel texteDemande = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text54 = new JLabel("Addresse : ");
		JLabel text4 = new JLabel(c.getAdresse1() + " - " + c.getVille() + " - " + c.getCodePostal());
		texteDemande.add(text54);
		texteDemande.add(text4);
		milieumilieu.add(texteDemande);
}
	}

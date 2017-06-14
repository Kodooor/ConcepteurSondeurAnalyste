import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;



public class VueCreationConcepteur extends JPanel {
	JButton bout;
	JButton boutt;
	EasySond sond;
	int numQ;
	JPanel bidon4;
	JPanel milieumilieu;
	ControleurConcepteurCreation cc;
	//VuecreationQuestionnaire vuecreationQuestionnaire;
	ModeleConcepteur mc;
	Client client;

	public VueCreationConcepteur(EasySond sond,int numQ) {
		super();
		this.sond=sond;
		this.numQ=numQ;
		this.client = this.sond.basededonnes.BDConcepteur.Societe(this.numQ);
		this.cc = new ControleurConcepteurCreation(this);
		this.setLayout(new BorderLayout());
		this.add(hautt(), "North");
		this.add(milieu(), "Center");
	}
	/*void afficherVueCreationQuestionnaire(int num){
		Container cont=this.sond.getContentPane();
		cont.removeAll();
		this.vuecreationQuestionnaire = new VuecreationQuestionnaire(this.sond,num);
		cont.add(vuecreationConcepteur);
		cont.validate();
		cont.repaint();
	}*/
	Component hautt(){
		VueEnTete haut=new VueEnTete(this.sond,"Accueil Concepteur > Société ","Concepteur",this.sond.Nom,this.sond.Prenom);
		return haut;
}
	Component milieu(){
		JPanel milieu = new JPanel(new BorderLayout());
		milieu.setBackground(Color.RED);
		this.add(milieu,"Center");
		JPanel milieumilieu = new JPanel();
		milieumilieu.setLayout(new BoxLayout(milieumilieu,BoxLayout.Y_AXIS));
		milieumilieu.setBackground(Color.WHITE);
		informations(milieumilieu);
		milieu.add(milieumilieu,"Center");

		JPanel bidon1 = new JPanel();
		bidon1.setBackground(new Color(78,217,255));
		bidon1.setPreferredSize(new Dimension(40,40));
		milieu.add(bidon1,"North");

		JPanel bidon2 = new JPanel();
		bidon2.setBackground(new Color(78,217,255));
		bidon2.setPreferredSize(new Dimension(100,100));
		milieu.add(bidon2,"West");

		JPanel bidon3 = new JPanel();
		bidon3.setBackground(new Color(78,217,255));
		bidon3.setPreferredSize(new Dimension(100,100));
		milieu.add(bidon3,"East");

		JPanel bidon4 = new JPanel();
		bidon4.setBackground(new Color(78,217,255));
		bidon4.setPreferredSize(new Dimension(70,70));
		bouton(bidon4);
		milieu.add(bidon4,"South");
		return milieu;
}
 void bouton(JPanel bidon4){
		JPanel bouton = new JPanel(new FlowLayout());
		JButton bout1 = new JButton("Retour");
		bout1.addActionListener(this.cc);
		JButton bout2= new JButton("Creer Questionnaire");
		bouton.add(bout1);
		bouton.add(bout2);
		bidon4.add(bouton);
}
 void informations(JPanel milieumilieu){
		JPanel informations = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text1 = new JLabel("Informations : ");
		informations.add(text1);
		milieumilieu.add(informations);

		JPanel nomSociete = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text2 = new JLabel("Nom Societe : ");
		JLabel nom = new JLabel(client.getRaisonSociale());
    nomSociete.add(text2);
		nomSociete.add(nom);
		milieumilieu.add(nomSociete);

		JPanel nomDirecteur = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text3 = new JLabel("Addresse : ");
		JLabel nomDir = new JLabel(client.getVille());
    nomDirecteur.add(text3);
		nomDirecteur.add(nomDir);
		milieumilieu.add(nomDirecteur);

		JPanel texteDemande = new JPanel(new FlowLayout(FlowLayout.LEFT));
		texteDemande.setBorder(new TitledBorder("Email société"));
		JLabel text4 = new JLabel(client.getEmail());
		texteDemande.add(text4);
		milieumilieu.add(texteDemande);
}
	}

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



public class VueCreationConcepteur extends JFrame {
	JButton bout;
	JButton boutt;



	public VueCreationConcepteur() {
		super("vue");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = new Container();
		cont.setLayout(new BorderLayout());
		VueEnTete haut=new VueEnTete("Accueil Concepteur > Société n°? ","Concepteur");
		cont.add(haut,"Center");

		JLabel logo = new JLabel(new ImageIcon("LogoPetit.png"));
		haut.add(logo,"North");
		cont.add(haut,"North");

		JPanel milieu = new JPanel(new BorderLayout());
		milieu.setBackground(Color.RED);
		cont.add(milieu,"Center");

		JPanel milieumilieu = new JPanel();
		milieumilieu.setLayout(new BoxLayout(milieumilieu,BoxLayout.Y_AXIS));
		milieumilieu.setBackground(Color.WHITE);
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
		milieu.add(bidon4,"South");

		JPanel bouton = new JPanel(new FlowLayout());
		JButton bout1 = new JButton("Retour");
		JButton bout2= new JButton("Creer Questionnaire");
		bouton.add(bout1);
		bouton.add(bout2);
		bidon4.add(bouton);

		JPanel informations = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text1 = new JLabel("Informations : ");
		informations.add(text1);
		milieumilieu.add(informations);

		JPanel nomSociete = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text2 = new JLabel("Nom Societe : ");
		JLabel nom = new JLabel("il faut mettre le nom de la société");
    nomSociete.add(text2);
		nomSociete.add(nom);
		milieumilieu.add(nomSociete);

		JPanel nomDirecteur = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel text3 = new JLabel("Nom Directeur : ");
		JLabel nomDir = new JLabel("il faut mettre le nom du directeur");
    nomDirecteur.add(text3);
		nomDirecteur.add(nomDir);
		milieumilieu.add(nomDirecteur);

		JPanel texteDemande = new JPanel(new FlowLayout(FlowLayout.LEFT));
		texteDemande.setBorder(new TitledBorder("Description de la demande : "));
		JLabel text4 = new JLabel("La description de la demande");
		texteDemande.add(text4);
		milieumilieu.add(texteDemande);
		this.add(cont);
		this.setVisible(true);

	}
}

// JLabel text3 = new JLabel("Nom Directeur :");
// informations.add(text2,"Center");
// informations.add(text3,"South");

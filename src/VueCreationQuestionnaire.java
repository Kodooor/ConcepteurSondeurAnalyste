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

public class VueCreationQuestionnaire extends JPanel{
  JButton bout;
	JButton boutt;
	EasySond sond;
	int numQ;
	JPanel bidon4;
	JPanel milieumilieu;
	Client c;
	ControleurConcepteurCreation cc;


  public VueCreationQuestionnaire(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.cc = new ControleurConcepteurCreation(this);
    this.c = this.sond.basededonnes.BDConcepteur.getClient(this.numQ);
    this.setLayout(new BorderLayout());
		this.add(hautt(),"North");
}

  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Accueil Concepteur > Société n°? > Création questionnaire","Concepteur",this.sond.Nom,this.sond.Prenom);
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
  private void bouton(JPanel bidon4){
    JPanel bouton = new JPanel(new FlowLayout());
    JButton bout1 = new JButton("Retour");
    JButton bout2= new JButton("Valider");
    bouton.add(bout1);
    bout1.addActionListenerValider(this.cc);
    bout2.addActionListener(this.cc);
    bouton.add(bout2);
    bidon4.add(bouton);
  }
  private void informations(JPanel milieumilieu){
    JPanel titre = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel text1 = new JLabel("Titre : ");
    titre.add(text1);
    milieumilieu.add(titre);

    JPanel nomClients = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel text2 = new JLabel("Nom Clients : ");
    JLabel société = new JLabel("Société 2");
    nomClients.add(text2);
    nomClients.add(société);
    milieumilieu.add(nomClients);

    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel text3 = new JLabel("Panel : ");
    String [] lesPanels={"panel1","panel2","panel3"};
    JComboBox <String> maListePanel=new JComboBox <String> (lesPanels);
    panel.add(text3);
    panel.add(maListePanel);
    milieumilieu.add(panel);

    JPanel description = new JPanel(new FlowLayout(FlowLayout.LEFT));
    description.setBorder(new TitledBorder("Description : "));
    JLabel text4 = new JLabel(c.getVille() + c.getAdresse1());
    description.add(text4);
    milieumilieu.add(description);
  }
  }

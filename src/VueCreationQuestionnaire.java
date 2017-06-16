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
	ControleurCreationQuestionnaire cc;
  VueModificationsQuestionnaireConcepteur vueModificationsQuestionnaireConcepteur;


  public VueCreationQuestionnaire(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.cc = new ControleurCreationQuestionnaire(this);
    this.c = this.sond.basededonnes.BDConcepteur.getClient(this.numQ);
    this.setLayout(new BorderLayout());
		this.add(hautt(),"North");
    this.add(milieu(),"Center");
}
  void afficherVueModificationsQuestionnaireConcepteur(EasySond sond, int num){
    Container cont=this.sond.getContentPane();
    cont.removeAll();
    this.vueModificationsQuestionnaireConcepteur = new VueModificationsQuestionnaireConcepteur(this.sond,num);
    cont.add(vueModificationsQuestionnaireConcepteur);
    cont.validate();
    cont.repaint();
  }
  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Accueil Concepteur > Société n°? > Création questionnaire","Concepteur",this.sond.Nom,this.sond.Prenom);
    return haut;
}

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
  private void bouton(JPanel bidon4){
    JPanel bouton = new JPanel(new FlowLayout());
    JButton bout1 = new JButton("Quitter");
    JButton bout2= new JButton("Publier");
    JButton bout3 = new JButton("Ajouter Question");
    JButton bout4 = new JButton("Sauvegarder");
    bouton.add(bout1);
    bouton.add(bout3);
    bout1.addActionListener(this.cc);
    bout2.addActionListener(this.cc);
    bout3.addActionListener(this.cc);
    bout4.addActionListener(this.cc);
    bouton.add(bout4);
    bouton.add(bout2);
    bidon4.add(bouton);
  }
  private void informations(JPanel milieumilieu){
    JPanel LesQ = new JPanel(new FlowLayout(FlowLayout.LEFT));
    LesQ.setBorder(new TitledBorder("Liste des Questions : "));
    JLabel text4 = new JLabel(c.getVille() + c.getAdresse1());
    LesQ.add(text4);
    milieumilieu.add(LesQ);
  }
  }

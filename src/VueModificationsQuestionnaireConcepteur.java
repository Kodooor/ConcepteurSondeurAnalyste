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

public class VueModificationsQuestionnaireConcepteur extends JPanel{
  JButton bout;
	JButton boutt;
	EasySond sond;
	int numQ;
	JPanel bidon4;
	JPanel milieumilieu;
	ControleurModificationsQuestionnaireConcepteur cc;
  int numeroQuestion;


  public VueModificationsQuestionnaireConcepteur(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.cc = new ControleurModificationsQuestionnaireConcepteur(this);
    this.setLayout(new BorderLayout());
    this.numeroQuestion=this.sond.basededonnes.BDQuestion.getNumQuestionActuel(this.numQ);
		this.add(hautt(),"North");
    this.add(milieu(),"Center");
}

  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Accueil Concepteur > Société n°? > Modification questionnaire","Concepteur",this.sond.Nom,this.sond.Prenom);
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
    JButton bout1 = new JButton("Retour");
    JButton bout2= new JButton("Valider");
    bouton.add(bout1);
    bout1.addActionListener(this.cc);
    bout2.addActionListener(this.cc);
    bouton.add(bout2);
    bidon4.add(bouton);
  }
  private void informations(JPanel milieumilieu){
    JPanel enonce = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JTextArea texte = new JTextArea(8,96);
    texte.setLineWrap(true);
    texte.setWrapStyleWord(true);
    enonce.setBorder(new TitledBorder("Énoncé : "));
    enonce.add(texte);
		milieumilieu.add(enonce);

		JPanel type = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel typee = new JLabel("Type :");
    String [] lesChoix={"Choix multiples","Choix simple","Choix libre","Classement"};
    JComboBox <String> maListeChoix=new JComboBox <String> (lesChoix);
    type.add(typee);
    type.add(maListeChoix);
    milieumilieu.add(type);

		JPanel reponse = new JPanel(new FlowLayout(FlowLayout.LEFT));
    reponse.setBorder(new TitledBorder("Réponses :"));
    JRadioButton  choix1=new JRadioButton("Choix 1   ");
    JRadioButton  choix2=new JRadioButton("Choix 2   ");
    JRadioButton  choix3=new JRadioButton("Choix 3   ");
    JRadioButton  choix4=new JRadioButton("Choix 4   ");
    JRadioButton  choix5=new JRadioButton("Choix 5   ");
    ButtonGroup  choixOption=new ButtonGroup ();
    choixOption.add(choix1);
    choixOption.add(choix2);
    choixOption.add(choix3);
    choixOption.add(choix4);
    choixOption.add(choix5);
    reponse.add(choix1);
    reponse.add(choix2);
    reponse.add(choix3);
    reponse.add(choix4);
    reponse.add(choix5);
    milieumilieu.add(reponse);
  }
  }

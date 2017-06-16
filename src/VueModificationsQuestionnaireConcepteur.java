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
  ControleurComboBox ccb;


  public VueModificationsQuestionnaireConcepteur(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.ccb= new ControleurComboBox(this);
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
    this.milieumilieu = new JPanel();
    this.milieumilieu.setLayout(new BoxLayout(milieumilieu,BoxLayout.Y_AXIS));
    this.milieumilieu.setBackground(Color.WHITE);
    informations(this.milieumilieu);
    milieu.add(this.milieumilieu,"Center");

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
    String [] lesChoix={"Choix multiples","Choix simple","Choix libre","Classement","Note"};
    JComboBox <String> maListeChoix=new JComboBox <String> (lesChoix);
    maListeChoix.addActionListener(this.ccb);
    type.add(typee);
    type.add(maListeChoix);
    milieumilieu.add(type);
    panelReponse(milieumilieu, "Choix multiples", 8);
  }
  void panelReponse(JPanel milieumilieu, String nom, int nbChoix){
    JPanel reponse = new JPanel(new FlowLayout(FlowLayout.LEFT));
    reponse.setBorder(new TitledBorder("Réponses :"));
    Container cont = ((Container) milieumilieu);
    if(nom.equals("Choix multiples")){
  		cont.removeAll();
      ButtonGroup  choixOption=new ButtonGroup ();
      for(int i =0; i <nbChoix; ++i){
        JRadioButton  choix=new JRadioButton("Choix " + i);
        choixOption.add(choix);
        reponse.add(choix);
      }
      cont.add(reponse);
      cont.setBackground(this.sond.couleur);
      cont.validate();
      cont.repaint();
    }
    else if(nom.equals("Choix simple")){
      cont.removeAll();
      ButtonGroup  choixOption=new ButtonGroup ();
      for(int i =0; i <nbChoix; ++i){
        JRadioButton  choix=new JRadioButton("Choix " + i);
        choixOption.add(choix);
        reponse.add(choix);
      }
      cont.add(reponse);
      cont.setBackground(this.sond.couleur);
      cont.validate();
      cont.repaint();
    }
    else if(nom.equals("Choix libre")){
      cont.removeAll();
      JTextArea texte = new JTextArea(8,96);
      texte.setLineWrap(true);
      texte.setWrapStyleWord(true);
      reponse.add(texte);
      cont.add(reponse);
      cont.setBackground(this.sond.couleur);
      cont.validate();
      cont.repaint();    }
    else if(nom.equals("Classement")){
      cont.removeAll();
      for(int i=0; i<nbChoix; ++i){
        JLabel choix1 = new JLabel("Choix" + i);
        JTextField texte1 = new JTextField(20);
        reponse.add(choix1);
        reponse.add(texte1);
      }
      cont.add(reponse);
      cont.setBackground(this.sond.couleur);
      cont.validate();
      cont.repaint();    }
    else{
      cont.removeAll();
      JTextField note = new JTextField(5);
      reponse.add(note);
      cont.add(reponse);
      cont.setBackground(this.sond.couleur);
      cont.validate();
      cont.repaint();
    }
}
}

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
  JPanel cont;
  int choixvoulu;
  JTextField textnb;
  ModeleConcepteur BDConcepteur;
  ArrayList<JRadioButton> listeBouton;
  ArrayList<JTextField> listeJtext;
  ArrayList<JTextField> listeTextNote;
  JTextField note;
  JTextArea texte;
  JTextArea texteQ;


  public VueModificationsQuestionnaireConcepteur(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.ccb= new ControleurComboBox(this);
    this.cc = new ControleurModificationsQuestionnaireConcepteur(this);
    this.setLayout(new BorderLayout());
    this.numeroQuestion=this.sond.basededonnes.BDQuestion.getNumQuestionActuel(this.numQ);
    this.BDConcepteur = this.sond.basededonnes.BDConcepteur;
    this.cont = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.add(hautt(),"North");
    this.add(milieu(),"Center");
    this.choixvoulu = 0;

}

  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Question","Concepteur",this.sond.Nom,this.sond.Prenom);
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
    this.texteQ = new JTextArea(8,96);
    this.texteQ.setLineWrap(true);
    this.texteQ.setWrapStyleWord(true);
    enonce.setBorder(new TitledBorder("Énoncé : "));
    enonce.add(this.texteQ);
		milieumilieu.add(enonce);

		JPanel type = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel typee = new JLabel("Type :");
    String [] lesChoix={"Choix multiples","Choix simple","Choix libre","Classement","Note"};
    JComboBox <String> maListeChoix=new JComboBox <String> (lesChoix);
    maListeChoix.addActionListener(this.ccb);
    type.add(typee);
    type.add(maListeChoix);
    milieumilieu.add(type);
    JPanel nombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel bla = new JLabel("Nombre de réponses :");
    nombre.add(bla);
    this.textnb = new JTextField(20);
    nombre.add(this.textnb);
    JButton validation = new JButton("OK");
    validation.addActionListener(this.cc);
    nombre.add(validation);
    milieumilieu.add(nombre);
    milieumilieu.add(cont);
    panelReponse(this.choixvoulu, 8);
  }
  void libre(){
    cont.removeAll();
    this.texte = new JTextArea(8,96);
    this.texte.setBackground(Color.white);
    this.texte.setLineWrap(true);
    this.texte.setWrapStyleWord(true);
    cont.add(this.texte);
    cont.setBorder(new TitledBorder("Réponses :"));
    cont.validate();
    cont.repaint();
  }
  void note(){
    cont.removeAll();
    this.note = new JTextField(5);
    cont.add(this.note);
    cont.setBorder(new TitledBorder("Réponses :"));
    cont.validate();
    cont.repaint();
  }
  void valider(){
    if(this.choixvoulu == 0){
      this.sond.basededonnes.BDQuestion.ajouteChoixM(this);
    }
    /*else if(this.choixvoulu == 1){
    	this.sond.basededonnes.BDQuestion.ajouteChoixU(this);
    }
    else if(this.choixvoulu == 3){
    	this.sond.basededonnes.BDQuestion.ajouteChoixU(this);
    }
    else if(this.choixvoulu == 2){
    	this.sond.basededonnes.BDQuestion.ajouteChoixL(this);
    }
    else{
    	this.sond.basededonnes.BDQuestion.ajouteChoixL(this);
    }*/
  }

  void panelReponse(int nom, int nbChoix){

    cont.removeAll();
    if(nom == 0){
      listeBouton = new ArrayList<JRadioButton>();
      listeJtext = new ArrayList<JTextField>();
      for(int i =0; i <nbChoix; ++i){
        JRadioButton  choix=new JRadioButton();
        listeBouton.add(choix);
        JTextField text = new JTextField("Rentrez votre réponse");
        listeJtext.add(text);
        cont.add(choix);cont.add(text);
      }
    }
    else if(nom == 1){
      listeBouton = new ArrayList<JRadioButton>();
      listeJtext = new ArrayList<JTextField>();
      ButtonGroup  choixOption=new ButtonGroup ();
      for(int i =0; i <nbChoix; ++i){
        JRadioButton  choix=new JRadioButton();
        listeBouton.add(choix);
        choixOption.add(choix);
        JTextField text = new JTextField("Rentrez votre réponse");
        listeJtext.add(text);
        cont.add(choix);cont.add(text);

      }
    }
    else if(nom == 3){
      listeTextNote = new ArrayList<JTextField>();
      for(int i=0; i<nbChoix; ++i){
        JTextField texte1 = new JTextField("Rentrez votre réponse");
        listeTextNote.add(texte1);
        cont.add(texte1);
      }
    }
    cont.setBorder(new TitledBorder("Réponses :"));
    cont.validate();
    cont.repaint();
}
}

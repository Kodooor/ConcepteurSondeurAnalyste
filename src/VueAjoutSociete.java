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
/**
 * Vue permettant l'affichage de l'ajout de Client
 * @author Sofiane et Lucas
 *
 */
public class VueAjoutSociete extends JPanel{
  JButton bout;
  JButton boutt;
  EasySond sond;
  JPanel bidon4;
  JPanel milieumilieu;
  ControleurAjout cc;
  JPanel cont;
  JTextField textnb;
  ModeleConcepteur BDConcepteur;
  ArrayList<JRadioButton> listeBouton;
  ArrayList<JTextField> listeJtext;
  ArrayList<JTextField> listeTextNote;
  JTextArea textNum;
  JTextArea texteRaison;
  JTextArea texteAD1;
  JTextArea texteAD2;
  JTextArea texteCP;
  JTextArea texteTel;
  JTextArea texteVille;
  JTextArea texteM;


	/**
	 * Constructeur de l'ajout de l'ajout de Client
	 */
  public VueAjoutSociete(EasySond sond) {
	super();
	this.sond=sond;
    this.setLayout(new BorderLayout());
    this.BDConcepteur = this.sond.basededonnes.BDConcepteur;
    this.cc = new ControleurAjout(this);
    this.cont = new JPanel(new FlowLayout(FlowLayout.LEFT));
	this.add(hautt(),"North");
    this.add(milieu(),"Center");

}
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Ajout Société","Concepteur",this.sond.Nom,this.sond.Prenom);
    return haut;
}
	/**
	 * Méthode qui va appeler le modele afin d'ajouter le Client 
	 */
  void ajouter(){
	  BDConcepteur.ajouterClient(Integer.parseInt(textNum.getText()), texteRaison.getText(),texteAD1.getText(),texteAD2.getText(),Integer.parseInt(texteCP.getText()), texteTel.getText(), texteVille.getText(), texteM.getText());
  }
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
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
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
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
	/**
	 * Méthodes qui vont ajouter la vue 
	 */
  private void informations(JPanel milieumilieu){
	JPanel num = new JPanel(new FlowLayout(FlowLayout.LEFT));
	this.textNum = new JTextArea(4,96);
	this.textNum.setLineWrap(true);
	this.textNum.setWrapStyleWord(true);
	num.setBorder(new TitledBorder("Numéro du Client : "));
	num.add(this.textNum);
	milieumilieu.add(num);
	  
    JPanel enonce = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteRaison = new JTextArea(4,96);
    this.texteRaison.setLineWrap(true);
    this.texteRaison.setWrapStyleWord(true);
    enonce.setBorder(new TitledBorder("Raison Sociale : "));
    enonce.add(this.texteRaison);
	milieumilieu.add(enonce);
	
	
	
    JPanel bis = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteAD1 = new JTextArea(4,96);
    this.texteAD1.setLineWrap(true);
    this.texteAD1.setWrapStyleWord(true);
    bis.setBorder(new TitledBorder("Addresse 1 :"));
    bis.add(this.texteAD1);
	milieumilieu.add(bis);
	
    JPanel bisbis = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteAD2 = new JTextArea(4,96);
    this.texteAD2.setLineWrap(true);
    this.texteAD2.setWrapStyleWord(true);
    bisbis.setBorder(new TitledBorder("Addresse 2 :"));
    bisbis.add(this.texteAD2);
	milieumilieu.add(bisbis);
	
    JPanel CodePostal = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteCP = new JTextArea(4,96);
    this.texteCP.setLineWrap(true);
    this.texteCP.setWrapStyleWord(true);
    CodePostal.setBorder(new TitledBorder("Code Postal : "));
    CodePostal.add(this.texteCP);
	milieumilieu.add(CodePostal);
	
    JPanel ville = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteVille = new JTextArea(4,96);
    this.texteVille.setLineWrap(true);
    this.texteVille.setWrapStyleWord(true);
    ville.setBorder(new TitledBorder("Ville :"));
    ville.add(this.texteVille);
	milieumilieu.add(ville);
	
    JPanel tel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteTel = new JTextArea(4,96);
    this.texteTel.setLineWrap(true);
    this.texteTel.setWrapStyleWord(true);
    tel.setBorder(new TitledBorder("Téléphone :"));
    tel.add(this.texteTel);
	milieumilieu.add(tel);
	
    JPanel mail = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.texteM = new JTextArea(4,96);
    this.texteM.setLineWrap(true);
    this.texteM.setWrapStyleWord(true);
    mail.setBorder(new TitledBorder("email @ :"));
    mail.add(this.texteM);
	milieumilieu.add(mail);
  }
}

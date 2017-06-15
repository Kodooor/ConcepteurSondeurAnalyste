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
  EasySond sond;
  int numQ;

  public VueCreationQuestionnaire(EasySond sond, int numQ) {
		super();
		this.sond=sond;
    this.numQ=numQ;
    this.setLayout(new BorderLayout());
		this.add(hautt(),"North");
}

  Component hautt(){
    VueEnTete haut=new VueEnTete(this.sond,"Accueil Concepteur > Société n°? > Création questionnaire","Concepteur",this.sond.Nom,this.sond.Prenom);
    return haut;
}
}

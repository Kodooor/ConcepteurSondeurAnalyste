import java.awt.BorderLayout;
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


@SuppressWarnings("serial")
public class VueAccueilConcepteur extends JPanel {
	ControleurConcepteur cc;
	ArrayList<Questionnaire> listequestionnaire;
	EasySond sond;
	public VueAccueilConcepteur(EasySond sond) {
		super();
		this.setLayout(new BorderLayout());
		this.sond = sond;
		this.cc = new ControleurConcepteur(this);
		this.listequestionnaire = this.sond.basededonnes.BDConcepteur.listeDesQuestionnaires();
		enTete();
		body();
		System.out.println(listequestionnaire);
	}

	private void enTete(){
		VueEnTete haut=new VueEnTete("Accueil Concepteur","Concepteur",this.sond.Nom,this.sond.Prenom);
		this.add(haut,"North");
	}

	private void body(){
		JPanel principal= new JPanel();
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		VueScrollPan scroll1=new VueScrollPan("A créer");
		VueScrollPan scroll2=new VueScrollPan("En cours");
		principal.add(scroll1);
		principal.add(scroll2);

        // Test
        scroll(scroll1.getPanel(),"salut","créer");
        scroll(scroll1.getPanel(),"Test","créer");


        // Test
        scroll(scroll2.getPanel(),"salut","créer");
        scroll(scroll2.getPanel(),"Test","créer");

        this.add(principal,"Center");
    }
	private void scroll(JPanel p,String label,String bouton){
		JPanel c=new JPanel();
		c.setPreferredSize(new Dimension(50,50));
    	c.setLayout(new GridLayout(1,2));
    	c.add(new JPanel().add(new JLabel(label)));
    	JButton jbouton = new JButton(bouton);
    	jbouton.addActionListener(this.cc);
    	c.add(new JPanel().add(jbouton));
        p.add(c);
	}
}

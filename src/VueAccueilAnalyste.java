import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VueAccueilAnalyste extends JPanel {
	ModeleAnalyste modele;
	ControleurCreerAnalyste cca;
	VueCreerAnalyse vueCreerAnalyse;
	EasySond sond;
	ArrayList<Questionnaire> listeQuestionnaire;
	public VueAccueilAnalyste(EasySond sond) {
		super();
		cca=new ControleurCreerAnalyste(this);
		this.sond = sond;
		this.modele=new ModeleAnalyste(this.sond.basededonnes);
		this.setLayout(new BorderLayout());
		enTete();
		body();
	}
	
	private void enTete(){
		VueEnTete haut=new VueEnTete(this.sond,"Accueil Analyste    ","Analyste",this.sond.Nom,this.sond.Prenom);
		this.add(haut,"North");
	}
	
	private void body(){
		JPanel principal= new JPanel();
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		VueScrollPan scroll1=new VueScrollPan("A créer");
		principal.add(scroll1);
		this.listeQuestionnaire=this.modele.listeDesQuestionnaires();
		for(Questionnaire q:this.listeQuestionnaire){
			scroll(scroll1.getPanel(),q.getTitreQuestionnaire(),"Créer",q.getNumeroQuestionnaire());
		}
        
        this.add(principal,"Center");
        
        
        //Panneau bidon gauche
        JPanel panneauGauche = new JPanel();
        panneauGauche.setBackground(this.sond.couleur);
        JLabel bidon2 = new JLabel("                          ");
        panneauGauche.add(bidon2);
        this.add(panneauGauche,"West");
    }
	private void scroll(JPanel p,String label,String bouton,int idQ){
		
		JPanel c=new JPanel();
    	c.setLayout(new GridLayout(1,2));
    	JPanel temp= new JPanel();
    	temp.setLayout(new BorderLayout());
    	JLabel labeltemp = new JLabel("   "+label);
    	temp.add(labeltemp,"North");
    	c.add(temp);
    	JPanel temp2= new JPanel();
    	temp2.setLayout(new FlowLayout());
    	JButton boutonTemp= new JButton(bouton);
    	boutonTemp.addActionListener(cca);
    	boutonTemp.setName(""+idQ);
    	temp2.add(boutonTemp);
    	c.add(temp2);
    	c.setBorder(BorderFactory.createLineBorder(Color.black));
        p.add(c);
	}
	void afficherVueCreerAnalyse(String nomBouton){
		Container cont = this.sond.getContentPane();
		cont.removeAll();
		vueCreerAnalyse = new VueCreerAnalyse(nomBouton,this);
		cont.add(vueCreerAnalyse);
		cont.validate();
		cont.repaint();
	}

}

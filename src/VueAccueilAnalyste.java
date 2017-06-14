import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VueAccueilAnalyste extends JPanel {
	
	ControleurCreerAnalyste cca;
	VueCreerAnalyse vueCreerAnalyse;
	EasySond sond;
	public VueAccueilAnalyste(EasySond sond) {
		super();
		cca=new ControleurCreerAnalyste(this);
		this.sond = sond;
		this.setLayout(new BorderLayout());
		enTete();
		body();
	}
	
	private void enTete(){
		VueEnTete haut=new VueEnTete("Accueil Analyste","Analyste","Weber","Warren");
		this.add(haut,"North");
	}
	
	private void body(){
		JPanel principal= new JPanel();
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		VueScrollPan scroll1=new VueScrollPan("A créer");
		principal.add(scroll1);
		
        // Test
        scroll(scroll1.getPanel(),"salut","créer");
        scroll(scroll1.getPanel(),"Test","créer");
        
        
        this.add(principal,"Center");
        
        //Panneau de droite
        JPanel panneauDroit=new JPanel();
        //panneauDroit.setLayout(new BoxLayout(panneauDroit,BoxLayout.Y_AXIS));
        panneauDroit.setLayout(new BorderLayout());
        
        //Panel de la barre de recherche
        JPanel panelRecherche = new JPanel();
        //panelRecherche.setLayout(new FlowLayout());
        panelRecherche.setBounds(100,100,50,50);
        JTextField recherche = new JTextField("Rechercher   ");
        panelRecherche.add(new JLabel("   "));
        panelRecherche.add(recherche);
        panelRecherche.add(new JLabel("   "));
        panneauDroit.add(panelRecherche,"North");
        
        //Panel de la recherche avancé
        JPanel rechercheAvance=new JPanel();
        rechercheAvance.setLayout(new BoxLayout(rechercheAvance,BoxLayout.Y_AXIS));
        JPanel panelTitreR = new JPanel();
        panelTitreR.setLayout(new BorderLayout());
        JLabel titreRecherche = new JLabel("Recherche avancée :    ");
        panelTitreR.add(titreRecherche,"North");
        rechercheAvance.add(panelTitreR);
        
        JPanel comboBox= new JPanel();
        JLabel titreCombo= new JLabel("Etat : ");
        String [] lesOptions={"A créer","En cours"};
        JComboBox <String> maListe=new JComboBox <String> (lesOptions);
        comboBox.add(titreCombo);
        comboBox.add(maListe);
        panelTitreR.add(comboBox,"East");
        
        panneauDroit.add(rechercheAvance,"Center");
        
        this.add(panneauDroit,"East");
        
    }
	private void scroll(JPanel p,String label,String bouton){
		
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
    	temp2.add(boutonTemp);
    	c.add(temp2);
    	c.setBorder(BorderFactory.createLineBorder(Color.black));
        p.add(c);
	}
	void afficherVueCreerAnalyse(){
		Container cont = this.sond.getContentPane();
		cont.removeAll();
		vueCreerAnalyse = new VueCreerAnalyse();
		cont.add(vueCreerAnalyse);
		cont.validate();
		cont.repaint();
	}

}

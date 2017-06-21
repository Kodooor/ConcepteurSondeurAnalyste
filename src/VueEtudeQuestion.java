import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class VueEtudeQuestion extends JPanel {
	
	EasySond easySond;
	
	Question question;
	
	ModeleAnalyste modeleAnalyste;
	
	ControleurAnalyseQuestion controleurB;

	JPanel centre;
	
	JPanel panelGeneral;
	
	ControleurEtudeQuestion ceq;
	
	VueCreerAnalyse vca;
	
	VueEtudeQuestion(EasySond easySond, Question q){
		this.easySond = easySond;
		this.question = q;
		this.vca = new VueCreerAnalyse(""+this.question.getNumeroQuestionnaire(),this.easySond.vueAccueilAnalyste);
		this.controleurB = new ControleurAnalyseQuestion(this);
		this.ceq = new ControleurEtudeQuestion(this.vca);
		this.modeleAnalyste = new ModeleAnalyste(easySond.basededonnes);
		this.centre = new JPanel();
		this.panelGeneral = new JPanel();
		enTete();
		corps();
	}

	private void enTete(){
		VueEnTete haut=new VueEnTete(this.easySond,"Accueil Analyste","Analyste",this.easySond.Nom,this.easySond.Prenom);
		this.add(haut,"North");
	}
	
	private void corps(){
		JPanel haut = new JPanel();
		JPanel gauche = new JPanel();
		JPanel droite = new JPanel();
		JPanel bas = new JPanel();
		
		haut.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titre = new JLabel("Question "+this.question.getIdQuestion()+ ": ");
		titre.setFont(new Font("Arial",Font.BOLD,30));
		haut.add(titre);
		
		gauche.add(new JLabel("          "));
		droite.add(new JLabel("          "));
		
		centre.setLayout(new BoxLayout(centre,BoxLayout.Y_AXIS));
		JPanel infoQuestion = new JPanel();
		infoQuestion.setBorder(new TitledBorder("Informations question:"));
		infoQuestion.add(new JLabel(this.question.getTexteQuestion()));
		centre.add(infoQuestion);
		
		genererTableau();
		
		bas.setLayout(new BoxLayout(bas,BoxLayout.Y_AXIS));
		JLabel titreBas1 = new JLabel("Représentation :");
		titreBas1.setFont(new Font("Arial",Font.BOLD,30));
		
		JPanel panelBoutons1 = new JPanel();
		JButton bouton1 = new JButton("Bâtons");
		JButton bouton2 = new JButton("Camembert");
		JButton bouton3 = new JButton("Graphique");
		JButton bouton4 = new JButton("Brut");
		bouton1.addActionListener(this.controleurB);
		bouton2.addActionListener(this.controleurB);
		bouton3.addActionListener(this.controleurB);
		bouton4.addActionListener(this.controleurB);
		panelBoutons1.add(bouton1);
		panelBoutons1.add(bouton2);
		panelBoutons1.add(bouton3);
		panelBoutons1.add(bouton4);

		JLabel titreBas2 = new JLabel("Commenter :");
		titreBas2.setFont(new Font("Arial",Font.BOLD,30));
		
		JTextArea zoneTexte = new JTextArea(5,1);
		zoneTexte.setLineWrap(true);
		zoneTexte.setWrapStyleWord(true);
		
		JPanel panelBoutons2 = new JPanel();
		JButton bouton5 = new JButton("Annuler");
		JButton bouton6 = new JButton("Valider");
		bouton5.setName(""+this.question.getNumeroQuestionnaire());
		bouton5.addActionListener(this.ceq);
		panelBoutons2.add(bouton5);
		panelBoutons2.add(bouton6);
		
		bas.add(titreBas1);
		bas.add(panelBoutons1);
		bas.add(titreBas2);
		bas.add(zoneTexte);
		bas.add(panelBoutons2);
		
		panelGeneral.setLayout(new BorderLayout());
		panelGeneral.add(haut,"North");
		panelGeneral.add(gauche,"West");
		panelGeneral.add(droite,"East");
		panelGeneral.add(centre,"Center");
		panelGeneral.add(bas,"South");
		this.add(panelGeneral,"Center");
	}
	
	void genererTableau(){
		this.panelGeneral.remove(centre);
		this.centre = new JPanel();
		ArrayList<Tranche> listeTranches = this.modeleAnalyste.getTranches();
		ArrayList<String> listeStr = new ArrayList<String>();
		listeStr.add("");
		for(Tranche elem: listeTranches){
			listeStr.add("" + elem.getValeurDebut() + "-" + elem.getValeurFin() + " ans");
		}
		listeStr.add("Total");
		String[] enTete = new String[listeStr.size()];
		enTete = listeStr.toArray(enTete);
		
		HashMap<String,String> dico = this.modeleAnalyste.genererColonneGauche(this.question);
		String[][] listeCorpsTableau = new String[dico.size()][listeStr.size()];
		int i=0;
		for (Map.Entry mapentry : dico.entrySet()) {
			listeCorpsTableau[i][0]=(String) mapentry.getKey();
			int j=1;
			for (Tranche tranche:listeTranches){
				listeCorpsTableau[i][j]= ""+this.modeleAnalyste.getNbpersonnes(mapentry.getKey()+"", tranche.getValeurDebut(), tranche.getValeurFin(),this.question,dico);
				j++;
			}
		    i++;
		}
		
		JScrollPane panelScrolling = new JScrollPane(new JTable(listeCorpsTableau,enTete),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.centre.add(panelScrolling);
		this.panelGeneral.setPreferredSize(new Dimension(1000,700));
		this.panelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelGeneral.add(centre);
		this.panelGeneral.validate();
		
	}
	void genererGraphique(){
		this.panelGeneral.remove(centre);
		this.centre = new JPanel();
		
		JFreeChart chart = ChartFactory.createStackedBarChart("Graphique", "Nombre de réponses", "réponse", createDataset(), PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel general = new ChartPanel(chart);
		
		this.centre.add(general);
		this.centre.setPreferredSize(new Dimension(500,700));
		this.panelGeneral.add(centre,"Center");
		this.panelGeneral.validate();
	}
	
	void genererBatons(){
		this.panelGeneral.remove(centre);
		this.centre = new JPanel();
		
		JFreeChart chart = ChartFactory.createBarChart("Graphique en bâtons", "nombre de personnes", "réponse", createDataset(), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel general = new ChartPanel(chart);
		
		this.centre.add(general);
		this.centre.setPreferredSize(new Dimension(500,700));
		this.panelGeneral.add(centre,"Center");
		this.panelGeneral.validate();
	}
	
	private CategoryDataset createDataset( ) { 
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      //dataset.addValue(nombre,tranche,valeur)
	      //dataset.addVAlue(14,"20-29 ans","rouge")
	      
	      HashMap<String,String> dico = this.modeleAnalyste.genererColonneGauche(this.question);
	      ArrayList<Tranche> listeTranches = this.modeleAnalyste.getTranches();
	      for (Map.Entry mapentry : dico.entrySet()) {
	    	  for (Tranche tranche:listeTranches){
		    	  dataset.addValue(this.modeleAnalyste.getNbpersonnes(mapentry.getKey()+"", 
		    			  												tranche.getValeurDebut(), 
		    			  												tranche.getValeurFin(),
		    			  												this.question,dico),
		    			  			tranche.getValeurDebut()+"-"+tranche.getValeurFin()+" ans",
		    			  			""+mapentry.getKey());
	    		  }
			}

	      return dataset; 
	   }
	
	void genererCamembert(){
		this.panelGeneral.remove(centre);
		this.centre = new JPanel();
		DefaultPieDataset graphe = new DefaultPieDataset();

		HashMap<String,String> dico = this.modeleAnalyste.genererColonneGauche(this.question);
		ArrayList<Tranche> listeTranches = this.modeleAnalyste.getTranches();
		for (Map.Entry mapentry : dico.entrySet()) {
			int cpt = 0;
			for (Tranche tranche:listeTranches){
				cpt+=this.modeleAnalyste.getNbpersonnes(mapentry.getKey()+"", tranche.getValeurDebut(), tranche.getValeurFin(),this.question,dico);
			}
			graphe.setValue(""+mapentry.getKey(), cpt);
		}
		JFreeChart osef1 = ChartFactory.createPieChart3D("Graphique en camembert",graphe,true,true,false);
		
		ChartPanel chart = new ChartPanel(osef1);
		
		this.centre.add(chart);
		this.centre.setPreferredSize(new Dimension(500,700));
		this.panelGeneral.add(centre,"Center");
		this.panelGeneral.validate();
	}
}

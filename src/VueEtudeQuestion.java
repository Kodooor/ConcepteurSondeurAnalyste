import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
	
	VueEtudeQuestion(EasySond easySond, Question q){
		this.easySond = easySond;
		this.question = q;
		this.modeleAnalyste = new ModeleAnalyste(easySond.basededonnes);
		enTete();
		corps();
	}

	private void enTete(){
		VueEnTete haut=new VueEnTete(this.easySond,"Accueil Analyste","Analyste",this.easySond.Nom,this.easySond.Prenom);
		this.add(haut,"North");
	}
	
	private void corps(){
		JPanel panelGeneral = new JPanel();
		JPanel haut = new JPanel();
		JPanel gauche = new JPanel();
		JPanel centre = new JPanel();
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
		
		JTable tableMilieu = genererTableau();
		
		JScrollPane panelScrolling = new JScrollPane(tableMilieu,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		centre.add(panelScrolling);
		
		bas.setLayout(new BoxLayout(bas,BoxLayout.Y_AXIS));
		JLabel titreBas1 = new JLabel("Représentation :");
		titreBas1.setFont(new Font("Arial",Font.BOLD,30));
		
		JPanel panelBoutons1 = new JPanel();
		JButton bouton1 = new JButton("Bâtons");
		JButton bouton2 = new JButton("Camembert");
		JButton bouton3 = new JButton("Graphique");
		JButton bouton4 = new JButton("Brut");
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
	
	private JTable genererTableau(){
		ArrayList<Repondre> listeReponses = this.modeleAnalyste.getListeReponses(this.question);
		ArrayList<Tranche> listeTranches = this.modeleAnalyste.getTranches();
		ArrayList<String> listeStr = new ArrayList<String>();
		listeStr.add("");
		for(Tranche elem: listeTranches){
			listeStr.add("" + elem.getValeurDebut() + "-" + elem.getValeurFin() + " ans");
		}
		listeStr.add("Total");
		System.out.println(listeStr);
		String[] enTete = new String[listeStr.size()];
		enTete = listeStr.toArray(enTete);
		
		ArrayList<String> colonneGauche = this.modeleAnalyste.genererColonneGauche(this.question);
		System.out.println(colonneGauche);
		String[][] listeCorpsTableau = {{"Rouge","1","3","9","25","2","4","50"}};
		
		return new JTable(listeCorpsTableau,enTete);
	}
}

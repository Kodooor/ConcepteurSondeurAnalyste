import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class VueCreerAnalyse extends JPanel{
	ModeleAnalyste modele;
	VueAccueilAnalyste vaa;
	String idQ;
	ArrayList<Question> listeQuestion;
	VueCreerAnalyse(String idQ,VueAccueilAnalyste vaa){
		super();
		this.idQ=idQ;
		this.vaa=vaa;
		this.modele=new ModeleAnalyste(this.vaa.sond.basededonnes);
		this.listeQuestion=this.modele.listeDesQuestion(Integer.parseInt(this.idQ));
		this.setLayout(new BorderLayout());
		this.add(enTete(),"North");
		this.add(corps(),"Center");
		this.add(boutonsBas(),"South");

	}
	private Component enTete(){
		// Le panel haut
		VueEnTete haut = new VueEnTete(this.vaa.sond,"Création d'une analyse","Analyste","Weber","Warren");
		return haut;
	}
	
	private Component corps(){
		int i=0;
		JPanel retour = new JPanel();
		retour.setLayout(new BorderLayout());
		JPanel bidonGauche = new JPanel();
		JPanel conteneurGeneral = new JPanel();
		conteneurGeneral.setLayout(new BoxLayout(conteneurGeneral,BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Liste des questions                           ");
		titre.setFont(new Font("Arial",Font.BOLD,30));
		conteneurGeneral.add(titre);
		JScrollPane scrollerQuestions = new JScrollPane(conteneurGeneral,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		for(Question q:this.listeQuestion){
			i++;
			JPanel cGeneral=new JPanel();
			JPanel cQuestion=new JPanel();
			JPanel cBoutons=new JPanel();
			
			cQuestion.setLayout(new BoxLayout(cQuestion,BoxLayout.Y_AXIS));cGeneral.setLayout(new GridLayout(1,2));
			cBoutons.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton boutton1 = new JButton("modifier");
			JButton boutton2 = new JButton("supprimer");

			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("       Question "+i));
			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("       "+q.getTexteQuestion()));
			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("  "));
			cBoutons.add(new JLabel("            "));
			cBoutons.add(boutton1);
			cBoutons.add(new JLabel("            "));
			cBoutons.add(boutton2);
			conteneurGeneral.add(new JLabel("      "));
			cGeneral.add(cQuestion);
			cGeneral.add(cBoutons);
			cGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
			conteneurGeneral.add(cGeneral);
		}
		bidonGauche.add(new JLabel("                          "));
		retour.add(bidonGauche, "West");
		retour.add(scrollerQuestions, "Center");
		return retour;
	}
	
	private Component boutonsBas(){
		JPanel conteneurBoutons = new JPanel();
		JPanel contB1 = new JPanel();
		JPanel contB2 = new JPanel();
		JPanel contB3 = new JPanel();
		JPanel contB4 = new JPanel();
		
		
		contB1.add(new JButton("Annuler"));
		contB2.add(new JButton("Quitter"));
		contB3.add(new JButton("Enregistrer"));
		contB4.add(new JButton("Envoyer"));
		
		conteneurBoutons.add(contB1);
		conteneurBoutons.add(contB2);
		conteneurBoutons.add(contB3);
		conteneurBoutons.add(contB4);
		return conteneurBoutons;
	}
}

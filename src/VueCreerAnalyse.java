import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

/**
 * Cette classe est la vue de la page de la création d'une analyse, elle hérite de JPanel.
 * @author Hugo, Warren et Chloé
 */

@SuppressWarnings("serial")
public class VueCreerAnalyse extends JPanel{
	/**
	 * C'est un modele, cela permet de récupérer toute les informations neccessaire
	 * au page de l'analyste.
	 */
	ModeleAnalyste modele;
	/**
	 * La vue de l'accueil de l'analyste.
	 */
	VueAccueilAnalyste vaa;
	/**
	 * C'est la variable qui contient l'identifiant du questionnaire.
	 */
	String idQ;
	/**
	 * Cette liste contient la liste des questions du questionnaire.
	 */
	ArrayList<Question> listeQuestion;
	/**
	 * La vue de l'étude d'une question.
	 */
	VueEtudeQuestion vueEtudeQuestion;
	/**
	 * C'est un controleur qui gere les boutons l'étude d'une question.
	 */
	ControleurEtudeQuestion ceq;
	/**
	 * C'est un controleur qui gere les boutons créer de la page.
	 */
	ControleurCreerAnalyste cca;
	/**
	 * Vue qui va afficher la création d'un analyse
	 * @param idQ de type String est la variable qui contient l'identifiant du questionnaire.
	 * @param vaa de type VueAccueilAnalyste est la vue de l'accueil de l'analyste.
	 */
	VueCreerAnalyse(String idQ,VueAccueilAnalyste vaa){
		super();
		this.idQ=idQ;
		this.vaa=vaa;
		this.ceq=new ControleurEtudeQuestion(this);
		this.cca=new ControleurCreerAnalyste(this.vaa);
		this.modele=new ModeleAnalyste(this.vaa.sond.basededonnes);
		this.listeQuestion=this.modele.listeDesQuestion(Integer.parseInt(this.idQ));
		this.setLayout(new BorderLayout());
		this.add(enTete(),"North");
		this.add(corps(),"Center");
		this.add(boutonsBas(),"South");
	}

	/**
	 * Méthode qui permet de crée le panel du haut et à l'ajouter a la fenetre.
	 */
	private Component enTete(){
		// Le panel haut
		VueEnTete haut = new VueEnTete(this.vaa.sond,"Création d'une analyse","Analyste",this.vaa.sond.Nom,this.vaa.sond.Prenom);
		return haut;
	}

	/**
	 * Méthode qui permet de crée tout le visuel de la page.
	 */
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

			JButton boutton1 = new JButton("Selectionner");
			boutton1.addActionListener(this.ceq);
			boutton1.setName(""+q.getIdQuestion());

			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("       Question "+q.getIdQuestion()));
			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("       "+q.getTexteQuestion()));
			cQuestion.add(new JLabel(" "));
			cQuestion.add(new JLabel("  "));
			cBoutons.add(new JLabel("            "));
			cBoutons.add(boutton1);
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

	/**
	 * Méthode qui permet de crée le panel du bas où se trouve les boutonset de l'ajouter a la fenetre .
	 */
	private Component boutonsBas(){
		JPanel conteneurBoutons = new JPanel();
		JPanel contB2 = new JPanel();
		JPanel contB4 = new JPanel();
		JButton quitter = new JButton("Retour");
		quitter.addActionListener(cca);

		contB2.add(quitter);
		contB4.add(new JButton("Envoyer"));

		conteneurBoutons.add(contB2);
		conteneurBoutons.add(contB4);
		return conteneurBoutons;
	}

	/**
	 * @param nom est de type String et permet de récupérer le nom du bouton, qui est
	 * l'idQ
	 */
	public void afficherVueEtudeQuestion(String nom) {
		Container cont = this.vaa.sond.getContentPane();
		cont.removeAll();
		Question temp =this.modele.getQuestion(Integer.parseInt(idQ), Integer.parseInt(nom));
		this.vueEtudeQuestion = new VueEtudeQuestion(this.vaa.sond,temp);
		cont.add(vueEtudeQuestion);
		cont.validate();
		cont.repaint();
	}
}

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VueAccueilSondeur extends JPanel{
	EasySond sond;
	VueAccueilSondeur(EasySond sond){
		super();
		this.sond = sond;
		//Container Principal
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

			//niveau 1, Annonce la page.
		JPanel lv1= new JPanel();
		lv1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lv1.add(nomPage());
		//lv1.add(nomPage());

		this.add(lv1);

			//niveau 2, informe sur le sondage en question.
		JPanel lv2= new JPanel();
		lv2.setLayout(new FlowLayout());
		lv2.add(nomSondage());

		this.add(lv2);

			//niveau 3, informe sur le sondé en question.
		JPanel lv3= new JPanel();
		lv3.setLayout(new FlowLayout());
		lv3.add(infoSonde());

		this.add(lv3);

			//niveau 4, disposition des bouton.
		JPanel lv4= new JPanel();
		lv4.setLayout(new FlowLayout());
		lv4.add(boutons());

		this.add(lv4);

			//niveau 5, bouton help
		JPanel lv5= new JPanel();
		lv5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lv5.add(help());

		this.add(lv5);


		this.setVisible(true); //affiche le tout
	}

	JPanel nomPage(){	//Annonce de la page
		JPanel panelNom= new JPanel();
		JLabel labelNom= new JLabel(">> Acceuil Sondeur");
		panelNom.add(labelNom);

		return panelNom;
	}

	JPanel nomSondage(){	//Annonce le nom du sondage
		EasySond fenetrePrincipale=(EasySond) this.sond.getRootPane().getParent();
		JPanel panelNom= new JPanel();
		Questionnaire questionnaire = fenetrePrincipale.basededonnes.BDaccueilSondeur.GetQuestionnaire();
		System.out.println(fenetrePrincipale.basededonnes.BDaccueilSondeur.GetQuestionnaire());
		JLabel labelNom;
		if(questionnaire == null){
			labelNom= new JLabel("Vous avez terminé tout les sondages.");// + questionnaire.getTitreQuestionnaire());

		}
		else{
			labelNom= new JLabel("Questionnaire : "+ questionnaire.getTitreQuestionnaire());
		}
		panelNom.add(labelNom);

		return panelNom;
	}

	JPanel infoSonde(){	//Annonce les info du sondé
		JPanel panelInfo= new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.Y_AXIS));
		panelInfo.setBorder(new TitledBorder("Fiche Sondé"));
		JLabel labelVide= new JLabel("     ");
		JLabel labelNom= new JLabel("     Nom : "+"Paqueno      ");
		JLabel labelPrenom= new JLabel("     Prénom : "+"Jean      ");
		JLabel labelAddress= new JLabel("     Adresse : "+"24 rue du hachie      ");
		panelInfo.add(labelVide);
		panelInfo.add(labelNom);
		panelInfo.add(labelVide);
		panelInfo.add(labelPrenom);
		panelInfo.add(labelVide);
		panelInfo.add(labelAddress);
		panelInfo.add(labelVide);

		return panelInfo;
	}

	JPanel boutons(){
		JPanel panelBoutons= new JPanel();
		panelBoutons.setLayout(new BoxLayout(panelBoutons,BoxLayout.X_AXIS));
		JButton b1= new JButton("    Appeler le sondé    ");
		JButton b2= new JButton("Accéder au questionnaire");
		JButton b3= new JButton("Passer au sondé suivant ");
		b2.setEnabled(false);
		panelBoutons.add(b1);
		panelBoutons.add(b2);
		panelBoutons.add(b3);

		return panelBoutons;
	}

	JPanel help(){
		JPanel panelHelp= new JPanel();
		JButton b= new JButton("Help");
		panelHelp.add(b);

		return panelHelp;
	}
}

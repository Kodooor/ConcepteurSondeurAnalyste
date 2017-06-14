import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VueAccueilSondeur extends JPanel{
	EasySond sond;
	Questionnaire questionnaire;
	ArrayList<Sonde> listeSonde;
  ControleurAccueilSondeur actionBoutons;

	VueAccueilSondeur(EasySond sond){
		super();
		this.sond = sond;
		this.questionnaire = this.sond.basededonnes.BDaccueilSondeur.GetQuestionnaire();
		this.listeSonde = this.sond.basededonnes.BDaccueilSondeur.GetListeSonde(this.questionnaire.getIdentifiantPanel());
		pageGenerator(false);
		this.setVisible(true); //affiche le tout


	}

	void refresh(boolean e){
		Container cont=this.sond.getContentPane();
		cont.removeAll();
		cont.add(pageGenerator(e));
		cont.repaint();
		cont.validate();
	}

	JPanel pageGenerator(boolean e){
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			//niveau 1, Annonce la page.
		JPanel lv1= new JPanel();
		lv1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lv1.add(nomPage());
		this.add(lv1);
		p.add(lv1);

			//niveau 2, informe sur le sondage en question.
		JPanel lv2= new JPanel();
		lv2.setLayout(new FlowLayout());
		lv2.add(nomSondage());
		this.add(lv2);
		p.add(lv2);

			//niveau 3, informe sur le sondé en question.
		JPanel lv3= new JPanel();
		lv3.setLayout(new FlowLayout());
		lv3.add(infoSonde());
		this.add(lv3);
		p.add(lv3);

			//niveau 4, disposition des bouton.
		JPanel lv4= new JPanel();
		lv4.setLayout(new FlowLayout());
		lv4.add(boutons(e));
		this.add(lv4);
		p.add(lv4);

			//niveau 5, bouton help
		JPanel lv5= new JPanel();
		lv5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lv5.add(help());
		this.add(lv5);

		p.add(lv5);


		return p;
	}

	JPanel nomPage(){	//Annonce de la page
		JPanel panelNom= new JPanel();
		JLabel labelNom= new JLabel(">> Acceuil Sondeur");
		panelNom.add(labelNom);

		return panelNom;
	}

	JPanel nomSondage(){	//Annonce le nom du sondage
		JPanel panelNom= new JPanel();
		JLabel labelNom;
		if(this.questionnaire == null){
			labelNom= new JLabel("Vous avez terminé tout les sondages.");// + questionnaire.getTitreQuestionnaire());

		}
		else{
			labelNom= new JLabel("Questionnaire : "+ this.questionnaire.getTitreQuestionnaire());
		}
		panelNom.add(labelNom);

		return panelNom;
	}

	JPanel infoSonde(){	//Annonce les info du sondé
		JPanel panelInfo= new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.Y_AXIS));
		panelInfo.setBorder(new TitledBorder("Fiche Sondé"));
		JLabel labelVide= new JLabel("                                                                           ");
		JLabel labelNom= new JLabel("Nom :                       "+this.listeSonde.get(0).getNomSonde());
		JLabel labelPrenom= new JLabel("Prénom :                 "+this.listeSonde.get(0).getPrenomSonde());
		JLabel labelAddress= new JLabel("Date naissance :   "+this.listeSonde.get(0).getDateNaissanceSonde());
		panelInfo.add(labelVide);
		panelInfo.add(labelNom);
		panelInfo.add(labelVide);
		panelInfo.add(labelPrenom);
		panelInfo.add(labelVide);
		panelInfo.add(labelAddress);
		panelInfo.add(labelVide);

		return panelInfo;
	}

	JPanel boutons(boolean e){
		JPanel panelBoutons= new JPanel();
		panelBoutons.setLayout(new BoxLayout(panelBoutons,BoxLayout.X_AXIS));

		JButton b2= new JButton("Accéder au questionnaire");
		JButton b3= new JButton("Passer au sondé suivant ");
		if(e==false){
			JButton b1= new JButton("    Appeler le sondé    ");
			b1.addActionListener(this.actionBoutons);
			panelBoutons.add(b1);
			b2.setEnabled(false);
		}
		else{
			JButton b1= new JButton("Appel en cours (annuler)");
			b1.addActionListener(this.actionBoutons);
			panelBoutons.add(b1);
			b3.setEnabled(false);
		}
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

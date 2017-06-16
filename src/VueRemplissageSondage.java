import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class VueRemplissageSondage extends JPanel{
	EasySond sond;
	ControleurRemplissageSondage controleur;
	Questionnaire questionnaire;
	Sonde sonde;
	ArrayList<Question> listeQuestion;
	int numeroQuestion;
	VueAccueilSondeur vueAccueilSondeur;


	VueRemplissageSondage(EasySond sond, Questionnaire q, Sonde s){
		super();
		this.sond=sond;
		this.controleur= new ControleurRemplissageSondage(this);
		this.setVisible(true);
		this.questionnaire = q;
		this.sonde = s;
		this.listeQuestion = this.sond.basededonnes.BDaccueilSondeur.GetListeQuestion(this.questionnaire.getNumeroQuestionnaire());
		this.numeroQuestion = 0;
		pageGenerator();
	}

	void refreshAccueil(){
		Container cont=this.sond.getContentPane();
		cont.removeAll();
		vueAccueilSondeur = new VueAccueilSondeur(this.sond);
		cont.add(vueAccueilSondeur);
		cont.setBackground(new Color(78,217,255));
		cont.validate();
		cont.repaint();
	}

	void questionChangement(int e){
		this.numeroQuestion+=e;
		refresh();
	}

	void refresh(){
		Container cont=this.sond.getContentPane();
		this.removeAll();
		pageGenerator();
		cont.validate();
		cont.repaint();
	}

	void pageGenerator(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

			//niveau 1
		JPanel lv1= new JPanel();
		lv1.setLayout(new FlowLayout(FlowLayout.LEFT));
		nomPage(lv1);
		this.add(lv1);

			//niveau 2
		JPanel lv2= new JPanel();
		lv2.setLayout(new BoxLayout(lv2,BoxLayout.Y_AXIS));
		nomSondage(lv2);
		this.add(lv2);

			//niveau 3
		JPanel lv3= new JPanel();
		lv3.setLayout(new FlowLayout());
		intitule(lv3);
		this.add(lv3);

			//niveau 4
		JPanel lv4= new JPanel();
		lv4.setLayout(new BoxLayout(lv4,BoxLayout.X_AXIS));
		lv4.add(reponse());
		this.add(lv4);

			//niveau 5
		JPanel lv5= new JPanel();
		lv5.setLayout(new BoxLayout(lv5,BoxLayout.X_AXIS));
		lv5.add(boutons());
		this.add(lv5);
	}

	void nomPage(JPanel lv1){	//Annonce de la page
		JPanel panelNom= new JPanel();
		JLabel labelNom= new JLabel(">> Acceuil Sondeur >> Remplissage Sondage");
		panelNom.add(labelNom);
		lv1.add(panelNom);
	}

	void nomSondage(JPanel lv2){	//Annonce de la page
		JPanel panelNom= new JPanel();
		panelNom.setLayout(new BoxLayout(panelNom,BoxLayout.Y_AXIS));
		JLabel label1= new JLabel("Questionnaire : "+this.questionnaire.getTitreQuestionnaire());
		JLabel label2= new JLabel("Question "+ this.listeQuestion.get(this.numeroQuestion).getIdQuestion() +":");
		panelNom.add(label1);
	  panelNom.add(label2);
		lv2.add(panelNom);
	}

	void intitule(JPanel lv3){	//Annonce de la page
		JPanel panelIntitule= new JPanel();
		panelIntitule.setLayout(new BoxLayout(panelIntitule,BoxLayout.X_AXIS));
		JLabel label1= new JLabel("Intitulé : ");
		JLabel label2= new JLabel(this.listeQuestion.get(this.numeroQuestion).getTexteQuestion());
		panelIntitule.add(label1);
		panelIntitule.add(label2);
		lv3.add(panelIntitule);
	}

	Component reponse(){
		JPanel question= new JPanel();
		question.setLayout(new BoxLayout(question,BoxLayout.X_AXIS));
		//intitulé
		question.setBorder(new TitledBorder("Réponse"));
		//réponses
		JPanel panelQuestion= new JPanel();
		ButtonGroup panelChoix=new ButtonGroup();
		Question questionActuelle = this.listeQuestion.get(this.numeroQuestion);
		String typeQuestion = questionActuelle.getIdTypeQuestion();
		int maxValeur = questionActuelle.getMaxValeur();
		ArrayList<ValeurPossible>  listeValeur= this.sond.basededonnes.BDaccueilSondeur.GetListeValeurPossible(questionActuelle.getNumeroQuestionnaire(),questionActuelle.getIdQuestion());

		switch(typeQuestion){
			//choix unique
			case "u": for(int i=0; i < listeValeur.size() ; i++){
								 JRadioButton c =new JRadioButton("" + listeValeur.get(i).getValeur());
								 panelQuestion.add(c);
								 panelChoix.add(c);
							 }
							break;
			//choix multiple
			case "m": for(int i=0;i < listeValeur.size() ; i++){
								 JCheckBox  c =new JCheckBox(listeValeur.get(i).getValeur());
								 panelQuestion.add(c);
							 }
							break;
			//classement
			case "c": 	for (int i = 1 ; i <= maxValeur ; i++){
									JLabel label = new JLabel("Numéro "+i);
									panelQuestion.add(label);
									String [] liste2= new String[listeValeur.size()];
									for (int j = 0 ; j < listeValeur.size(); ++j){
										liste2[j] = listeValeur.get(j).getValeur();
									}
									JComboBox <String> maListe2=new JComboBox <String> (liste2);
									panelQuestion.add(maListe2);
								}

							break;
			//réponse
			case "l":JTextField maZone=new JTextField(100);
							 panelQuestion.add(maZone);
							break;
			//note
			case "n":String [] liste2= new String[maxValeur+1];
							 for (int i=0; i <= maxValeur ; i++){
								 liste2[i] = ""+i;
							 }
							 JComboBox <String> maListe2=new JComboBox <String> (liste2);
							 panelQuestion.add(maListe2);
							break;
		}
		question.add(panelQuestion);
		return question;
	}

	JPanel boutons(){
		JPanel panelBoutons= new JPanel();
		JButton b1= new JButton("<-------");
		b1.addActionListener(this.controleur);
		JButton b2= new JButton("Racrocher");
		b2.addActionListener(this.controleur);
		JButton b3= new JButton("------->");
		b3.addActionListener(this.controleur);
		if(this.numeroQuestion==0){
			b1.setEnabled(false);
		}
		else if(this.numeroQuestion==this.listeQuestion.size()-1){
			b3.setEnabled(false);
		}
		panelBoutons.add(b1);
		panelBoutons.add(b2);
		panelBoutons.add(b3);

		return panelBoutons;
	}
}

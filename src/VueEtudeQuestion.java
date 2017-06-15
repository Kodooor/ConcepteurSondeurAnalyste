import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class VueEtudeQuestion extends JPanel {
	
	EasySond easySond;
	
	Question question;
	
	VueEtudeQuestion(EasySond easySond, Question q){
		this.easySond = easySond;
		this.question = q;
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
		
//		JPanel reponses = new JPanel();
//		reponses.setBorder(new TitledBorder("Les réponses"));
//		ArrayList<Repondre> listeReponses = new ArrayList<Repondre>();
//		listeReponses.add(new Repondre(1,1,'')
		
		panelGeneral.setLayout(new BorderLayout());
		panelGeneral.add(haut,"North");
		panelGeneral.add(gauche,"West");
		panelGeneral.add(droite,"East");
		panelGeneral.add(centre,"Center");
		this.add(panelGeneral,"Center");
	}
}

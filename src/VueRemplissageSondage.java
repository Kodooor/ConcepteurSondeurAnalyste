import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VueRemplissageSondage extends JPanel{
	EasySond sond;
	VueRemplissageSondage(EasySond sond){
		super();
		this.sond=sond;
		pageGenerator(0);
		this.setVisible(true);
	}

	// void refresh(int e){
	// 	Container cont=this.sond.getContentPane();
	// 	this.removeAll();
	// 	pageGenerator(e);
	// 	cont.validate();
	// 	cont.repaint();
	// }

	void pageGenerator(int e){
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


			//niveau 5

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
		JLabel label1= new JLabel("Questionnaire : "+"Sondage sur les pastèques");
		JLabel label2= new JLabel("Question"+"1"+" :");
		panelNom.add(label1);
		panelNom.add(label2);
		lv2.add(panelNom);
	}

	void intitule(JPanel lv3){	//Annonce de la page
		JPanel panelIntitule= new JPanel();
		panelIntitule.setLayout(new BoxLayout(panelIntitule,BoxLayout.X_AXIS));
		JLabel label1= new JLabel("Intitulé : ");
		JLabel label2= new JLabel("les pastèque sont cuites, A, B C?");
		panelIntitule.add(label1);
		panelIntitule.add(label2);
		lv3.add(panelIntitule);
	}

	JPanel question(){
		JPanel question= new JPanel();
		question.setLayout(new BoxLayout(question,BoxLayout.X_AXIS));
		JLabel label = new JLabel("Intitulé : ");
		return question;
	}
}

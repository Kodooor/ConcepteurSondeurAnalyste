import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;


public class ControleurChampsEtudeQuestion implements ActionListener{
	
	MemoireQuestions memoire;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		memoire = new MemoireQuestions(((JTextArea)arg0.getSource()).getText());
	}
}

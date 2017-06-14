import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class VueScrollPan extends JPanel {
	
	private String titre;
	private JPanel jp;
	
	VueScrollPan(String titre){
		super();
		this.titre=titre;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.jp=new JPanel();
		body();
	}
	private void body(){
		JLabel titreSection = new JLabel(this.titre);
		Font font = new Font("Arial",Font.BOLD,24);
		titreSection.setFont(font);
		this.setPreferredSize(new Dimension(300,300));
		this.add(titreSection);
	    this.jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
	    JScrollPane js = new JScrollPane(this.jp,
	                                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                                     JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    this.add(js);
	}
	
	public JPanel getPanel(){
		return this.jp;
	}
}

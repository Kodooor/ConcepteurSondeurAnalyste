import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * @author weber
 *	Cette classe permet de créer un panel scrollable avec un titre
 */
@SuppressWarnings("serial")
public class VueScrollPan extends JPanel {

	/**
	 * Cette variable est un String, ce sera le titre d'afficher. 
	 */
	private String titre;
	/**
	 * Cette variable est un JPanel, ce sera le panel scrollable
	 */
	private JPanel jp;
	/**
	 * C'est le constructeur de la classe
	 * @param titre, c'est un String et permet de rentré un titre au choix
	 */
	VueScrollPan(String titre){
		super();
		this.setBackground(new Color(78,217,255));
		this.titre=titre;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.jp=new JPanel();
		this.jp.setBackground(new Color(78,217,255));
		body();
	}
	/**
	 * Méthode qui crée le visuel
	 */
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

	/**
	 * @return JPanel, permet d'accéder au panel.
	 */
	public JPanel getPanel(){
		return this.jp;
	}
}

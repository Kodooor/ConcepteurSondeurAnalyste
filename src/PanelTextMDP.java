import java.awt.*;

import javax.swing.*;


/**
 * un panel qui gere un JTextField avec un JLabel associe
 * @author IUT'O dpt Informatique
 * 
 */

public class PanelTextMDP extends JPanel {

	/**
	 * Le JTextField
	 */
	JPasswordField jt;
	/**
	 * Le JLabel
	 */
	JLabel jl;
	/**
	 * Constructeur permettant de fixer la taille du JTextField
	 * @param etiquette le label associe au champ de texte
	 * @param size la taille du champ de saisie
	 */
	public PanelTextMDP(String etiquette, int size) {
		super();
		this.setLayout(new FlowLayout());
		jl=new JLabel(etiquette);
		jt=new JPasswordField(size);
		this.add(jl);
		this.add(jt);
	}
	/**
	 * permet d'avoir acces au JTextField
	 * @return le JTextField
	 */
	public JPasswordField getJPasswordField(){
		return this.jt;
	}

	/**
	 * permet d'affecter une valeur au JTextField
	 * @param val
	 */
	public void setValue(String val){
		this.jt.setText(val);
	}
	/**
	 * permet de changer le label 
	 * @param label  nouveau label
	 */
	public void setLabel(String label){
		this.jl.setText(label);
	}
}

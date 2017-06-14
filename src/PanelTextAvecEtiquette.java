import java.awt.*;

import javax.swing.*;


/**
 * un panel qui gere un JTextField avec un JLabel associe
 * @author IUT'O dpt Informatique
 * 
 */

public class PanelTextAvecEtiquette extends JPanel {

	/**
	 * Le JTextField
	 */
	JTextField jt;
	/**
	 * Le JLabel
	 */
	JLabel jl;
	/**
	 * Constructeur permettant de fixer la taille du JTextField
	 * @param etiquette le label associe au champ de texte
	 * @param size la taille du champ de saisie
	 */
	public PanelTextAvecEtiquette(String etiquette, int size) {
		super();
		this.setLayout(new FlowLayout());
		jl=new JLabel(etiquette);
		jt=new JTextField(size);
		this.add(jl);
		this.add(jt);
	}
	/**
	 * Cosntructeur permettant d'initialise le JTextField par une valeur
	 * @param etiquette le label associe au champ de texte
	 * @param val la valeur initiale du champ texte
	 */
	public PanelTextAvecEtiquette(String etiquette, String val) {
		super();
		this.setLayout(new FlowLayout());
		JLabel jl=new JLabel(etiquette);
		jt=new JTextField(val);
		this.add(jl);
		this.add(jt);
	}

	/**
	 * permet d'avoir acces au JTextField
	 * @return le JTextField
	 */
	public JTextField getJTextField(){
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

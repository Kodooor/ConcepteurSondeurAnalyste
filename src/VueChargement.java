import java.awt.*;

import javax.swing.*;

/**
 * Vue permettant l'affichage du chargement de l'application
 * @author Sofiane et Lucas
 * 
 */
public class VueChargement extends JPanel {
	/**
	 * Constructeur du Chargement.
	 */
	public VueChargement() {
		super();
		this.setLayout(new BorderLayout());
		this.add(haut(), "North");
		this.add(milieu(), "Center");
		this.add(bas(), "South");
	}
	/**
	 * remplace la vue motus par la vue formulaire
	 */
	private Component bas() {
		JPanel PanelBas = new JPanel();
		JButton passer = new JButton("Passer");
		passer.addActionListener(new ControleurPasser(this));
		PanelBas.add(passer);
		PanelBas.setBackground(new Color(78,217,255));
		return PanelBas;
	}
	/**
	 * remplace la vue motus par la vue formulaire
	 */
	private Component milieu() {
		JPanel PanelMilieu = new JPanel();
		JLabel Texte = new JLabel("Voici une belle page de chargement haha !");
		JLabel Textebis = new JLabel("Cette page ne sert à rien mais bon il fallait bien un point de départ !");
		PanelMilieu.add(Texte);
		PanelMilieu.add(Textebis);
		PanelMilieu.setBackground(new Color(78,217,255));
		return PanelMilieu;
	}
	/**
	 * remplace la vue motus par la vue formulaire
	 */
	private Component haut() {
		JPanel PanelHaut = new JPanel();
		PanelHaut.setLayout(new BorderLayout());
		JLabel image = new JLabel( new ImageIcon("Logo.png"));
		PanelHaut.add(image, "Center");
		PanelHaut.setBackground(new Color(78,217,255));
		return PanelHaut;
	}


}

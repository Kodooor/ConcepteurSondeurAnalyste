import java.awt.*;

import javax.swing.*;

/**
 * Vue permettant l'affichage de l'accueil
 * @author Sofiane et Lucas
 *
 */
public class VueAccueil extends JPanel {
	/**
	 * la vue JTextField
	 */
	VueTextField textfield;
	/**
	 * Constructeur de l'accueil
	 */
	public VueAccueil() {
		super();
		this.setLayout(new BorderLayout());
		this.add(haut(),"North");
		this.add(milieu(),"Center");
		this.add(bas(),"South");
	}
	/**
	 * remplace la vue de chargement par l'accueil de l'application
	 * @return Le panel
	 */
	private Component bas() {
		JPanel PanelBas = new JPanel();
		JButton passer = new JButton("Se connecter");
		passer.addActionListener(new ControleurAccueil(this));
		PanelBas.add(passer);
		PanelBas.setBackground(new Color(78,217,255));
		return PanelBas;
	}
	/**
	 * remplace la vue de chargement par l'accueil de l'application
	 * @return Le TextField
	 */
	private Component milieu() {
		textfield = new VueTextField();
		return textfield;
	}
	/**
	 * remplace la vue de chargement par l'accueil de l'application
	 * @return Le panel
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

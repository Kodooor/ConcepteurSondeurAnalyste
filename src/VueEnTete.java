import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author weber
 *	Cette classe permet de crée le panel du haut de l'application.
 */
@SuppressWarnings("serial")
public class VueEnTete extends JPanel {
	/**
	 * Cette variable est le titre de la page.
	 */
	private String titre;
	/**
	 * Cette variable est le role de la personne connecté.
	 */
	String role;
	/**
	 * Cette variable est le nom de la personne qui sera connecter.
	 */
	String nom;
	/**
	 * Cette variable est le prenom de la personne qui sera connecter.
	 */
	String prenom;
	/**
	 * Cette variable permet de récupérer la couleur, la taille de la fenetre et 
	 * d'utiliser les controleur.
	 */
	EasySond sond;
	/**
	 * Cette variable est le controleur qui gere le bouton de déconnection.
	 */
	private ControleurDeco cc;
	
	/**
	 * Cette variable est le controleur qui gere le bouton home qui permet de revenir à
	 * la page d'accueil du module en cour.
	 */
	ControleurMaison cm;
	
	/**
	 * @param sond est de type Easysond.Cette variable permet de récupérer la couleur, 
	 * la taille de la fenetre et d'utiliser les controleur
	 * @param titre est de type String. Cette variable est le role de la personne connecté.
	 * @param role est de type String. Cette variable est le role de la personne 
	 * qui sera connecter.
	 * @param nom est de type String. Cette variable est le nom de la personne qui 
	 * sera connecter.
	 * @param prenom est de type String. Cette variable est le prenom de la personne qui 
	 * sera connecter.
	 */
	VueEnTete(EasySond sond,String titre,String role,String nom,String prenom){
		super();
		this.sond=sond;
		this.setBackground(this.sond.couleur);
		this.titre=titre;
		this.role=role;
		this.nom=nom;
		this.prenom=prenom;
		this.cc = new ControleurDeco(this);
		this.cm= new ControleurMaison(this.sond);
		enTete();
	}
	
	/**
	 * Cette méthode crée tout le visuel du panel
	 */
	private void enTete(){
		
		// Le panel haut
		JPanel haut= new JPanel();
		haut.setLayout(new GridLayout(1,2));
		haut.setBackground(this.sond.couleur);
		//Panel Titre
		JPanel titre=new JPanel();
		titre.setLayout(new BoxLayout(titre,BoxLayout.PAGE_AXIS));
		titre.setBackground(this.sond.couleur);
		JLabel titreprincipal=new JLabel(this.titre);
		Font font = new Font("Arial",Font.BOLD,26);
		titreprincipal.setFont(font);
		titre.add(titreprincipal);
		haut.add(titre,"West");
		
		
		
		//Panel image
		JPanel panelImage=new JPanel();
		panelImage.setBackground(this.sond.couleur);
		JLabel image = new JLabel(new ImageIcon("LogoPetit.png"));
		image.setSize(panelImage.getWidth(),panelImage.getHeight());
		panelImage.add(image);
		panelImage.repaint();
		
		//Cadre de déconnection
		JPanel Deconnexion=new JPanel();
		Deconnexion.setLayout(new GridLayout(2,2));
		Deconnexion.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel panelRole=new JPanel();
		panelRole.setLayout(new BoxLayout(panelRole,BoxLayout.Y_AXIS));
		panelRole.setBackground(new Color(255,157,52));
		JLabel role =new JLabel("Role : "+this.role);
		panelRole.add(role);
		Deconnexion.add(panelRole);
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
		info.setBackground(new Color(255,157,52));
		JLabel nom = new JLabel("Nom :"+this.nom);
		JLabel prenom = new JLabel("Prenom :"+this.prenom);
		info.add(nom);
		info.add(prenom);
		Deconnexion.add(info);
		JPanel imageHome = new JPanel();
		ImageIcon maison = new ImageIcon("home.jpg");
		JButton boutonMaison = new JButton(maison);
		boutonMaison.addActionListener(this.cm);
		boutonMaison.setOpaque(false);
		boutonMaison.setContentAreaFilled(false);
		boutonMaison.setBorderPainted(false);
		imageHome.add(boutonMaison);
		Deconnexion.setBackground(new Color(255,157,52));
		imageHome.setBackground(new Color(255,157,52));
		Deconnexion.add(imageHome);
		JButton boutonDeconnexion=new JButton("Deconnexion");
		boutonDeconnexion.addActionListener(this.cc);
		Deconnexion.add(boutonDeconnexion);
		panelImage.add(Deconnexion);
		haut.add(panelImage,"East");
		haut.setLayout(new FlowLayout());
		((FlowLayout) haut.getLayout()).setHgap(this.sond.getWidth()/3);
		this.add(haut,"North");
	}

}

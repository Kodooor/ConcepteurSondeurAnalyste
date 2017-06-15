import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class VueEnTete extends JPanel {
	private String titre;
	String role;
	String nom;
	String prenom;
	private ControleurDeco cc;
	EasySond sond;
	VueEnTete(EasySond sond,String titre,String role,String nom,String prenom){
		super();
		this.sond=sond;
		this.titre=titre;
		this.role=role;
		this.nom=nom;
		this.prenom=prenom;
		this.cc = new ControleurDeco(this);
		enTete();
	}
	private void enTete(){
		
		// Le panel haut
		JPanel haut= new JPanel();
		haut.setLayout(new GridLayout(1,2));
		//Panel Titre
		JPanel titre=new JPanel();
		titre.setLayout(new BoxLayout(titre,BoxLayout.PAGE_AXIS));
		JLabel titreprincipal=new JLabel(this.titre);
		Font font = new Font("Arial",Font.BOLD,26);
		titreprincipal.setFont(font);
		titre.add(titreprincipal);
		haut.add(titre,"West");
		
		
		
		//Panel image
		JPanel panelImage=new JPanel();
		JLabel image = new JLabel(new ImageIcon("LogoPetit.png"));
		image.setSize(panelImage.getWidth(),panelImage.getHeight());
		panelImage.add(image);
		panelImage.repaint();
		
		//Cadre de déconnection
		JPanel Deconnexion=new JPanel();
		Deconnexion.setLayout(new GridLayout(2,2));
		JPanel panelRole=new JPanel();
		JLabel role =new JLabel("Role : "+this.role);
		panelRole.add(role);
		panelRole.setBackground(Color.CYAN);
		Deconnexion.add(panelRole);
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
		info.setBackground(Color.CYAN);
		JLabel nom = new JLabel("Nom :"+this.nom);
		JLabel prenom = new JLabel("Prenom :"+this.prenom);
		info.add(nom);
		info.add(prenom);
		Deconnexion.add(info);
		JPanel imageHome = new JPanel();
		ImageIcon maison = new ImageIcon("home.jpg");
		JButton boutonMaison = new JButton(maison);
		//JLabel home = new JLabel(new ImageIcon("home.jpg"));
		//home.setSize(panelImage.getWidth(),panelImage.getHeight());
		boutonMaison.setOpaque(false);
		boutonMaison.setContentAreaFilled(false);
		boutonMaison.setBorderPainted(false);
		imageHome.add(boutonMaison);
		Deconnexion.setBackground(Color.CYAN);
		imageHome.setBackground(Color.CYAN);
		Deconnexion.add(imageHome);
		JButton boutonDeconnexion=new JButton("Deconnexion");
		boutonDeconnexion.addActionListener(this.cc);
		Deconnexion.add(boutonDeconnexion);
		Deconnexion.setBackground(Color.CYAN);
		panelImage.add(Deconnexion);
		haut.add(panelImage,"East");
		haut.setLayout(new FlowLayout());
		((FlowLayout) haut.getLayout()).setHgap(this.sond.getWidth()/5);
		this.add(haut,"North");
	}

}

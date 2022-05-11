package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

	static JFrame f = new JFrame();
	static Welcoming wel = new Welcoming();
	static SignIn si = new SignIn();
	static Menu menu = new Menu();
	static FindParticipant fp = new FindParticipant();
	static EditParticipant mp = new EditParticipant();
	static AddParticipant add = new AddParticipant();
	static DescriptionSheet ds = new DescriptionSheet();
	static Delegation deleg = new Delegation();
	static EntrepriseGUI ent = new EntrepriseGUI();
	static RetailerGUI com = new RetailerGUI();
	static BoatGUI bat = new BoatGUI();
	static Famille fa = new Famille();
	static PersonneMorale pm = new PersonneMorale();
	static String mailAccount;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Creation de la frame
					//Ceci est le debut du programme
					f.setTitle("ARMADA 2023");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setBounds(100, 100, 1080, 720);
					f.setResizable(false);
					f.setVisible(true);
					//On affiche le contenue de la page d'acceuil
					f.setContentPane(wel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Remplace le contenue de la page d'acceuil par celui de la page d'inscription
	 */
	public static void welToSi() {
		wel.setVisible(false);
		f.setContentPane(si);
		si.setVisible(true);
	}
	
	/**
	 * Remplace le contenue de la page d'inscription par celui de la page d'acceuil
	 */
	public static void siToWel() {
		si.setVisible(false);
		f.setContentPane(wel);
		wel.setVisible(true);
	}
	
	/**
	 * Remplace le contenue de la page d'acceuil par celui du menu principal
	 */
	public static void welToMenu() {
		wel.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	/**
	 * Remplace le contenue du menu par celui de la page d'accueil
	 */
	public static void menuToWel() {
		menu.setVisible(false);
		f.setContentPane(wel);
		wel.setVisible(true);
	}
	
	/**
	 * Remplace le contenue du menu par celui de la page dédiée à la recherche 
	 */
	public static void menuToFp() {
		menu.setVisible(false);
		f.setContentPane(fp);
		fp.setVisible(true);
	}
	
	/**
	 * Remplace le contenue de la page FindParticipant par celui du menu
	 */
	public static void fpToMenu() {
		fp.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	/**
	 * Remplace le contenue de la page FindParticipant par celui de la page EditParticipant
	 */
	public static void fpToMp() {
		fp.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}

	/**
	 * Remplace le contenue de la page FindParticipant par celui du menu
	 */
	public static void fmToMenu() {
		mp.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}

	/**
	 * Remplace le contenue du menu par celui de la page EditParticipant
	 */
	public static void menuToMp() {
		menu.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}

	/**
	 * Remplace le contenue de la page AddParticipant par celui du menu
	 */
	public static void addToMenu() {
		add.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	/**
	 * Remplace le contenue de la page menu par celui de la page AddParticipant
	 */
	public static void menuToAdd() {
		menu.setVisible(false);
		f.setContentPane(add);
		add.setVisible(true);
	}
	
	public static void menuToDs() {
		menu.setVisible(false);
		f.setContentPane(ds);
		ds.setVisible(true);
	}
	
	public static void dsToMenu() {
		ds.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	public static void mpToDeleg() {
		mp.setVisible(false);
		f.setContentPane(deleg);
		deleg.setVisible(true);
	}
	
	public static void delegToMp() {
		deleg.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void mpToEnt() {
		mp.setVisible(false);
		f.setContentPane(ent);
		ent.setVisible(true);
	}
	
	public static void entToMp() {
		ent.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void mpToCom() {
		mp.setVisible(false);
		f.setContentPane(com);
		com.setVisible(true);
	}
	
	public static void comToMp() {
		com.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void mpToBat() {
		mp.setVisible(false);
		f.setContentPane(bat);
		bat.setVisible(true);
	}
	
	public static void batToMp() {
		bat.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void mpToFa() {
		mp.setVisible(false);
		f.setContentPane(fa);
		fa.setVisible(true);
	}
	
	public static void faToMp() {
		fa.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void mpToPm() {
		mp.setVisible(false);
		f.setContentPane(pm);
		pm.setVisible(true);
	}
	
	public static void pmToMp() {
		pm.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void comToMenu() {
		com.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	public static String getMail() {
		return mailAccount;
	}
	
	public static void setMail(String mail) {
		mailAccount=mail;
	}


}

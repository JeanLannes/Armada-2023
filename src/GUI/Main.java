package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.RootPaneContainer;

public class Main {

	static JFrame f = new JFrame();
	static Welcoming wel = new Welcoming();
	static SignIn si = new SignIn();
	static Menu menu = new Menu();
	static FindParticipant fp = new FindParticipant();
	static ModifyParticipant mp = new ModifyParticipant();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Creation de la frame
					f.setTitle("ARMADA 2023");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setBounds(100, 100, 1080, 720);
					f.setResizable(false);
					f.setVisible(true);
					f.setContentPane(wel);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void welToSi() {
		wel.setVisible(false);
		f.setContentPane(si);
		si.setVisible(true);
	}
	
	public static void siToWel() {
		si.setVisible(false);
		f.setContentPane(wel);
		wel.setVisible(true);
	}
	
	public static void welToMenu() {
		wel.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	public static void menuToWel() {
		menu.setVisible(false);
		f.setContentPane(wel);
		wel.setVisible(true);
	}
	
	public static void menuToFp() {
		menu.setVisible(false);
		f.setContentPane(fp);
		fp.setVisible(true);
	}
	
	public static void fpToMenu() {
		fp.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
	public static void fpToMp() {
		fp.setVisible(false);
		f.setContentPane(mp);
		mp.setVisible(true);
	}
	
	public static void fmToMenu() {
		mp.setVisible(false);
		f.setContentPane(menu);
		menu.setVisible(true);
	}
	
}

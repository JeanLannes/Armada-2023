package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Welcoming extends JPanel {

	private JTextField tfPassword;
	private JTextField tfId;
	private String userText;
	private String pwdText;

	public Welcoming() {
		this.setLayout(null);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		add(lblArmada);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		add(lblEsigelec);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(200, 239, 72, 67);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		add(lblId);
		
		JLabel lblPassword = new JLabel("MDP :");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblPassword.setBounds(200, 326, 96, 67);
		add(lblPassword);
		
		JButton btnLogIn = new JButton("SE CONNECTER");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* 
				 *  A MODIFIER : CETTE METHODE SE DECLANCHE LORSQUE QU'ON CLIQUE SUR LE BOUTON <<SE CONNECTER>>
				 */
				
	            userText = tfId.getText();
	            pwdText = tfPassword.getText();
	
	            if (verifytf()) {
	            
		            /*
		             * 		CETTE CONDITION EST UN TEST POUR ACCEDER AU RESTE DE L'APPLI 
		             * 			/!\ C'EST ICI QU'IL FAUT SE CONNECTER A LA BDD /!\
		             * 		ON DOIT VERIFIER SI LES INFOS CORRESPONDENT A UN COMPTE DANS LA BDD 
		             */
		            if (userText.equalsIgnoreCase("tom") && pwdText.equalsIgnoreCase("12345")) {
		            	
		                change(1);	//AFFICHE LE MENU
		  
		            } else {
		            	reject();
		            }
	            }
	            
			}
		});
		btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLogIn.setBounds(200, 505, 200, 50);
		add(btnLogIn);
		
		JButton btnLeave = new JButton("QUITTER");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLeave.setBounds(666, 505, 200, 51);
		add(btnLeave);
		
		JButton btnSignIn = new JButton("S'INSCRIRE");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2);
			}
		});
		btnSignIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnSignIn.setBounds(433, 505, 200, 51);
		add(btnSignIn);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(306, 326, 560, 50);
		add(tfPassword);
		tfPassword.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(306, 239, 560, 50);
		add(tfId);
		tfId.setColumns(10);
	}
	
	protected void reject() {
		JOptionPane.showMessageDialog(this, "ID ou MDP incorrect.");
	}

	/*
	 * Verifie si tout les champs sont remplis 
	 */
	protected boolean verifytf() {
        if (!userText.isEmpty() && !pwdText.isEmpty())
        	return true;
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/*
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change(int i) {
		if (i==1)
			Main.welToMenu();
		if (i==2)
			Main.welToSi();
	}
}

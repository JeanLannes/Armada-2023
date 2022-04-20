package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcoming extends JFrame {

	protected static final Container frame = null;
	private JPanel contentPane;
	private JTextField tfPassword;
	private JTextField tfId;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcoming frmWelcoming = new Welcoming();
					frmWelcoming.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcoming() {
		setTitle("ARMADA 2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		contentPane.add(lblArmada);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		contentPane.add(lblEsigelec);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(200, 239, 72, 67);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("MDP :");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblPassword.setBounds(200, 326, 96, 67);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("SE CONNECTER");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userText;
	            String pwdText;
	            userText = tfId.getText();
	            pwdText = tfPassword.getText();
	            if (userText.equalsIgnoreCase("tom") && pwdText.equalsIgnoreCase("12345")) {
	                JOptionPane.showMessageDialog(contentPane, this, "Login Successful", 0);
	                contentPane.setVisible(false);
	                SignIn si = new SignIn();
	                si.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(contentPane, this, "Invalid Username or Password", 0);
	            }
			}
		});
		btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLogIn.setBounds(200, 505, 200, 50);
		contentPane.add(btnLogIn);
		
		JButton btnLeave = new JButton("QUITTER");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLeave.setBounds(666, 505, 200, 51);
		contentPane.add(btnLeave);
		
		JButton btnSignIn = new JButton("S'INSCRIRE");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn(); 
				contentPane.add(signIn);
			}
		});
		btnSignIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnSignIn.setBounds(433, 505, 200, 51);
		contentPane.add(btnSignIn);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(306, 326, 560, 50);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(306, 239, 560, 50);
		contentPane.add(tfId);
		tfId.setColumns(10);
	}
}

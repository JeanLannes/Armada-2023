package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import dao.CompteDAO;
import dao.InscriptionDAO;
import dao.ParticipantDAO;
import dao.PersonneDAO;
import model.Compte;
import model.Inscription;
import model.Participant;
import model.Personne;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ListOfIncriptionGUI extends JPanel {
	private JButton btnReturn;
	private static JLabel lblMessageCsl;
	private JTable table;
	private static String[][] data;
	private static String mail=null;
	private static int emplacement=0;

	public ListOfIncriptionGUI() {
		setLayout(null);
		
		//LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//LOGO ARMADA
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	
		//MESSAGE DU MODE CONSULTER
		lblMessageCsl = new JLabel("VOICI LA LISTE DES INSCRIPTIONS");
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageCsl.setBounds(200, 211, 673, 38);
		

		//CREATION DU PANEL CONTENANT LA TABLE
        JPanel panel = new JPanel();
        panel.setBounds(188, 276, 737, 219);
        panel.setLayout(null);
        
		//CREATION DES TITRES DE COLONNES  
		String[] column = {"Nom", "Prénom", "Mail", "Activité"};
		data = new String[InscriptionDAO.getSize()][4];
		//IMPORTATION DES INFOS DANS LA BDD
		data=dataEdit(data);
		//CREATION DE LA TABLE DE DONNEES 
		table = new JTable(data, column);
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.gray);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		//CREATION DE LA SCROLL BAR
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(98, 0, 541, 219);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		//BOUTON <<RETOUR>>
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		
		//BOUTON <<CREER>>
		JButton btnCreate = new JButton("CREER");
        btnCreate.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        btnCreate.setBounds(288, 530, 200, 51);
        btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CREATION D'UN COMPTE
				Compte cpt = new Compte();
				cpt.setId(CompteDAO.getMaxID()+1);
				cpt.setMail(data[table.getSelectedRow()][2]);
				cpt.setPasssword(generatePW());
				CompteDAO.add(cpt);
				//CREATION D'UN PARTICIPANT
				Participant part = new Participant();
				part.setIdParticipant(cpt.getId());
				part.setProfil(data[table.getSelectedRow()][3]);
				ParticipantDAO.add(part);
				//CREATION D'UNE PERSONNE
				Personne pers = new Personne();
				pers.setId(cpt.getId());
				PersonneDAO.add(pers);
				//RETOUR AU MENU
				JOptionPane.showMessageDialog(btnCreate, "SUCCES : La candidature a été acceptée.");
				change();
			}
		});
		
		//AJOUTER LES ELEMENTS GRAPHIQUES
		panel.add(pane);
		add(lblEsigelec);
		add(lblArmada);
		add(btnReturn);
		add(lblMessageCsl);	
        add(panel);        
        add(btnCreate);
	}

	/**
	 * Permet d'éditer les valeurs du tableau lié à la table
	 * @param data 
	 * @return String[][] tableau avec les valeurs 
	 */
	protected String[][] dataEdit(String[][] data){
		int j=0;
		for(int i=0; i<InscriptionDAO.getMaxID(); i++) {
			Inscription insc = new Inscription();
			insc=InscriptionDAO.get(i+1);
			if (insc.getId()!=0) {
				data[j][0]=insc.getLastName();
				data[j][1]=insc.getFirstName();
				data[j][2]=insc.getMail();
				data[j][3]=insc.getActivity();
				j++;
			}
		}
		return data;
	}


	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param i
	 */
	protected void change() {
			Main.listIToMenu();
	}
	
	/**
	 * Retourne les mails
	 * @return String
	 */
	protected static String getMail() {
		return mail;
	}
	
	/**
	 * défini les mails
	 * @param String
	 */
	protected static void setMail(String mailbis) {
		mail=mailbis;
	}
	
	/**
	 * Retourne un mot de passe généré aléatoirement
	 * @return String
	 */
	protected static String generatePW() {
		String pw = "0";
		for (int i=0; i<10; i++) {
			Random r = new Random();
		    int n = r.nextInt(9);
		    pw = pw + n;
		}
		return pw;
	}
}

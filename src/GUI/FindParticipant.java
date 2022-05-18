package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import dao.CompteDAO;
import model.Compte;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class FindParticipant extends JPanel {
	private JButton btnConfirm;
	private JButton btnReturn;
	private static JLabel lblMessageMdf;
	private static JLabel lblMessageDlt;
	private static JLabel lblMessageCsl;
	private static JLabel lblMessageEmp;
	private JTable table;
	private static String[][] data;
	private static String mail=null;
	private static int emplacement=0;

	public FindParticipant() {
		setLayout(null);
		
		//LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//LOGO ARMADA
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	
		//MESSAGE DU MODE MODIFIER
		lblMessageMdf = new JLabel("A QUEL PARTICIPANT SOUHAITEZ-VOUS MODIFIER ?");
		lblMessageMdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageMdf.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageMdf.setBounds(200, 211, 673, 38);

		//MESSAGE DU MODE SUPPRIMER
		lblMessageDlt = new JLabel("QUEL PARTICIPANT SOUHAITEZ-VOUS SUPPRIMER ?");
		lblMessageDlt.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageDlt.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageDlt.setBounds(200, 211, 673, 38);

		//MESSAGE DU MODE CONSULTER
		lblMessageCsl = new JLabel("QUEL PROFIL SOUHAITEZ-VOUS CONSULTER ?");
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageCsl.setBounds(200, 211, 673, 38);
		
		//MESSAGE DU MODE ATTRIBUER UN EMPLACEMENT
        lblMessageEmp = new JLabel("EMPLACEMENT");
        lblMessageEmp.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessageEmp.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
        lblMessageEmp.setBounds(200, 211, 673, 38);

		//CREATION DU PANEL CONTENANT LA TABLE
        JPanel panel = new JPanel();
        panel.setBounds(188, 276, 737, 219);
        panel.setLayout(null);
        
		//CREATION DES TITRES DE COLONNES  
		String[] column = {"MAIL"};
		data = new String[CompteDAO.getSize()][1];
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
		
		//BOUTON VALIDER
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.setBounds(287, 530, 200, 51);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (emplacement==0)
					change(2);
				else 
					change(3);
			}
		});
		
		//BOUTON RETOUR
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		
		//AJOUTER LES ELEMENTS GRAPHIQUES
		panel.add(pane);
		add(lblEsigelec);
		add(lblArmada);
		add(btnConfirm);
		add(btnReturn);
		add(lblMessageMdf);
		add(lblMessageDlt);
		add(lblMessageCsl);	
		add(lblMessageEmp);
        add(panel);        
	}

	/**
	 * Permet d'éditer les valeurs du tableau lié à la table
	 * @param data 
	 * @return String[][] tableau avec les valeurs 
	 */
	protected String[][] dataEdit(String[][] data){
		int j=0;
		for(int i=0; i<CompteDAO.getMaxID(); i++) {
			Compte cpt = new Compte();
			cpt=CompteDAO.get(i+1);
			if (cpt.getMail()!="0") {
				data[j][0]=cpt.getMail();
				j++;
			}
		}
		return data;
	}


	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param i
	 */
	protected void change(int i) {
		if (i==1)
			Main.fpToMenu();
		if (i==2) {
			Main.fpToMp();
			Compte cpt = new Compte();
			cpt=CompteDAO.getWithMail(data[table.getSelectedRow()][0]);
			setMail(data[table.getSelectedRow()][0]);
			EditParticipant.showUpdateProfile(cpt.getId());
		}
		if (i==3) {
			Main.fpToEmp();
			Compte cpt = new Compte();
			cpt=CompteDAO.getWithMail(data[table.getSelectedRow()][0]);
			setMail(data[table.getSelectedRow()][0]);
			EmplacementGUI.showUpdateProfile(cpt.getId());
		}
	}
	
	/**
	 * Permet d'adapter le design de la page en fonction de l'action souhaitÃ©e par l'admin
	 * @param i
	 */
	protected static void changeIndex(int i) {
		if (i==1) {
			lblMessageMdf.setVisible(true);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
			lblMessageEmp.setVisible(false);
			emplacement=0;
		}
		if (i==2) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(true);
			lblMessageCsl.setVisible(false);
			lblMessageEmp.setVisible(false);
			emplacement=0;
		}
		if (i==3) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(true);
			lblMessageEmp.setVisible(false);
			emplacement=0;
		}
		if (i==4) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
			lblMessageEmp.setVisible(true);
			emplacement=1;
		}
	}
	
	protected static String getMail() {
		return mail;
	}
	
	protected static void setMail(String mailbis) {
		mail=mailbis;
	}
}

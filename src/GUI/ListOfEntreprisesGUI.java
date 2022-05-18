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
import dao.EntrepriseDAO;
import model.Entreprise;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ListOfEntreprisesGUI extends JPanel {
	private JButton btnReturn;
	private static JLabel lblMessageCsl;
	private JTable table;
	private static String[][] data;
	private static String mail=null;
	private static int emplacement=0;

	public ListOfEntreprisesGUI() {
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
		lblMessageCsl = new JLabel("VOICI LA LISTE DES PARTENAIRES");
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageCsl.setBounds(200, 211, 673, 38);
		

		//CREATION DU PANEL CONTENANT LA TABLE
        JPanel panel = new JPanel();
        panel.setBounds(188, 276, 737, 219);
        panel.setLayout(null);
        
		//CREATION DES TITRES DE COLONNES  
		String[] column = {"COMMERCANTS"};
		data = new String[EntrepriseDAO.getSize()][1];
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

		
		//BOUTON RETOUR
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		
		//AJOUTER LES ELEMENTS GRAPHIQUES
		panel.add(pane);
		add(lblEsigelec);
		add(lblArmada);
		add(btnReturn);
		add(lblMessageCsl);	
        add(panel);        
	}

	/**
	 * Permet d'éditer les valeurs du tableau lié à la table
	 * @param data 
	 * @return String[][] tableau avec les valeurs 
	 */
	protected String[][] dataEdit(String[][] data){
		int j=0;
		for(int i=0; i<EntrepriseDAO.getMaxID(); i++) {
			Entreprise ent = new Entreprise();
			ent=EntrepriseDAO.get(i+1);
			if (ent.getName()!="0") {
				data[j][0]=ent.getName();
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
			Main.listToWel();
	}
	
	protected static String getMail() {
		return mail;
	}
	
	protected static void setMail(String mailbis) {
		mail=mailbis;
	}
}

package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import dao.CompteDAO;
import dao.PersonneDAO;
import model.Compte;
import model.Personne;

import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FindParticipant extends JPanel {
	private JButton btnConfirm;
	private JButton btnReturn;
	private static JLabel lblMessageMdf;
	private static JLabel lblMessageDlt;
	private static JLabel lblMessageCsl;
	private JTable table;

	public FindParticipant() {
		setLayout(null);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.setBounds(287, 530, 200, 51);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2);
			}
		});
		
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		
		lblMessageMdf = new JLabel("QUEL PARTICIPANT SOUHAITEZ-VOUS MODIFIER ?");
		lblMessageMdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageMdf.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageMdf.setBounds(200, 211, 673, 38);

		lblMessageDlt = new JLabel("QUEL PARTICIPANT SOUHAITEZ-VOUS SUPPRIMER ?");
		lblMessageDlt.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageDlt.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageDlt.setBounds(200, 211, 673, 38);

		lblMessageCsl = new JLabel("QUEL PROFIL SOUHAITEZ-VOUS CONSULTER ?");
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageCsl.setBounds(200, 211, 673, 38);

		String[][] data;
		data = new String[CompteDAO.getMaxID()][3];    
		String column[]={"NOM","PRENOM","MAIL"};
		//data=dataEdit(data);
		
		table = new JTable(data, column);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(200, 276, 648, 219);
		add(table);	

		
		//AJOUTER LES ELEMENTS GRAPHIQUES
		add(lblEsigelec);
		add(lblArmada);
		add(btnConfirm);
		add(btnReturn);
		add(lblMessageMdf);
		add(lblMessageDlt);
		add(lblMessageCsl);
		
		/*
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		add(js);
		*/
	}
	
	/*
	private String[][] dataEdit(String[][] data) {
		Compte cpt= new Compte();
		Personne per = new Personne();
		for(int i=0;i<CompteDAO.getMaxID();i++) {
			for(int j=0; j<3; j++) {
				cpt=CompteDAO.get(i);
				per=PersonneDAO.get(i);
				if(j==0)
					data[i][j]=per.getFirstName();
				if(j==1)
					data[i][j]=per.getLastName();
				if(j==2)
					data[i][j]=cpt.getMail();
			}
		}
		return data;
	}
	*/
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param i
	 */
	protected void change(int i) {
		if (i==1)
			Main.fpToMenu();
		if (i==2) {
			Main.fpToMp();
			
			
			//RECUPER L'ID !!!!!!!!!
			
			
			EditParticipant.showUpdateProfile(105);
		}
	}
	
	/**
	 * Permet d'adapter le design de la page en fonction de l'action souhaitée par l'admin
	 * @param i
	 */
	protected static void changeIndex(int i) {
		if (i==1) {
			lblMessageMdf.setVisible(true);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
		}
		if (i==2) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(true);
			lblMessageCsl.setVisible(false);
		}
		if (i==3) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(true);
		}
	}
}

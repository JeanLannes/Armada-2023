package GUI; 

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BoatDAO;
import dao.BoaterDAO;
import dao.CompteDAO;
import dao.ParticipantDAO;
import dao.RetailerDAO;
import model.Boat;
import model.Boater;
import model.Compte;
import model.Participant;
import model.Personne;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class BoaterGUI extends JPanel {
	private static JComboBox cbEnd;
	private static JComboBox cbStart;
	private static int index=0;
	
	public BoaterGUI() {
		setLayout(null);

		//AJOUT DU LOGO ARMADA2023
		JLabel lblArmada = new JLabel("ARMADA 2023");	
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);

		//AJOUT DU LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");	
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);

		//AJOUT DU BOUTON <<VALIDER>>
		JButton btnAdd = new JButton("VALIDER");		
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (index==0) {
					if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
						//CONVERSION DES DATES
						String dateS = cbStart.getSelectedItem().toString() + "/06/23";
						String dateE = cbEnd.getSelectedItem().toString() + "/06/23";
					    //CREATION D'UN COMMERCANT DANS LA BDD
		            	Boater btr = new Boater(BoaterDAO.getMaxID()+1, dateS, dateE);
		            	BoaterDAO.add(btr);
		            	//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            ParticipantDAO.setConnexion(cpt.getId(), 7, btr.getId()); 
			            change();
			            JOptionPane.showMessageDialog(btnAdd, "SUCCES : La réservation a bien été prise en compte.");
		            }
				} else {
					unblockBoater();
					change();
					index=0;
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		//AJOUT DU BOUTON <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");	
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		//AJOUT DU TEXTE DEBUT DE LA RESERVATION
		JLabel lblStart = new JLabel("DEBUT DE LA RESERVATION :");
		lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblStart.setBounds(200, 202, 422, 67);
		
		//AJOUT DE LA COMBOBOX DEBUT DE LA RESERVATION
		String[] tab = {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
		cbStart = new JComboBox(tab);
		cbStart.setSelectedIndex(10);
		cbStart.setBounds(634, 226, 54, 32);
		
		//AJOUT DU Ier JUIN 2023
		JLabel lblJuinStart = new JLabel("JUIN 2023");
		lblJuinStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblJuinStart.setBounds(698, 202, 168, 67);
		
		//AJOUT DU TEXTE FIN DE LA RESERVATION
		JLabel lblEnd = new JLabel("FIN DE LA RESERVATION :");
		lblEnd.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblEnd.setBounds(200, 279, 422, 67);
		add(lblEnd);
		
		//AJOUT DE LA COMBOBOX FIN DE LA RESERVATION
		cbEnd = new JComboBox(tab);
		cbEnd.setSelectedIndex(10);
		cbEnd.setBounds(634, 303, 54, 32);
		
		//AJOUT DU IIeme JUIN 2023
		JLabel lblJuinEnd = new JLabel("JUIN 2023");
		lblJuinEnd.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblJuinEnd.setBounds(698, 279, 168, 67);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(btnAdd);
		add(btnReturn);
		add(lblStart);
		add(cbStart);
		add(lblJuinStart);
		add(cbEnd);
		add(lblJuinEnd);
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
		if (Integer.parseInt(cbStart.getSelectedItem().toString())<=Integer.parseInt(cbEnd.getSelectedItem().toString())) {	
				return true;
		}
        JOptionPane.showMessageDialog(this, "La date de depart doit etre avant celle d'arrivee.");
        return false;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change() {
		Main.btrToMenu();
	}
	

	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockBoater() {
		cbEnd.setEditable(false);
		cbStart.setEditable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockBoater() {
		cbEnd.setEditable(true);
		cbStart.setEditable(true);
	}

	
	/**
	 * Permet de mettre Ã  jour la page Bateau avec les informations importÃ©s 
	 * @param Participant
	 */ 
	public static void showUpdateProfile() {
		//AJOUT DE L'OBJET PLAISANCIER
		Compte cpt = new Compte();
		cpt=CompteDAO.getWithMail(Main.getMail());
		Participant part = new Participant();
		Boater boater = new Boater();
		//IMPORTATION DES DONNEES 
		boater=BoaterDAO.get(part.getIdPlaisancier());
		String dateS=boater.getHorraireDep().substring(0, 2);
		String dateE=boater.getHorraireArr().substring(0, 2);
		
		cbStart.setSelectedItem(dateS);
		cbEnd.setSelectedItem(dateE);
		//BLOCAGE DES INFOS
			blockBoater();
	}
}

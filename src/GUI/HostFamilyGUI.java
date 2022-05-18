package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.AddressDAO;
import dao.CompteDAO;
import dao.HostFamilyDAO;
import dao.ParticipantDAO;
import model.Address;
import model.Compte;
import model.HostFamily;
import model.Participant;

public class HostFamilyGUI extends JPanel {

	private static JTextField tfAddress;
	private static JTextField tfNumber;
	
	public HostFamilyGUI() {
		setLayout(null);

		//AJOUT DU LOGO ARMADA2023
		JLabel lblArmada = new JLabel("ARMADA 2023");	
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		//AJOUT DU LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");	
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		//AJOUT DU TEXTE MDP
		JLabel lblActivity = new JLabel("ADRESSE :");	
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(200, 296, 156, 67);
		
		//AJOUT DU BOUTON <<VALIDER>>
		JButton btnAdd = new JButton("VALIDER");		
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (EditParticipant.getIndex()==4 || EditParticipant.getIndex()==3) {	// CONSULTATION
					change(1);
				} else if (EditParticipant.getIndex()==0 || EditParticipant.getIndex()==1) {	//MODIFICATION
					if (verify()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
			            //CREATION D'UN COMMERCANT DANS LA BDD
						AddressDAO.add(new Address(AddressDAO.getMaxID()+1, tfAddress.getText().toString()));
		            	HostFamily hf = new HostFamily(HostFamilyDAO.getMaxID()+1, tfAddress.getText().toString(), Integer.parseInt(tfNumber.getText().toString()));
		            	HostFamilyDAO.add(hf, AddressDAO.getMaxID());
		            	//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            ParticipantDAO.setConnexion(cpt.getId(), 4, hf.getIdFamily());	
		            	EditParticipant.closeEditParticipant();
		            	Menu.block();
		            }
				} else if (EditParticipant.getIndex()==2) {					
					if (verify()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
						//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            Participant part = new Participant();
			            ParticipantDAO.get(cpt.getId());
						//SUPPRESION D'UN COMMERCANT DANS LA BDD
		            	//HostFamilyDAO.delete(part.getIdRetailer());
		            	EditParticipant.closeEditParticipant();
		            	Menu.block();
					}
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		//AJOUT DU BOUTON <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");	
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		// CHAMP DE TEXTE ADRESSE
		tfAddress = new JTextField();
		tfAddress.setBounds(366, 301, 500, 50);
		tfAddress.setColumns(10);
		
		// CHAMP DE TEXTE NOMBRE DE PLACE
		tfNumber = new JTextField();
		tfNumber.setColumns(10);
		tfNumber.setBounds(506, 366, 360, 50);
		
		// TEXTE NOMBRE DE PLACE
		JLabel lblNumber = new JLabel("NOMBRE DE PLACE :");
		lblNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblNumber.setBounds(200, 361, 306, 67);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblActivity);
		add(btnAdd);
		add(btnReturn);
		add(tfAddress);
		add(tfNumber);
		add(lblNumber);
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @hfurn boolean
	 */
	protected boolean verify() {
        String address = tfAddress.getText();
        String nbr = tfNumber.getText();
		if (!address.isEmpty() && !nbr.isEmpty()) {	
				return true;
		}
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change(int i) {
		if (i==0)
			Main.faToMp();
		else if (i==1)
			Main.faToMenu();
	}
	
	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockHostFamily() {
		tfAddress.setEditable(false);
		tfNumber.setEditable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockHostFamily() {
		tfAddress.setEditable(true);
		tfNumber.setEditable(true);
	}

	/**
	 * Permet de mettre à jour la page Commerçant avec les informations importés 
	 * @param Participant
	 */
	public static void showUpdateProfile(Participant part) {
		//AJOUT DE L'OBJET hostfamily 
		HostFamily hf = new HostFamily();
		hf=HostFamilyDAO.get(part.getIdFamille());
		//IMPORTATION DES DONNEES 
		tfAddress.setText(hf.getAddress());
		tfNumber.setText(Integer.toString(hf.getNbPlace()));
	}

}

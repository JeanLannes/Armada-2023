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
import dao.CompteDAO;
import dao.ParticipantDAO;
import dao.RetailerDAO;
import model.Boat;
import model.Compte;
import model.Participant;
import model.Personne;
import javax.swing.SwingConstants;

public class BoatGUI extends JPanel {

	private static JTextField tfFlag;
	private static JTextField tfCaptain;
	private static JTextField tfName;
	private static JTextField tfLengh;
	private static JTextField tfDate;
	private static JTextField tfType;
	private static JTextField tfImmatriculation;
	
	public BoatGUI() {
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
		JLabel lblActivity = new JLabel("PAVILLON :");	
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(200, 322, 161, 67);

		//AJOUT DU BOUTON <<CREER>>
		JButton btnAdd = new JButton("VALIDER");		
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	            if (EditParticipant.getIndex()==4) {	// CONSULTATION
					change(1);
				} else if (EditParticipant.getIndex()==0 || EditParticipant.getIndex()==1) {	//MODIFICATION
					if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
			            //CREATION D'UN COMMERCANT DANS LA BDD
		            	Boat boat = new Boat(BoatDAO.getMaxID()+1, tfName.getText(),Integer.parseInt(tfLengh.getText()), tfFlag.getText(), tfCaptain.getText(), tfImmatriculation.getText(), tfType.getText(), tfDate.getText());
		            	BoatDAO.add(boat);
		            	//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            ParticipantDAO.setConnexion(cpt.getId(), 1, boat.getIdBoat());	
		            	EditParticipant.closeEditParticipant();
		            	Menu.block();
		            	JOptionPane.showMessageDialog(btnAdd, "SUCCES : Le compte a été modifié.");
		            }
				} else if (EditParticipant.getIndex()==2) {					
				if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
					//LIAISON DU COMMERCANT AU PARTICIPANT
	            	Compte cpt= new Compte();
		            cpt=CompteDAO.getWithMail(Main.getMail());
		            Participant part = new Participant();
		            part = ParticipantDAO.get(cpt.getId());
					//SUPPRESION D'UN COMMERCANT DANS LA BDD
	            	BoatDAO.delete(part.getIdBoat());
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
		
		//AJOUT DU CHAMP DE TEXTE FLAG
		tfFlag = new JTextField();
		tfFlag.setBounds(381, 322, 96, 50);
		tfFlag.setColumns(10);
		
		//AJOUT DU DU CHAMP DE TEXTE CAPITAINE
		tfCaptain = new JTextField();
		tfCaptain.setColumns(10);
		tfCaptain.setBounds(381, 392, 485, 50);
		
		//AJOUT DU TEXTE IMMATRICULATION
		JLabel lblImmatriculation = new JLabel("CAPITAINE :");
		lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblImmatriculation.setBounds(200, 387, 180, 67);
		
		//AJOUT DU TEXTE NOM
		JLabel lblNom = new JLabel("NOM :");
		lblNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblNom.setBounds(200, 188, 156, 67);
		
		//AJOUT DU CHAMP DE TEXTE NOM
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(381, 193, 165, 50);
		
		//AJOUT DU CHAMP DE TEXTE TAILLE
		tfLengh = new JTextField();
		tfLengh.setColumns(10);
		tfLengh.setBounds(381, 258, 165, 50);
		
		//AJOUT DU TEXTE TAILLE
		JLabel lblTaille = new JLabel("TAILLE :");
		lblTaille.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblTaille.setBounds(200, 253, 156, 67);
		
		//AJOUT DU CHAMP DE TEXTE DATE
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(686, 258, 180, 50);
		
		//AJOUT DU CHAMP DE TEXTE TYPE
		tfType = new JTextField();
		tfType.setColumns(10);
		tfType.setBounds(686, 193, 180, 50);
		
		//AJOUT DU TEXTE TYPE
		JLabel lblType = new JLabel("TYPE :");
		lblType.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblType.setBounds(558, 188, 102, 67);
		
		//AJOUT DU TEXTE DATE
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblDate.setBounds(556, 250, 122, 67);

		//AJOUT DU TEXTE IMMATRICULATION
		lblImmatriculation = new JLabel("IMMATRICULATION :");
		lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblImmatriculation.setBounds(487, 322, 310, 67);
		
		//AJOUT DU CHAMP DE TEXTE IMMATRICULATION
		tfImmatriculation = new JTextField();
		tfImmatriculation.setColumns(10);
		tfImmatriculation.setBounds(781, 327, 85, 50);

		//AJOUT DU TEXTE CAPITAINE
		JLabel lblCaptain = new JLabel("CAPITAINE :");
		lblCaptain.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCaptain.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblCaptain.setBounds(200, 388, 170, 67);
		
		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblActivity);
		add(btnAdd);
		add(btnReturn);
		add(tfFlag);
		add(tfCaptain);
		add(lblImmatriculation);
		add(lblNom);
		add(tfName);
		add(tfLengh);
		add(lblTaille);
		add(tfDate);
		add(tfType);
		add(lblType);
		add(lblDate);
		add(lblImmatriculation);
		add(tfImmatriculation);		
		add(lblCaptain);
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
		String captain = tfCaptain.getText();
        String name = tfName.getText();
        String lengh = tfLengh.getText();
        String date = tfDate.getText();
        String type = tfType.getText();
        String immatriculation = tfImmatriculation.getText();
        String flag = tfFlag.getText();
		if (!captain.isEmpty() && !name.isEmpty() && !lengh.isEmpty() && !date.isEmpty() && !type.isEmpty() && !immatriculation.isEmpty() && !flag.isEmpty()) {	
				return true;
		}
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change(int i) {
		if (i==1) 
			Main.batToMenu();
		else
			Main.batToMp();
	}
	
	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockBoat() {
		tfFlag.setEditable(false);
		tfCaptain.setEditable(false);
		tfName.setEditable(false);
		tfLengh.setEditable(false);
		tfDate.setEditable(false);
		tfType.setEditable(false);
		tfImmatriculation.setEditable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockBoat() {
		tfFlag.setEditable(true);
		tfCaptain.setEditable(true);
		tfName.setEditable(true);
		tfLengh.setEditable(true);
		tfDate.setEditable(true);
		tfType.setEditable(true);
		tfImmatriculation.setEditable(true);
	}

	/**
	 * Permet de mettre à jour la page Bateau avec les informations importés 
	 * @param Participant
	 */ 
	public static void showUpdateProfile(Participant part) {
		//AJOUT DE L'OBJET BATEAU 
		Boat boat = new Boat();
		boat=BoatDAO.get(part.getIdBoat());
		//IMPORTATION DES DONNEES 
		tfFlag.setText(boat.getFlag());
		tfCaptain.setText(boat.getCaptain());
		tfName.setText(boat.getName());
		tfLengh.setText(Integer.toString(boat.getLengh()));
		tfDate.setText(boat.getDate());
		tfType.setText(boat.getType());
		tfImmatriculation.setText(boat.getImmatriculation());
	}
}

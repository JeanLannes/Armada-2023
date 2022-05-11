package GUI; 

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Compte;
import model.Participant;
import model.Personne;
import javax.swing.JTextField;

public class EntrepriseGUI extends JPanel {
	private static JTextField tfName;
	private static JTextField tfImmatriculation;

	public EntrepriseGUI() {
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
		JLabel lblName = new JLabel("NOM :");	
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblName.setBounds(400, 296, 86, 67);
		
		//AJOUT DU BOUTON <<VALIDER>>
		JButton btnAdd = new JButton("VALIDER");		
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	            Compte cpt=null;
	            Personne per=null;
	            if (verifytf()) {	

	            	//CREATION D'UNE ENTREPRISE DANS LA BDD
	            	Entreprise ent = new Entreprise(EntrepriseDAO.getMaxID()+1, tfName.getText().toString(), tfImmatriculation.getText().toString());
	            	EntrepriseDAO.add(ent);
	            	//LIAISON DE L'ENTREPRISE AU PARTICIPANT
	            	Compte cpt= new Compte();
		            cpt=CompteDAO.getWithMail(Main.getMail());
		            ParticipantDAO.setConnexion(cpt.getId(), 2, ent.getIdEntreprise());	
	            	EditParticipant.closeEditParticipant();
	            	
	            	Menu.block();
		   
	            }
			}
		});
		
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		JButton btnReturn = new JButton("RETOUR");	//AJOUT DU BOUTON SE <<RETOUR>>
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		tfName = new JTextField();
		tfName.setBounds(506, 301, 360, 50);
		tfName.setColumns(10);
		
		tfImmatriculation = new JTextField();
		tfImmatriculation.setColumns(10);
		tfImmatriculation.setBounds(506, 366, 360, 50);
	
		JLabel lblImmatriculation = new JLabel("IMMATRICULATION :");
		lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblImmatriculation.setBounds(200, 361, 286, 67);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblName);
		add(btnAdd);
		add(btnReturn);
		add(tfName);
		add(tfImmatriculation);
		add(lblImmatriculation);		
	}
	
	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
        return true;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param int i Indice permetant de choisir la page a afficher
	 */
	protected void change() {
		Main.addToMenu();
	}

	public static void blockEntreprise() {
		tfName.setEditable(false);
		tfImmatriculation.setEditable(false);
	}

	public static void unblockEntreprise() {
		tfName.setEditable(true);
		tfImmatriculation.setEditable(true);
	}

	public static void showUpdateProfile(Participant part) {
		//AJOUT DE L'OBJET ENTREPRISE 
		Entreprise ent = new Entreprise();
		ent=EntrepriseDAO.get(part.getImEntreprise());
		//IMPORTATION DES DONNEES 
		tfName.setText(ent.getName());
		tfImmatriculation.setText(ent.get());
	}

}

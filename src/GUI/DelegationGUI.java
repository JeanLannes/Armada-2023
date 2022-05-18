package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.CompteDAO;
import dao.DelegationDAO;
import dao.ParticipantDAO;
import model.Compte;
import model.Delegation;
import model.Participant;
import model.Personne;
import javax.swing.JComboBox;

public class DelegationGUI extends JPanel {
	private static JTextField tfcountry;
	
	public DelegationGUI() {
		
		setLayout(null);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		JLabel lblCountry = new JLabel("PAYS :");	//AJOUT DU TEXTE MDP
		lblCountry.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblCountry.setBounds(200, 296, 96, 67);
		
		JButton btnAdd = new JButton("VALIDER");		//AJOUT DU BOUTON <<CREER>>
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (EditParticipant.getIndex()==4 || EditParticipant.getIndex()==3) {	// CONSULTATION
					change(1);
				} else if (EditParticipant.getIndex()==0 || EditParticipant.getIndex()==1) {	//MODIFICATION
					if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
			            //CREATION D'UN COMMERCANT DANS LA BDD
		            	Delegation dlg = new Delegation(DelegationDAO.getMaxID()+1, tfcountry.getText().toString());
		            	DelegationDAO.add(dlg);
		            	//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            ParticipantDAO.setConnexion(cpt.getId(), 5, dlg.getId());	
			            
		            	EditParticipant.closeEditParticipant();
		            	
		            	Menu.block();
		            }
				} else if (EditParticipant.getIndex()==2) {					
					if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
						//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            Participant part = new Participant();
			            ParticipantDAO.get(cpt.getId());
						//SUPPRESION D'UN COMMERCANT DANS LA BDD
		            	DelegationDAO.delete(part.getIdDelegation());
		            	EditParticipant.closeEditParticipant();
		            	Menu.block();
					}
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		JButton btnReturn = new JButton("RETOUR");	//AJOUT DU BOUTON SE <<RETOUR>>
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		tfcountry = new JTextField();
		tfcountry.setColumns(10);
		tfcountry.setBounds(306, 301, 560, 50);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblCountry);
		add(btnAdd);
		add(btnReturn);
		add(tfcountry);
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
	protected void change(int i) {
		if (i==0)
			Main.delegToMp();
		else if (i==1)
			Main.delegToMenu();
	}

	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockDelegation() {
		tfcountry.setEditable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockDelegation() {
		tfcountry.setEditable(true);
	}

	/**
	 * Permet de mettre à jour la page Commerçant avec les informations importés 
	 * @param Participant
	 */
	public static void showUpdateProfile(Participant part) {
		//AJOUT DE L'OBJET RETAILER 
		Delegation dlg = new Delegation();
		dlg=DelegationDAO.get(part.getIdDelegation());
		//IMPORTATION DES DONNEES 
		tfcountry.setText(dlg.getCountry());
	}
}

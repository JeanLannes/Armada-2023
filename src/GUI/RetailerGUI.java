package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.CompteDAO;
import dao.ParticipantDAO;
import dao.RetailerDAO;
import model.Compte;
import model.Participant;
import model.Retailer;

public class RetailerGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField tfActivity;
	private static JTextField tfStand;
	
	public RetailerGUI() {
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
			public void actionPerformed(ActionEvent e) {
				if (EditParticipant.getIndex()==4 || EditParticipant.getIndex()==3) {	// CONSULTATION
					change(1);
				} else if (EditParticipant.getIndex()==0 || EditParticipant.getIndex()==1) {	//MODIFICATION
					if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
			            //CREATION D'UN COMMERCANT DANS LA BDD
		            	Retailer ret = new Retailer(RetailerDAO.getMaxID()+1, tfActivity.getText().toString(), tfStand.getText().toString());
		            	RetailerDAO.add(ret);
		            	//LIAISON DU COMMERCANT AU PARTICIPANT
		            	Compte cpt= new Compte();
			            cpt=CompteDAO.getWithMail(Main.getMail());
			            ParticipantDAO.setConnexion(cpt.getId(), 2, ret.getIdRetailer());	
		            	EditParticipant.closeEditParticipant();
		            	JOptionPane.showMessageDialog(btnAdd, "SUCCES : Le compte a été modifié.");
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
		            	RetailerDAO.delete(part.getIdRetailer());
		            	EditParticipant.closeEditParticipant();
		            	Menu.block();
					}
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		//AJOUT DU BOUTON SE <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");	
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		//AJOUT DU TEXTE MDP
		JLabel lblActivity = new JLabel("ACTIVITE :");	
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(200, 296, 156, 67);
		
		//AJOUT DU CHAMP DE TEXTE ACTIVITE
		tfActivity = new JTextField();
		tfActivity.setBounds(366, 301, 500, 50);
		tfActivity.setColumns(10);
		
		//AJOUT DU CHAMP DE TEXTE STAND
		tfStand = new JTextField();
		tfStand.setColumns(10);
		tfStand.setBounds(366, 366, 500, 50);

		//AJOUT DU TEXTE STAND
		JLabel lblStand = new JLabel("STAND :");
		lblStand.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblStand.setBounds(200, 361, 156, 67);
		add(lblStand);
		
		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblActivity);
		add(btnAdd);
		add(btnReturn);
		add(tfActivity);
		add(tfStand);
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
		String activity = tfActivity.getText();
        String stand = tfStand.getText();
		if (!activity.isEmpty() && !stand.isEmpty()) {	
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
			Main.comToMp();
		else if (i==1)
			Main.comToMenu();
	}
	
	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockRetailer() {
		tfActivity.setEditable(false);
		tfStand.setEditable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockRetailer() {
		tfActivity.setEditable(true);
		tfStand.setEditable(true);
	}

	/**
	 * Permet de mettre à jour la page Commerçant avec les informations importés 
	 * @param Participant
	 */
	public static void showUpdateProfile(Participant part) {
		//AJOUT DE L'OBJET RETAILER 
		Retailer ret = new Retailer();
		ret=RetailerDAO.get(part.getIdRetailer());
		//IMPORTATION DES DONNEES 
		tfActivity.setText(ret.getActivity());
		tfStand.setText(ret.getStand());
	}
}

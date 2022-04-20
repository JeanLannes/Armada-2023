package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Choice;
import javax.swing.JMenu;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JPanel {
	
	public Menu() {
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JButton btnModifierUnParcipant = new JButton("MODIFIER UN PARCIPANT");
		btnModifierUnParcipant.setBounds(200, 266, 664, 39);
		btnModifierUnParcipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnModifierUnParcipant_1 = new JButton("SUPPRIMER UN PARCIPANT");
		btnModifierUnParcipant_1.setBounds(200, 315, 664, 39);
		btnModifierUnParcipant_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnModifierUnParcipant_1_1 = new JButton("\u00C9DITER UN PARCIPANT");
		btnModifierUnParcipant_1_1.setBounds(200, 364, 664, 39);
		btnModifierUnParcipant_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnModifierUnParcipant_1_2 = new JButton("G\u00C9RER UNE INSCRIPTION");
		btnModifierUnParcipant_1_2.setBounds(200, 413, 664, 39);
		btnModifierUnParcipant_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnModifierUnParcipant_1_2_1 = new JButton("ATTRIBUER UN EMPLACEMENT");
		btnModifierUnParcipant_1_2_1.setBounds(200, 462, 664, 39);
		btnModifierUnParcipant_1_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(430, 530, 200, 51);
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		setLayout(null);
	
	}
}

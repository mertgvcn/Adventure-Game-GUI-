package GUI;

import GameProperties.*;
import GameProperties.Character;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	Character c = new Character();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Menu frame = new Login_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Menu() {
		setTitle("Adventure Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAdventureGame = new JLabel("ADVENTURE GAME");
		lblAdventureGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdventureGame.setBounds(117, 34, 205, 34);
		contentPane.add(lblAdventureGame);
		
		JLabel lblWelcome = new JLabel("Welcome to Adventure Game. Please enter your name...");
		lblWelcome.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lblWelcome.setBounds(30, 80, 385, 43);
		contentPane.add(lblWelcome);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Minecraft", Font.PLAIN, 14));
		txtName.setBounds(117, 134, 205, 34);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChaName();
				ChaSelect_Menu csMenu = new ChaSelect_Menu(c);
				csMenu.setVisible(true);
				dispose();
				
			}
		});
		btnStart.setFont(new Font("Minecraft", Font.BOLD, 14));
		btnStart.setBounds(170, 179, 98, 34);
		contentPane.add(btnStart);
	}
	
	public void setChaName() {
		c.setName(txtName.getText());
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import GameProperties.*;
import GameProperties.Character;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChaSelect_Menu extends JFrame {

	private JPanel contentPane;
	static Character c = new Character();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChaSelect_Menu frame = new ChaSelect_Menu(c);
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
	
		
	
	public ChaSelect_Menu(Character c) {
		this.c = c;
		
		setTitle("Character Selection");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBounds(10, 11, 424, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lbl_WarriorIcon = new JLabel("");
		lbl_WarriorIcon.setBounds(10, 107, 75, 82);
		panel.add(lbl_WarriorIcon);
		ImageIcon icon = new ImageIcon("warrior.png");
		//C:/Users/ROMAN/Desktop/eclipse/workshop/AdventureGame/src/GUI/warrior.png
		lbl_WarriorIcon.setIcon(icon);
		
		JTextArea txtWarrior = new JTextArea();
		txtWarrior.setBounds(0, 0, 134, 200);
		txtWarrior.setEditable(false);
		txtWarrior.setBackground(new Color(255, 255, 255));
		txtWarrior.setFont(new Font("Minecraft", Font.BOLD, 15));
		txtWarrior.setText("    Warrior\r\n\r\nATTACK   : 7\r\nHP          : 40\r\nARMOR    : 1\r\nSTAMINA  : 100\r\n\r\n");
		panel.add(txtWarrior);
		
		JLabel lbl_HeavyFighterIcon = new JLabel("");
		lbl_HeavyFighterIcon.setBounds(156, 107, 82, 82);
		panel.add(lbl_HeavyFighterIcon);
		ImageIcon icon2 = new ImageIcon("heavyFighter.png");
		lbl_HeavyFighterIcon.setIcon(icon2);		
		
		JTextArea txtHeavyFighter = new JTextArea();
		txtHeavyFighter.setBounds(145, 0, 134, 200);
		txtHeavyFighter.setEditable(false);
		txtHeavyFighter.setText("  Heavy Fighter\r\n\r\nATTACK   : 3\r\nHP          : 60\r\nARMOR    : 2\r\nSTAMINA  : 70\r\n\r\n");
		txtHeavyFighter.setFont(new Font("Minecraft", Font.BOLD, 15));
		txtHeavyFighter.setBackground(new Color(255, 240, 245));
		panel.add(txtHeavyFighter);
		
		JLabel lbl_ArcherIcon = new JLabel("");
		lbl_ArcherIcon.setBounds(301, 107, 82, 82);
		panel.add(lbl_ArcherIcon);
		ImageIcon icon3 = new ImageIcon("archer.png");
		lbl_ArcherIcon.setIcon(icon3);
		
		JTextArea txtArcher = new JTextArea();
		txtArcher.setBounds(289, 0, 134, 200);
		txtArcher.setText("    Archer\r\n\r\nATTACK   : 11\r\nHP          : 20\r\nARMOR    : 0\r\nSTAMINA  : 130\r\n\r\n");
		txtArcher.setFont(new Font("Minecraft", Font.BOLD, 15));
		txtArcher.setEditable(false);
		txtArcher.setBackground(new Color(224, 255, 255));
		panel.add(txtArcher);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		panel_1.setBounds(10, 221, 424, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 3, 10, 0));
		
		JButton btn_selectWarrior = new JButton("Select Warrior");
		btn_selectWarrior.setFont(new Font("Minecraft" , Font.PLAIN , 14 ));
		btn_selectWarrior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaStats(7,40,1,100);
				startGame();
				c.setChaId(1);
			}
		});
		btn_selectWarrior.setBackground(new Color(222, 184, 135));
		panel_1.add(btn_selectWarrior);
		
		JButton btn_selectHeavyFighter = new JButton("Select Fighter");
		btn_selectHeavyFighter.setFont(new Font("Minecraft" , Font.PLAIN , 14 ));
		btn_selectHeavyFighter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaStats(3,60,2,70);
				startGame();
				c.setChaId(2);
			}
		});
		btn_selectHeavyFighter.setBackground(new Color(222, 184, 135));
		panel_1.add(btn_selectHeavyFighter);
		
		JButton btn_selectArcher = new JButton("Select Archer");
		btn_selectArcher.setFont(new Font("Minecraft" , Font.PLAIN , 14 ));
		btn_selectArcher.setBackground(new Color(222, 184, 135));
		btn_selectArcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaStats(11,20,0,130);
				startGame();
				c.setChaId(3);
			}
		});
		panel_1.add(btn_selectArcher);
		
	}
	
	public void chaStats(int damage , int hp , int armor , int stamina) {
		c.setDamage(damage);
		c.setHp(hp);
		c.setArmor(armor);
		c.setStamina(stamina);
		c.getInv().setCoin(40);
		c.getInv().setHealthPotion(2);
		c.getInv().setStaminaPotion(1);
		c.setFullHp(hp);
		c.setFullStamina(stamina);
		c.setExtraDamage(0);
		c.setExtraArmor(0);
	}
	
	public void startGame() {
		Game_Menu gm = new Game_Menu(c );
		gm.setVisible(true);
		dispose();
	}
}

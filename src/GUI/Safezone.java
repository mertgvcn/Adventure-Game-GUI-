package GUI;

import GameProperties.*;
import GameProperties.Character;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Safezone extends JFrame {

	private JPanel contentPane;
	static Character c = new Character();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Safezone frame = new Safezone(c);
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
	public Safezone(Character c) {
		setType(Type.UTILITY);
		this.c = c;

		setTitle("Safezone");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 82, 45));
		panel.setBounds(20, 11, 264, 150);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 0, 0, 0));

		JLabel lbl_SafezoneRow1 = new JLabel("    Welcome " + c.getName() + "!");
		lbl_SafezoneRow1.setForeground(new Color(0, 0, 0));
		lbl_SafezoneRow1.setBackground(new Color(139, 69, 19));
		lbl_SafezoneRow1.setFont(new Font("Minecraft", Font.BOLD, 15));
		panel.add(lbl_SafezoneRow1);

		JLabel lbl_SafezoneRow2 = new JLabel("There is your safehouse ...");
		lbl_SafezoneRow2.setForeground(new Color(0, 0, 0));
		lbl_SafezoneRow2.setBackground(new Color(139, 69, 19));
		lbl_SafezoneRow2.setFont(new Font("Minecraft", Font.ITALIC, 15));
		panel.add(lbl_SafezoneRow2);

		JLabel lbl_SafezoneRow3 = new JLabel("Here , you can heal your wounds ");
		lbl_SafezoneRow3.setForeground(new Color(0, 0, 0));
		lbl_SafezoneRow3.setBackground(new Color(139, 69, 19));
		lbl_SafezoneRow3.setLocation(0, 186);
		lbl_SafezoneRow3.setFont(new Font("Minecraft", Font.ITALIC, 15));
		panel.add(lbl_SafezoneRow3);

		JLabel lbl_SafezoneRow4 = new JLabel("by using your health pots , and ");
		lbl_SafezoneRow4.setForeground(new Color(0, 0, 0));
		lbl_SafezoneRow4.setBackground(new Color(139, 69, 19));
		lbl_SafezoneRow4.setFont(new Font("Minecraft", Font.ITALIC, 15));
		panel.add(lbl_SafezoneRow4);

		JLabel lbl_SafezoneRow5 = new JLabel("you can recharge your stamina");
		lbl_SafezoneRow5.setForeground(new Color(0, 0, 0));
		lbl_SafezoneRow5.setBackground(new Color(139, 69, 19));
		lbl_SafezoneRow5.setFont(new Font("Minecraft", Font.ITALIC, 15));
		panel.add(lbl_SafezoneRow5);

		JLabel lbl_SafeZoneRow6 = new JLabel("by using your stamina pots ...");
		lbl_SafeZoneRow6.setForeground(new Color(0, 0, 0));
		lbl_SafeZoneRow6.setBackground(new Color(139, 69, 19));
		lbl_SafeZoneRow6.setFont(new Font("Minecraft", Font.ITALIC, 15));
		panel.add(lbl_SafeZoneRow6);

		JLabel lbl_hp = new JLabel("HP : " + c.getHp() + "/" + c.getFullHp());
		lbl_hp.setForeground(new Color(0, 0, 0));
		lbl_hp.setFont(new Font("Minecraft", Font.BOLD, 13));
		lbl_hp.setBounds(294, 11, 127, 26);
		contentPane.add(lbl_hp);

		JLabel lbl_stamina = new JLabel("SP : " + c.getStamina() + "/" + c.getFullStamina());
		lbl_stamina.setForeground(Color.BLACK);
		lbl_stamina.setFont(new Font("Minecraft", Font.BOLD, 13));
		lbl_stamina.setBounds(294, 74, 127, 26);
		contentPane.add(lbl_stamina);

		JLabel lbl_Uyari = new JLabel("");
		lbl_Uyari.setForeground(new Color(0, 0, 0));
		lbl_Uyari.setFont(new Font("Minecraft", Font.BOLD, 13));
		lbl_Uyari.setBounds(20, 234, 248, 26);
		contentPane.add(lbl_Uyari);

		JLabel lbl_HealthPotion = new JLabel("Health Potion    : " + c.getInv().getHealthPotion());
		lbl_HealthPotion.setForeground(new Color(0, 0, 0));
		lbl_HealthPotion.setFont(new Font("Minecraft", Font.PLAIN, 13));
		lbl_HealthPotion.setBounds(294, 38, 140, 26);
		contentPane.add(lbl_HealthPotion);

		JLabel lbl_StaminaPotion = new JLabel("Stamina Potion : " + c.getInv().getStaminaPotion());
		lbl_StaminaPotion.setForeground(new Color(0, 0, 0));
		lbl_StaminaPotion.setFont(new Font("Minecraft", Font.PLAIN, 13));
		lbl_StaminaPotion.setBounds(294, 100, 140, 26);
		contentPane.add(lbl_StaminaPotion);

		JButton btn_useHealthPot = new JButton("Use HealthPot");
		btn_useHealthPot.setForeground(new Color(0, 0, 0));
		btn_useHealthPot.setBackground(new Color(240, 128, 128));
		btn_useHealthPot.setFont(new Font("Minecraft", Font.BOLD, 11));
		btn_useHealthPot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (c.getHp() == c.getFullHp()) {
					lbl_Uyari.setText("Your hp is already full !");
				} else if (c.getInv().getHealthPotion() <= 0) {
					lbl_Uyari.setText("You don't have a health potion !");
				} else {
					c.getInv().setHealthPotion(c.getInv().getHealthPotion() - 1);
					c.setHp(c.getHp() + 20);
					if (c.getHp() > c.getFullHp()) {
						c.setHp(c.getFullHp());
					}
					
					lbl_hp.setText("HP : " + c.getHp() + "/" + c.getFullHp());
					lbl_Uyari.setText("+20 Hp !");
				}

				lbl_HealthPotion.setText("Health Potion    : " + c.getInv().getHealthPotion());
			}
		});
		btn_useHealthPot.setBounds(20, 171, 127, 52);
		contentPane.add(btn_useHealthPot);

		JButton btn_useStaminaPot = new JButton("Use StaminaPot");
		btn_useStaminaPot.setForeground(new Color(0, 0, 0));
		btn_useStaminaPot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (c.getStamina() == c.getFullStamina()) {
					lbl_Uyari.setText("Your stamina is already full !");
				} else if (c.getInv().getStaminaPotion() <= 0) {
					lbl_Uyari.setText("You don't have a stamina potion !");
				} else {
					c.getInv().setStaminaPotion(c.getInv().getStaminaPotion() - 1);
					c.setStamina(c.getStamina() + 40);
					if (c.getStamina() > c.getFullStamina()) {
						c.setStamina(c.getFullStamina());
					}
					lbl_stamina.setText("SP : " + c.getStamina() + "/" + c.getFullStamina());
					lbl_Uyari.setText("+40 Stamina !");
				}

				lbl_StaminaPotion.setText("Stamina Potion : " + c.getInv().getStaminaPotion());
			}
		});
		btn_useStaminaPot.setBackground(new Color(70, 130, 180));
		btn_useStaminaPot.setFont(new Font("Minecraft", Font.BOLD, 11));
		btn_useStaminaPot.setBounds(157, 171, 127, 52);
		contentPane.add(btn_useStaminaPot);

		JButton btn_back = new JButton("BACK");
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.setFont(new Font("Minecraft", Font.BOLD, 11));
		btn_back.setBackground(new Color(119, 136, 153));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game_Menu gm = new Game_Menu(c);
				gm.setVisible(true);
				dispose();
			}
		});

		btn_back.setBounds(361, 225, 73, 35);
		contentPane.add(btn_back);

	}
}

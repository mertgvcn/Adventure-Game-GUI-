package GUI;

import GameProperties.*;
import GameProperties.Character;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Arena extends JFrame {
	
	static Character c = new Character();
	private JPanel contentPane;

	int enemyID = (int) (Math.random() * 10);	
	Obstacle obs = new Obstacle(enemyID);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arena frame = new Arena(c);
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
	public Arena(Character c) {
		this.c = c;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JPanel p_text = new JPanel();
		p_text.setBackground(new Color(143, 188, 143));
		p_text.setBounds(0, 0, 584, 60);
		contentPane.add(p_text);
		p_text.setLayout(null);
		
		JLabel lbl_txtRow1 = new JLabel("   Here, you can fight with random enemies in order to gain some coin. And ,");
		lbl_txtRow1.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_txtRow1.setForeground(Color.BLACK);
		lbl_txtRow1.setBounds(10, 11, 564, 25);
		p_text.add(lbl_txtRow1);
		
		JLabel lbl_txtRow2 = new JLabel("If you die, it's over. So becarefull, try to don't die !");
		lbl_txtRow2.setBackground(new Color(248, 248, 255));
		lbl_txtRow2.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_txtRow2.setForeground(Color.BLACK);
		lbl_txtRow2.setBounds(10, 35, 564, 25);
		p_text.add(lbl_txtRow2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(1, 71, 584, 280);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel p_chaStats = new JPanel();
		p_chaStats.setBackground(Color.WHITE);
		p_chaStats.setBounds(10, 11, 135, 178);
		panel_1.add(p_chaStats);
		p_chaStats.setLayout(null);
		
		JLabel lbl_chaTitle = new JLabel("Your Stats");
		lbl_chaTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chaTitle.setFont(new Font("Minecraft", Font.BOLD, 18));
		lbl_chaTitle.setBounds(0, 0, 125, 50);
		p_chaStats.add(lbl_chaTitle);
		
		JLabel lbl_chaHp = new JLabel("HP         : " + c.getHp() + "/" + c.getFullHp());
		lbl_chaHp.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_chaHp.setBounds(0, 48, 135, 24);
		p_chaStats.add(lbl_chaHp);
		
		JLabel lbl_chaStamina = new JLabel("Stamina : " + c.getStamina() + "/" + c.getFullStamina());
		lbl_chaStamina.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_chaStamina.setBounds(0, 74, 135, 24);
		p_chaStats.add(lbl_chaStamina);
		
		JLabel lbl_chaDamage = new JLabel("Damage  : " + c.getTotalDamage());
		lbl_chaDamage.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_chaDamage.setBounds(0, 98, 135, 24);
		p_chaStats.add(lbl_chaDamage);
		
		JLabel lbl_chaArmor = new JLabel("Armor    : " + c.getTotalArmor());
		lbl_chaArmor.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_chaArmor.setBounds(0, 122, 135, 24);
		p_chaStats.add(lbl_chaArmor);
		
		JLabel lbl_chaCoin = new JLabel("Coin       : " + c.getInv().getCoin());
		lbl_chaCoin.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_chaCoin.setBounds(0, 143, 135, 24);
		p_chaStats.add(lbl_chaCoin);
		
		JPanel p_enemyStats = new JPanel();
		p_enemyStats.setBounds(439, 11, 135, 178);
		panel_1.add(p_enemyStats);
		p_enemyStats.setLayout(null);
		
		JLabel lbl_enemyStats = new JLabel("Enemy Stats");
		lbl_enemyStats.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_enemyStats.setFont(new Font("Minecraft", Font.BOLD, 18));
		lbl_enemyStats.setBounds(0, 0, 125, 50);
		p_enemyStats.add(lbl_enemyStats);
		
		JLabel lbl_enemyHp = new JLabel("HP           : " + obs.getHp());
		lbl_enemyHp.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyHp.setBounds(0, 48, 135, 24);
		p_enemyStats.add(lbl_enemyHp);
		
		JLabel lbl_enemyDamage = new JLabel("Damage    : " + obs.getDamage());
		lbl_enemyDamage.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyDamage.setBounds(0, 71, 135, 24);
		p_enemyStats.add(lbl_enemyDamage);
		
		JLabel lbl_enemyReward = new JLabel("Reward    : " + obs.getPrize());
		lbl_enemyReward.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyReward.setBounds(0, 95, 135, 24);
		p_enemyStats.add(lbl_enemyReward);
		
		JLabel lbl_info = new JLabel("  You're gonna fight against " + obs.getName());
		lbl_info.setForeground(Color.BLACK);
		lbl_info.setFont(new Font("Minecraft", Font.PLAIN, 13));
		lbl_info.setBounds(145, 11, 294, 25);
		panel_1.add(lbl_info);
		
		JLabel lbl_uyari = new JLabel("");
		lbl_uyari.setBounds(10, 255, 220, 25);
		panel_1.add(lbl_uyari);
		lbl_uyari.setForeground(Color.BLACK);
		lbl_uyari.setFont(new Font("Minecraft", Font.BOLD | Font.ITALIC, 13));
		
		JPanel p_buttons = new JPanel();
		p_buttons.setBounds(11, 361, 343, 69);
		contentPane.add(p_buttons);
		p_buttons.setLayout(null);
		
		
		JButton btn_changeEnemy = new JButton("Change Enemy");
		btn_changeEnemy.setForeground(new Color(0, 0, 0));
		btn_changeEnemy.setFont(new Font("Minecraft", Font.PLAIN, 13));
		btn_changeEnemy.setBackground(new Color(255, 204, 153));
		btn_changeEnemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enemyID = (int) (Math.random() * 10);
				obs = new Obstacle(enemyID);
				changedEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage , lbl_enemyReward, lbl_info);
				
			}
		});
		btn_changeEnemy.setBounds(363, 398, 211, 32);
		contentPane.add(btn_changeEnemy);
		
		JButton btn_lightAttack = new JButton("Light Attack");
		btn_lightAttack.setBackground(new Color(47, 120, 79));
		btn_lightAttack.setForeground(Color.BLACK);
		btn_lightAttack.setToolTipText("-2 Damage , No requires stamina");
		btn_lightAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_uyari.setText("You made light attack!");
				obs.setHp(obs.getHp() - (c.getTotalDamage() - 2));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(obs.getHp() <= 0) {
					obs.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You've killed your enemy");
					c.getInv().setCoin(c.getInv().getCoin() + obs.getPrize());
					Game_Menu gm = new Game_Menu(c);
					gm.setVisible(true);
					dispose();
					return;
				}
				c.setHp(c.getHp() - (obs.getDamage() - c.getTotalArmor()));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(c.getHp() <= 0) {
					c.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You died, Game Over!");
					dispose();
				}
				
			}
		});
		btn_lightAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_lightAttack.setBounds(0, 0, 227, 23);
		p_buttons.add(btn_lightAttack);
		
		JButton btn_mediumAttack = new JButton("Medium Attack");
		btn_mediumAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_uyari.setText("");
				if(c.getStamina() >= 15) {
					c.setStamina(c.getStamina() - 15);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				}else {
					lbl_uyari.setText("You don't have enough stamina !");
					return;
				}
				
				obs.setHp(obs.getHp() - (c.getTotalDamage()));
				lbl_uyari.setText("You made medium attack!");
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(obs.getHp() <= 0) {
					obs.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You've killed your enemy");
					c.getInv().setCoin(c.getInv().getCoin() + obs.getPrize());
					Game_Menu gm = new Game_Menu(c);
					gm.setVisible(true);
					dispose();
					return;
				}
				c.setHp(c.getHp() - (obs.getDamage() - c.getTotalArmor()));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(c.getHp() <= 0) {
					c.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You died, Game Over!");
					dispose();
				}
			}
		});
		btn_mediumAttack.setBackground(new Color(47, 109, 79));
		btn_mediumAttack.setForeground(Color.BLACK);
		btn_mediumAttack.setToolTipText("No extra damage, -15 Stamina");
		btn_mediumAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_mediumAttack.setBounds(0, 22, 227, 25);
		p_buttons.add(btn_mediumAttack);
		
		JButton btn_heavyAttack = new JButton("Heavy Attack");
		btn_heavyAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_uyari.setText("");
				if(c.getStamina() >= 40) {
					c.setStamina(c.getStamina() - 40);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				}else {
					lbl_uyari.setText("You don't have enough stamina !");
					return;
				}
				
				obs.setHp(obs.getHp() - (c.getTotalDamage() + 4));
				lbl_uyari.setText("You made heavy attack!");
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(obs.getHp() <= 0) {
					obs.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You've killed your enemy");
					c.getInv().setCoin(c.getInv().getCoin() + obs.getPrize());
					Game_Menu gm = new Game_Menu(c);
					gm.setVisible(true);
					dispose();
					return;
				}
				c.setHp(c.getHp() - (obs.getDamage() - c.getTotalArmor()));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if(c.getHp() <= 0) {
					c.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You died, Game Over!");
					dispose();
				}
			}
		});
		btn_heavyAttack.setBackground(new Color(47, 90, 79));
		btn_heavyAttack.setForeground(new Color(0, 0, 0));
		btn_heavyAttack.setToolTipText("+4 Damage , -40 Stamina");
		btn_heavyAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_heavyAttack.setBounds(0, 46, 227, 23);
		p_buttons.add(btn_heavyAttack);
		
		JButton btn_Flee = new JButton("Flee");
		btn_Flee.setForeground(new Color(255, 255, 255));
		btn_Flee.setBackground(new Color(47, 79, 79));
		btn_Flee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_uyari.setText("");
				Game_Menu gm = new Game_Menu(c);
				gm.setVisible(true);
				dispose();
				return;
				
			}
		});
		btn_Flee.setFont(new Font("Minecraft", Font.PLAIN, 14));
		btn_Flee.setBounds(228, 0, 115, 69);
		p_buttons.add(btn_Flee);
		
		JButton btn_UseHp = new JButton("Use HP : " + c.getInv().getHealthPotion() );
		btn_UseHp.setForeground(new Color(0, 0, 0));
		btn_UseHp.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btn_UseHp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getHp() == c.getFullHp()) {
					lbl_uyari.setText("Your hp is already full !");
			}else if(c.getInv().getHealthPotion() <= 0){ 
				  	lbl_uyari.setText("You don't have a health potion !");
			}else {
			c.getInv().setHealthPotion(c.getInv().getHealthPotion() - 1);
			c.setHp(c.getHp() + 20);
			if(c.getHp() > c.getFullHp()) {
				c.setHp(c.getFullHp());
			}
			
			lbl_uyari.setText("+20 Hp !");
			btn_UseHp.setText("Use HP : " + c.getInv().getHealthPotion());
			updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
		    }

			}
		});
		btn_UseHp.setBackground(new Color(240, 128, 128));
		btn_UseHp.setBounds(364, 362, 100, 25);
		contentPane.add(btn_UseHp);
		
		JButton btn_UseSp = new JButton("Use SP : " + c.getInv().getStaminaPotion());
		btn_UseSp.setForeground(new Color(0, 0, 0));
		btn_UseSp.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btn_UseSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getStamina() == c.getFullStamina()) {
					lbl_uyari.setText("Your stamina is already full !");
			}else if(c.getInv().getStaminaPotion() <= 0){ 
				  	lbl_uyari.setText("You don't have a stamina potion !");
			}else {
			c.getInv().setStaminaPotion(c.getInv().getStaminaPotion() - 1);
			c.setStamina(c.getStamina() + 40);
			if(c.getStamina() > c.getFullStamina()) {
				c.setStamina(c.getFullStamina());
				
			}
			lbl_uyari.setText("+40 Stamina !");
			btn_UseSp.setText("Use SP : " + c.getInv().getStaminaPotion());
			updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
		    }
			}
		});
		btn_UseSp.setBackground(new Color(70, 130, 180));
		btn_UseSp.setBounds(474, 362, 100, 25);
		contentPane.add(btn_UseSp);


	}

	public void updateStats(JLabel lbl1 , JLabel lbl2 , JLabel lbl3 , JLabel lbl4) {
		lbl1.setText("HP         : " + c.getHp() + "/" + c.getFullHp());
		lbl2.setText("Stamina : " + c.getStamina() + "/" + c.getFullStamina());
		lbl3.setText("Coin       : " + c.getInv().getCoin());
		
		lbl4.setText("HP           : " + obs.getHp());
	}
	
	public void changedEnemyStats(Obstacle obs, JLabel lbl1, JLabel lbl2 , JLabel lbl3, JLabel lbl4) {
		lbl1.setText("HP           : " + obs.getHp());
		lbl2.setText("Damage    : " + obs.getDamage());
		lbl3.setText("Reward    : " + obs.getPrize());
		lbl4.setText("  You're gonna fight against " + obs.getName());
		
	}
}

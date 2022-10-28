package GUI;

import GameProperties.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameProperties.Character;
import GameProperties.GameProgress;
import GameProperties.Obstacle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mountain extends JFrame {

	private JPanel contentPane;

	private int num;
	private int howManyLeft;
	static GameProgress g = new GameProgress();
	static Character c = new Character();
	Obstacle obs = new Obstacle(3 + c.getMountain_lvl());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mountain frame = new Mountain(g, c);
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
	public Mountain(GameProgress g, Character c) {
		this.g = g;
		this.c = c;
		num = 0;
		howManyLeft = 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel p_text = new JPanel();
		p_text.setLayout(null);
		p_text.setBackground(new Color(143, 188, 143));
		p_text.setBounds(0, 0, 584, 60);
		contentPane.add(p_text);
		
		JLabel lbl_txtRow1 = new JLabel("   You are on the mountain. You must kill the giant and get mushrooms from");
		lbl_txtRow1.setForeground(Color.BLACK);
		lbl_txtRow1.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_txtRow1.setBounds(10, 11, 564, 25);
		p_text.add(lbl_txtRow1);
		
		JLabel lbl_txtRow2 = new JLabel("his cave. Mushrooms are also needed for the elixir .. Find the Giant's cave!..");
		lbl_txtRow2.setForeground(Color.BLACK);
		lbl_txtRow2.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_txtRow2.setBackground(new Color(248, 248, 255));
		lbl_txtRow2.setBounds(10, 35, 564, 25);
		p_text.add(lbl_txtRow2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(1, 71, 584, 280);
		contentPane.add(panel_1);
		
		JPanel p_chaStats = new JPanel();
		p_chaStats.setLayout(null);
		p_chaStats.setBackground(Color.WHITE);
		p_chaStats.setBounds(10, 11, 135, 178);
		panel_1.add(p_chaStats);
		
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
		p_enemyStats.setLayout(null);
		p_enemyStats.setBounds(439, 11, 135, 178);
		panel_1.add(p_enemyStats);
		
		JLabel lbl_enemyStats = new JLabel("Enemy Stats");
		lbl_enemyStats.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_enemyStats.setFont(new Font("Minecraft", Font.BOLD, 18));
		lbl_enemyStats.setBounds(0, 0, 125, 50);
		p_enemyStats.add(lbl_enemyStats);
		
		JLabel lbl_enemyHp = new JLabel("HP           : " + obs.getHp());
		lbl_enemyHp.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyHp.setBounds(0, 48, 135, 24);
		p_enemyStats.add(lbl_enemyHp);
		
		JLabel lbl_enemyDamage = new JLabel("Damage    :" + obs.getDamage());
		lbl_enemyDamage.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyDamage.setBounds(0, 71, 135, 24);
		p_enemyStats.add(lbl_enemyDamage);
		
		JLabel lbl_enemyReward = new JLabel("Reward    : " + obs.getPrize());
		lbl_enemyReward.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_enemyReward.setBounds(0, 95, 135, 24);
		p_enemyStats.add(lbl_enemyReward);
		
		JLabel lbl_info = new JLabel("  You're gonna fight against 3 black bears !");
		if(c.getMountain_lvl() == 1) {
			lbl_info.setText("  You're gonna fight against 3 black bears!");
		}else if(c.getMountain_lvl() == 2) {
			lbl_info.setText("  You're gonna fight against 2 golems!");
		}else if(c.getMountain_lvl() == 3) {
			lbl_info.setText("  You're gonna fight against the Giant!");
		}
		
		
		lbl_info.setForeground(Color.BLACK);
		lbl_info.setFont(new Font("Minecraft", Font.PLAIN, 13));
		lbl_info.setBounds(145, 11, 294, 25);
		panel_1.add(lbl_info);
		
		JLabel lbl_uyari = new JLabel("");
		lbl_uyari.setForeground(Color.BLACK);
		lbl_uyari.setFont(new Font("Minecraft", Font.BOLD | Font.ITALIC, 13));
		lbl_uyari.setBounds(10, 255, 220, 25);
		panel_1.add(lbl_uyari);
		
		JButton btn_lightAttack = new JButton("Light Attack");
		btn_lightAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_uyari.setText("You made light attack!");
				obs.setHp(obs.getHp() - (c.getTotalDamage() - 2));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if (obs.getHp() <= 0) {
					obs.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You've killed your enemy");
					c.getInv().setCoin(c.getInv().getCoin() + obs.getPrize());
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					num++;

					levelSystem(lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward, lbl_uyari, lbl_info);

					return;
				}
				c.setHp(c.getHp() - (obs.getDamage() - c.getTotalArmor()));
				updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
				if (c.getHp() <= 0) {
					c.setHp(0);
					updateStats(lbl_chaHp, lbl_chaStamina, lbl_chaCoin, lbl_enemyHp);
					JOptionPane.showMessageDialog(contentPane, "You died, Game Over!");
					dispose();
				}
			}
		});
		btn_lightAttack.setToolTipText("-2 Damage , No requires stamina");
		btn_lightAttack.setForeground(Color.BLACK);
		btn_lightAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_lightAttack.setBackground(new Color(47, 120, 79));
		btn_lightAttack.setBounds(11, 361, 227, 23);
		contentPane.add(btn_lightAttack);
		
		JButton btn_mediumAttack = new JButton("Medium Attack");
		btn_mediumAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					num++;
					
					levelSystem(lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward, lbl_uyari, lbl_info);
					
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
		btn_mediumAttack.setToolTipText("No extra damage, -15 Stamina");
		btn_mediumAttack.setForeground(Color.BLACK);
		btn_mediumAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_mediumAttack.setBackground(new Color(47, 109, 79));
		btn_mediumAttack.setBounds(11, 383, 227, 25);
		contentPane.add(btn_mediumAttack);
		
		JButton btn_heavyAttack = new JButton("Heavy Attack");
		btn_heavyAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					num++;
					
					levelSystem(lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward, lbl_uyari, lbl_info);
					
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
		btn_heavyAttack.setToolTipText("+4 Damage , -40 Stamina");
		btn_heavyAttack.setForeground(Color.BLACK);
		btn_heavyAttack.setFont(new Font("Minecraft", Font.BOLD, 13));
		btn_heavyAttack.setBackground(new Color(47, 90, 79));
		btn_heavyAttack.setBounds(11, 407, 227, 23);
		contentPane.add(btn_heavyAttack);
		
		JButton btn_Flee = new JButton("Flee");
		btn_Flee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game_Menu gm = new Game_Menu(c);
				gm.setVisible(true);
				dispose();
				return;
			}
		});
		btn_Flee.setForeground(Color.WHITE);
		btn_Flee.setFont(new Font("Minecraft", Font.PLAIN, 14));
		btn_Flee.setBackground(new Color(47, 79, 79));
		btn_Flee.setBounds(239, 362, 115, 69);
		contentPane.add(btn_Flee);
		
		JButton btn_UseHp = new JButton("Use HP : " + c.getInv().getHealthPotion());
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
		btn_UseHp.setForeground(Color.BLACK);
		btn_UseHp.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btn_UseHp.setBackground(new Color(240, 128, 128));
		btn_UseHp.setBounds(364, 363, 100, 67);
		contentPane.add(btn_UseHp);
		
		JButton btn_UseSp = new JButton("Use SP : " + c.getInv().getStaminaPotion());
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
		btn_UseSp.setForeground(Color.BLACK);
		btn_UseSp.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btn_UseSp.setBackground(new Color(70, 130, 180));
		btn_UseSp.setBounds(474, 363, 100, 68);
		contentPane.add(btn_UseSp);
	}
	
	public void updateStats(JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4) {
		lbl1.setText("HP         : " + c.getHp() + "/" + c.getFullHp());
		lbl2.setText("Stamina : " + c.getStamina() + "/" + c.getFullStamina());
		lbl3.setText("Coin       : " + c.getInv().getCoin());

		lbl4.setText("HP           : " + obs.getHp());
	}
	
	public void newEnemyStats(Obstacle obs, JLabel lbl1, JLabel lbl2, JLabel lbl3) {
		obs.setHp(obs.getFullHp());
		lbl1.setText("HP           : " + obs.getHp());
		lbl2.setText("Damage    : " + obs.getDamage());
		lbl3.setText("Reward    : " + obs.getPrize());

	}
	
	public void levelSystem(JLabel lbl_enemyHp, JLabel lbl_enemyDamage, JLabel lbl_enemyReward, JLabel lbl_uyari,
			JLabel lbl_info) {
		if (c.getMountain_lvl() == 1) {
			newEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward);
			lbl_uyari.setText(3 - howManyLeft + " black bear(s) left ..");
			howManyLeft++;
			if (num == 3) {
				lbl_uyari.setText("CheckPoint !");
				c.setMountain_lvl(2);
				obs = new Obstacle(3 + c.getMountain_lvl());
				lbl_info.setText("  You're gonna fight against 2 golems!");
				newEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward);
				howManyLeft = 1;
				num = 0;
			}
		} else if (c.getMountain_lvl() == 2) {
			newEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward);
			lbl_uyari.setText(2 - howManyLeft + " golem(s) left ..");
			howManyLeft++;
			if (num == 2) {
				lbl_uyari.setText("CheckPoint !");
				c.setMountain_lvl(3);
				obs = new Obstacle(3 + c.getMountain_lvl());
				lbl_info.setText("  You're gonna fight against the Giant!");
				newEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward);
				howManyLeft = 1;
				num = 0;
			}
		} else if (c.getMountain_lvl() == 3) {
			newEnemyStats(obs, lbl_enemyHp, lbl_enemyDamage, lbl_enemyReward);

			c.setMountain_lvl(c.getMountain_lvl() + 1);
			JOptionPane.showMessageDialog(contentPane, "You took mushrooms and you found 500 coins !");
			c.getInv().setCoin(c.getInv().getCoin() + 500);
			g.setItm_mushroom(true);
			Game_Menu gm = new Game_Menu(c);
			gm.setVisible(true);
			dispose();

		}
	}
}

package GUI;

import GameProperties.*;
import GameProperties.Character;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shop extends JFrame {

	private JPanel contentPane;
	static Character c = new Character();
	int healthPotCounter = 0;
	int staminaPotCounter = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop(c);
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
	public Shop(Character c) {
		setResizable(false);
		setTitle("Shop");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lbl_uyari = new JLabel("");
		lbl_uyari.setForeground(new Color(0, 0, 0));
		lbl_uyari.setFont(new Font("Minecraft", Font.PLAIN, 13));
		lbl_uyari.setBounds(21, 376, 416, 31);
		contentPane.add(lbl_uyari);

		JLabel lbl_coin = new JLabel("COIN : " + c.getInv().getCoin());
		lbl_coin.setForeground(new Color(0, 0, 0));
		lbl_coin.setFont(new Font("Minecraft", Font.BOLD, 15));
		lbl_coin.setBounds(464, 83, 120, 31);
		contentPane.add(lbl_coin);

		JLabel lbl_shopText1 = new JLabel("You can buy something to strengthen your character.");
		lbl_shopText1.setForeground(new Color(0, 0, 0));
		lbl_shopText1.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lbl_shopText1.setBounds(21, 15, 417, 23);
		contentPane.add(lbl_shopText1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 228, 196));
		tabbedPane.setBounds(21, 62, 417, 303);
		contentPane.add(tabbedPane);

		JPanel p_Weapons = new JPanel();
		p_Weapons.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Weapons", null, p_Weapons, null);
		p_Weapons.setLayout(null);

		JPanel p_weaponBuy = new JPanel();
		p_weaponBuy.setBackground(new Color(255, 228, 196));
		p_weaponBuy.setBounds(10, 11, 65, 253);
		p_Weapons.add(p_weaponBuy);
		p_weaponBuy.setLayout(new GridLayout(3, 0, 5, 50));

		JButton btn_weaponBuy1 = new JButton("Buy");
		btn_weaponBuy1.setForeground(Color.BLACK);
		btn_weaponBuy1.setBackground(new Color(34, 139, 34));
		btn_weaponBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(c.getChaId() == 1 || c.getChaId() == 2) {
					if(c.getInv().isDagger() == false && c.getInv().getCoin() >= 50) {
						c.setExtraDamage(4);
						c.getInv().setCoin(c.getInv().getCoin() - 50);
						c.getInv().setDagger(true);
						lbl_coin.setText("COIN : " + c.getInv().getCoin());
						lbl_uyari.setText("You bought a dagger.");
						blockButton(btn_weaponBuy1);
					}else if(c.getInv().getCoin() < 50) {
						lbl_uyari.setText("You don't have enough money.");
					}
				}else if(c.getChaId() == 3) {
					if(c.getInv().isBrokenBow() == false && c.getInv().getCoin() >= 50) {
						c.setExtraDamage(4);
						c.getInv().setCoin(c.getInv().getCoin() - 50);
						c.getInv().setBrokenBow(true);
						lbl_coin.setText("COIN : " + c.getInv().getCoin());
						lbl_uyari.setText("You bought a broken bow.");
						blockButton(btn_weaponBuy1);
					}else if(c.getInv().getCoin() < 50) {
						lbl_uyari.setText("You don't have enough money.");
					}
				}

			}
		});
		p_weaponBuy.add(btn_weaponBuy1);

		JButton btn_weaponBuy2 = new JButton("Buy");
		btn_weaponBuy2.setForeground(Color.BLACK);
		btn_weaponBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					if(c.getChaId() == 1 || c.getChaId() == 2) {
						if(c.getInv().isOldSword() == false && c.getInv().getCoin() >= 80) {
							c.setExtraDamage(7);
							c.getInv().setCoin(c.getInv().getCoin() - 80);
							c.getInv().setOldSword(true);
							c.getInv().setDagger(true);
							lbl_coin.setText("COIN : " + c.getInv().getCoin());
							lbl_uyari.setText("You bought a old sword.");
							blockButton(btn_weaponBuy1);
							blockButton(btn_weaponBuy2);
						}else if(c.getInv().getCoin() < 80) {
							lbl_uyari.setText("You don't have enough money.");
						}
					}else if(c.getChaId() == 3) {
						if(c.getInv().isCurvedBow() == false && c.getInv().getCoin() >= 80) {
							c.setExtraDamage(7);
							c.getInv().setCoin(c.getInv().getCoin() - 80);
							c.getInv().setCurvedBow(true);
							c.getInv().setBrokenBow(true);
							lbl_coin.setText("COIN : " + c.getInv().getCoin());
							lbl_uyari.setText("You bought a curved bow.");
							blockButton(btn_weaponBuy1);
							blockButton(btn_weaponBuy2);
						}else if(c.getInv().getCoin() < 80) {
							lbl_uyari.setText("You don't have enough money.");
						}
					}
			}
		});
		btn_weaponBuy2.setBackground(new Color(34, 139, 34));
		p_weaponBuy.add(btn_weaponBuy2);

		JButton btn_weaponBuy3 = new JButton("Buy");
		btn_weaponBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(c.getChaId() == 1 || c.getChaId() == 2) {
					if(c.getInv().isLongSword() == false && c.getInv().getCoin() >= 110) {
						c.setExtraDamage(10);
						c.getInv().setCoin(c.getInv().getCoin() - 110);
						c.getInv().setLongSword(true);
						c.getInv().setOldSword(true);
						c.getInv().setDagger(true);
						lbl_coin.setText("COIN : " + c.getInv().getCoin());
						lbl_uyari.setText("You bought a long sword.");
						blockButton(btn_weaponBuy1);
						blockButton(btn_weaponBuy2);
						blockButton(btn_weaponBuy3);
					}else if(c.getInv().getCoin() < 110) {
						lbl_uyari.setText("You don't have enough money.");
					}
				}else if(c.getChaId() == 3) {
					if(c.getInv().isIronBow() == false && c.getInv().getCoin() >= 110) {
						c.setExtraDamage(10);
						c.getInv().setCoin(c.getInv().getCoin() - 110);
						c.getInv().setIronBow(true);
						c.getInv().setCurvedBow(true);
						c.getInv().setBrokenBow(true);
						lbl_coin.setText("COIN : " + c.getInv().getCoin());
						lbl_uyari.setText("You bought a iron bow.");
						blockButton(btn_weaponBuy1);
						blockButton(btn_weaponBuy2);
						blockButton(btn_weaponBuy3);
					}else if(c.getInv().getCoin() < 110) {
						lbl_uyari.setText("You don't have enough money.");
					}
				}
			}
		});
		btn_weaponBuy3.setForeground(Color.BLACK);
		btn_weaponBuy3.setBackground(new Color(34, 139, 34));
		p_weaponBuy.add(btn_weaponBuy3);

		JPanel p_weaponInfo = new JPanel();
		p_weaponInfo.setBackground(new Color(255, 228, 196));
		p_weaponInfo.setBounds(85, 11, 317, 253);
		p_Weapons.add(p_weaponInfo);
		p_weaponInfo.setLayout(null);

		JLabel lbl_w1 = new JLabel("");
		lbl_w1.setForeground(new Color(0, 0, 0));
		lbl_w1.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w1.setBounds(0, 0, 317, 25);
		p_weaponInfo.add(lbl_w1);
		shopWeapon(c.getChaId(), lbl_w1, "Dagger (+4 damage)", "Broken Bow (+4 damage)");

		JLabel lbl_w1info = new JLabel("");
		lbl_w1info.setForeground(new Color(0, 0, 0));
		lbl_w1info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w1info.setBounds(0, 24, 317, 25);
		p_weaponInfo.add(lbl_w1info);
		shopWeapon(c.getChaId(), lbl_w1info, "COST : 50", "COST : 50");

		JLabel lbl_w2 = new JLabel("");
		lbl_w2.setForeground(new Color(0, 0, 0));
		lbl_w2.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w2.setBounds(0, 102, 317, 25);
		p_weaponInfo.add(lbl_w2);
		shopWeapon(c.getChaId(), lbl_w2, "Old Sword (+7 damage)", "Curved Bow (+7 damage)");

		JLabel lbl_w2info = new JLabel("");
		lbl_w2info.setForeground(new Color(0, 0, 0));
		lbl_w2info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w2info.setBounds(0, 126, 317, 25);
		p_weaponInfo.add(lbl_w2info);
		shopWeapon(c.getChaId(), lbl_w2info, "COST : 80", "COST : 80");

		JLabel lbl_w3 = new JLabel("");
		lbl_w3.setForeground(new Color(0, 0, 0));
		lbl_w3.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w3.setBounds(0, 203, 317, 25);
		p_weaponInfo.add(lbl_w3);
		shopWeapon(c.getChaId(), lbl_w3, "Long Sword (+10 damage)", "Iron Bow (+10 damage)");

		JLabel lbl_w3info = new JLabel("");
		lbl_w3info.setForeground(new Color(0, 0, 0));
		lbl_w3info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_w3info.setBounds(0, 228, 317, 25);
		p_weaponInfo.add(lbl_w3info);
		shopWeapon(c.getChaId(), lbl_w3info, "COST : 110", "COST : 110");

		JPanel p_Armors = new JPanel();
		p_Armors.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Armors", null, p_Armors, null);
		p_Armors.setLayout(null);

		JPanel p_armorBuy = new JPanel();
		p_armorBuy.setBackground(new Color(255, 228, 196));
		p_armorBuy.setBounds(10, 11, 65, 253);
		p_Armors.add(p_armorBuy);
		p_armorBuy.setLayout(new GridLayout(3, 0, 5, 50));

		JButton btn_armorBuy1 = new JButton("Buy");
		btn_armorBuy1.setForeground(Color.BLACK);
		btn_armorBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(c.getInv().isLightArmor() == false && c.getInv().getCoin() >= 60) {
					c.setExtraArmor(3);
					c.getInv().setCoin(c.getInv().getCoin() - 60);
					c.getInv().setLightArmor(true);
					lbl_coin.setText("COIN : " + c.getInv().getCoin());
					lbl_uyari.setText("You bought a light armor.");
					blockButton(btn_armorBuy1);
				}else if(c.getInv().getCoin() < 60) {
					lbl_uyari.setText("You don't have enough money.");
				}
			}
		});
		btn_armorBuy1.setBackground(new Color(34, 139, 34));
		p_armorBuy.add(btn_armorBuy1);

		JButton btn_armorBuy2 = new JButton("Buy");
		btn_armorBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getInv().isSolidArmor() == false && c.getInv().getCoin() >= 90) {
					c.setExtraArmor(6);
					c.getInv().setCoin(c.getInv().getCoin() - 90);
					c.getInv().setSolidArmor(true);
					c.getInv().setLightArmor(true);
					lbl_coin.setText("COIN : " + c.getInv().getCoin());
					lbl_uyari.setText("You bought a solid armor.");
					blockButton(btn_armorBuy1);
					blockButton(btn_armorBuy2);
				}else if(c.getInv().getCoin() < 90) {
					lbl_uyari.setText("You don't have enough money.");
				}
			}
		});
		btn_armorBuy2.setForeground(Color.BLACK);
		btn_armorBuy2.setBackground(new Color(34, 139, 34));
		p_armorBuy.add(btn_armorBuy2);

		JButton btn_armorBuy3 = new JButton("Buy");
		btn_armorBuy3.setForeground(Color.BLACK);
		btn_armorBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getInv().isHeavyArmor() == false && c.getInv().getCoin() >= 120) {
					c.setExtraArmor(9);
					c.getInv().setCoin(c.getInv().getCoin() - 120);
					c.getInv().setHeavyArmor(true);
					c.getInv().setSolidArmor(true);
					c.getInv().setLightArmor(true);
					lbl_coin.setText("COIN : " + c.getInv().getCoin());
					lbl_uyari.setText("You bought a heavy armor.");
					blockButton(btn_armorBuy1);
					blockButton(btn_armorBuy2);
					blockButton(btn_armorBuy3);
				}else if(c.getInv().getCoin() < 120) {
					lbl_uyari.setText("You don't have enough money.");
				}
			}
		});
		btn_armorBuy3.setBackground(new Color(34, 139, 34));
		p_armorBuy.add(btn_armorBuy3);

		JPanel p_armorInfo = new JPanel();
		p_armorInfo.setBackground(new Color(255, 228, 196));
		p_armorInfo.setBounds(85, 11, 317, 253);
		p_Armors.add(p_armorInfo);
		p_armorInfo.setLayout(null);

		JLabel lbl_a1 = new JLabel("Light Armor (+3 Armor)");
		lbl_a1.setForeground(new Color(0, 0, 0));
		lbl_a1.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a1.setBounds(0, 0, 317, 25);
		p_armorInfo.add(lbl_a1);

		JLabel lbl_a1info = new JLabel("COIN : 60");
		lbl_a1info.setForeground(new Color(0, 0, 0));
		lbl_a1info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a1info.setBounds(0, 24, 317, 25);
		p_armorInfo.add(lbl_a1info);

		JLabel lbl_a2 = new JLabel("Solid Armor (+6 Armor)");
		lbl_a2.setForeground(new Color(0, 0, 0));
		lbl_a2.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a2.setBounds(0, 102, 317, 25);
		p_armorInfo.add(lbl_a2);

		JLabel lbl_a2info = new JLabel("COIN : 90");
		lbl_a2info.setForeground(new Color(0, 0, 0));
		lbl_a2info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a2info.setBounds(0, 126, 317, 25);
		p_armorInfo.add(lbl_a2info);

		JLabel lbl_a3 = new JLabel("Heavy Armor (+9 Armor)");
		lbl_a3.setForeground(new Color(0, 0, 0));
		lbl_a3.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a3.setBounds(0, 203, 317, 25);
		p_armorInfo.add(lbl_a3);

		JLabel lbl_a3info = new JLabel("COIN : 120");
		lbl_a3info.setForeground(new Color(0, 0, 0));
		lbl_a3info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_a3info.setBounds(0, 228, 317, 25);
		p_armorInfo.add(lbl_a3info);

		JPanel p_Pots = new JPanel();
		p_Pots.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Pots", null, p_Pots, null);
		p_Pots.setLayout(null);

		JPanel p_potBuy = new JPanel();
		p_potBuy.setBackground(new Color(255, 228, 196));
		p_potBuy.setBounds(10, 11, 65, 253);
		p_Pots.add(p_potBuy);
		p_potBuy.setLayout(new GridLayout(3, 0, 5, 50));

		JButton btn_potBuy1 = new JButton("Buy");
		btn_potBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getInv().getHealthPotion() < 10 && c.getInv().getCoin() >= 20) {
					healthPotCounter++;
					c.getInv().setHealthPotion(c.getInv().getHealthPotion() + 1);
					c.getInv().setCoin(c.getInv().getCoin() - 20);
					lbl_coin.setText("COIN : " + c.getInv().getCoin());
					if(healthPotCounter==1) {
						lbl_uyari.setText("You bought a health potion.");
					}else {
						lbl_uyari.setText("You bought " + healthPotCounter + " health potions.");
					}
				}else if(c.getInv().getCoin() < 20) {
					lbl_uyari.setText("You don't have enough money.");
				}else if(c.getInv().getHealthPotion() >= 10) {
					lbl_uyari.setText("You can't buy more than 10 potions.");
				}
			}
		});
		btn_potBuy1.setForeground(Color.BLACK);
		btn_potBuy1.setBackground(new Color(34, 139, 34));
		p_potBuy.add(btn_potBuy1);

		JButton btn_potBuy2 = new JButton("Buy");
		btn_potBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getInv().getStaminaPotion() < 10 && c.getInv().getCoin() >= 40) {
					staminaPotCounter++;
					c.getInv().setStaminaPotion(c.getInv().getStaminaPotion() + 1);
					c.getInv().setCoin(c.getInv().getCoin() - 40);
					lbl_coin.setText("COIN : " + c.getInv().getCoin());
					if(staminaPotCounter==1) {
						lbl_uyari.setText("You bought a stamina potion.");
					}else {
						lbl_uyari.setText("You bought " + staminaPotCounter + " stamina potions.");
					}
				}else if(c.getInv().getCoin() < 40) {
					lbl_uyari.setText("You don't have enough money.");
				}else if(c.getInv().getStaminaPotion() >= 10) {
					lbl_uyari.setText("You can't buy more than 10 potions.");
				}
			}
		});
		btn_potBuy2.setForeground(Color.BLACK);
		btn_potBuy2.setBackground(new Color(34, 139, 34));
		p_potBuy.add(btn_potBuy2);

		JPanel p_potInfo = new JPanel();
		p_potInfo.setBackground(new Color(255, 228, 196));
		p_potInfo.setBounds(85, 11, 317, 253);
		p_Pots.add(p_potInfo);
		p_potInfo.setLayout(null);

		JLabel lbl_p1 = new JLabel("Health Potion (+20 Health Point)");
		lbl_p1.setForeground(new Color(0, 0, 0));
		lbl_p1.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_p1.setBounds(0, 0, 317, 25);
		p_potInfo.add(lbl_p1);

		JLabel lbl_p1info = new JLabel("COIN : 20");
		lbl_p1info.setForeground(new Color(0, 0, 0));
		lbl_p1info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_p1info.setBounds(0, 24, 317, 25);
		p_potInfo.add(lbl_p1info);

		JLabel lbl_p2 = new JLabel("Stamina Potion (+40 Stamina Point)");
		lbl_p2.setForeground(new Color(0, 0, 0));
		lbl_p2.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_p2.setBounds(0, 102, 317, 25);
		p_potInfo.add(lbl_p2);

		JLabel lbl_p2info = new JLabel("COIN : 30");
		lbl_p2info.setForeground(new Color(0, 0, 0));
		lbl_p2info.setFont(new Font("Minecraft", Font.PLAIN, 14));
		lbl_p2info.setBounds(0, 126, 317, 25);
		p_potInfo.add(lbl_p2info);
		
		JButton btn_back = new JButton("BACK");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game_Menu gm = new Game_Menu(c);
				gm.setVisible(true);
				dispose();
			}
		});
		btn_back.setBackground(new Color(128, 128, 128));
		btn_back.setFont(new Font("Minecraft", Font.PLAIN, 13));
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.setBounds(495, 376, 89, 31);
		contentPane.add(btn_back);
		setLocationRelativeTo(null);
		
		if(c.getInv().isDagger() || c.getInv().isBrokenBow()) {
			blockButton(btn_weaponBuy1);
			}
		if(c.getInv().isOldSword() || c.getInv().isCurvedBow()){
			blockButton(btn_weaponBuy2);
			}
		if(c.getInv().isLongSword() || c.getInv().isIronBow()){
			blockButton(btn_weaponBuy3);
			}
		if(c.getInv().isLightArmor()) {
			blockButton(btn_armorBuy1);
		}
		if(c.getInv().isSolidArmor()) {
			blockButton(btn_armorBuy2);
		}
		if(c.getInv().isHeavyArmor()) {
			blockButton(btn_armorBuy3);
		}
	}

	public void shopWeapon(int a, JLabel lbl, String weaponName, String bowName) {
		if (a == 1 || a == 2) {
			lbl.setText(weaponName);
		}

		if (a == 3) {
			lbl.setText(bowName);
		}
	}
	
	public void blockButton(JButton btn) {
		btn.setEnabled(false);
		btn.setText("Sold");
	}
	
}

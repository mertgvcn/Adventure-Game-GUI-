package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameProperties.Character;
import GameProperties.GameProgress;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_Menu extends JFrame {

	private JPanel contentPane;
	static Character c = new Character();
	static GameProgress g = new GameProgress();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_Menu frame = new Game_Menu(c);
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
	public Game_Menu(Character c) {
		this.c = c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel p_Progress = new JPanel();
		p_Progress.setLayout(null);
		p_Progress.setBackground(new Color(255, 255, 153));
		p_Progress.setBounds(10, 398, 303, 152);
		contentPane.add(p_Progress);

		JLabel lbl_title_1 = new JLabel("   PROGRESS");
		lbl_title_1.setVerticalAlignment(SwingConstants.TOP);
		lbl_title_1.setFont(new Font("Minecraft", Font.BOLD, 30));
		lbl_title_1.setBounds(33, 11, 232, 28);
		p_Progress.add(lbl_title_1);

		JTextArea txt_stats_1 = new JTextArea();
		txt_stats_1.setText(
				"Ingredients for the potion !\r\nSpider eye      > x\r\nMushrooms     > x\r\nSnake posion  > x\r\n ");
		if (g.isItm_spiderEye() && g.isItm_mushroom() == false) {
			txt_stats_1.setText(
					"Ingredients for the potion !\r\nSpider eye      > +\r\nMushrooms     > x\r\nSnake posion  > x\r\n ");
		} else if (g.isItm_mushroom() && g.isItm_snakePosion() == false) {
			txt_stats_1.setText(
					"Ingredients for the potion !\r\nSpider eye      > +\r\nMushrooms     > +\r\nSnake posion  > x\r\n ");
		} else if (g.isItm_snakePosion()) {
			txt_stats_1.setText(
					"Ingredients for the potion !\r\nSpider eye      > +\r\nMushrooms     > +\r\nSnake posion  > +\r\n ");
		}
		
		txt_stats_1.setBounds(10, 47, 283, 94);
		p_Progress.add(txt_stats_1);
		txt_stats_1.setForeground(Color.BLACK);
		txt_stats_1.setFont(new Font("Minecraft", Font.PLAIN, 19));
		txt_stats_1.setEditable(false);
		txt_stats_1.setBackground(new Color(255, 255, 153));

		JPanel p_Locations = new JPanel();
		p_Locations.setBounds(0, 0, 784, 103);
		contentPane.add(p_Locations);

		JButton btn_Safezone = new JButton("SAFEZONE");
		btn_Safezone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Safezone sz = new Safezone(c);
				sz.setVisible(true);
				dispose();
			}
		});
		p_Locations.setLayout(new GridLayout(0, 6, 0, 0));
		btn_Safezone.setForeground(Color.BLACK);
		btn_Safezone.setBackground(Color.LIGHT_GRAY);
		btn_Safezone.setFont(new Font("Minecraft", Font.PLAIN, 15));
		p_Locations.add(btn_Safezone);

		JButton btn_Shop = new JButton("SHOP");
		btn_Shop.setForeground(Color.BLACK);
		btn_Shop.setBackground(Color.LIGHT_GRAY);
		btn_Shop.setFont(new Font("Minecraft", Font.PLAIN, 15));
		btn_Shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop shop = new Shop(c);
				shop.setVisible(true);
				dispose();
			}
		});
		p_Locations.add(btn_Shop);

		JButton btn_Arena = new JButton("ARENA");
		btn_Arena.setFont(new Font("Minecraft", Font.PLAIN, 15));
		btn_Arena.setForeground(Color.BLACK);
		btn_Arena.setBackground(Color.LIGHT_GRAY);
		btn_Arena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Arena a = new Arena(c);
				a.setVisible(true);
				dispose();
			}
		});
		p_Locations.add(btn_Arena);

		JButton btn_Forest = new JButton("FOREST");
		btn_Forest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forest f = new Forest(g, c);
				f.setVisible(true);
				dispose();
			}
		});
		btn_Forest.setFont(new Font("Minecraft", Font.PLAIN, 15));
		btn_Forest.setForeground(Color.BLACK);
		btn_Forest.setBackground(Color.LIGHT_GRAY);
		p_Locations.add(btn_Forest);

		JButton btn_Mountain = new JButton("MOUNTAIN");
		btn_Mountain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mountain m = new Mountain(g, c);
				m.setVisible(true);
				dispose();
			}
		});
		btn_Mountain.setFont(new Font("Minecraft", Font.PLAIN, 15));
		btn_Mountain.setForeground(Color.BLACK);
		btn_Mountain.setBackground(Color.LIGHT_GRAY);
		p_Locations.add(btn_Mountain);

		JButton btn_Desert = new JButton("DESERT");
		btn_Desert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desert d = new Desert(g, c);
				d.setVisible(true);
				dispose();
			}
		});
		btn_Desert.setFont(new Font("Minecraft", Font.PLAIN, 15));
		btn_Desert.setForeground(Color.BLACK);
		btn_Desert.setBackground(Color.LIGHT_GRAY);
		p_Locations.add(btn_Desert);

		blockButton(btn_Forest, btn_Mountain, btn_Desert);

		JPanel p_map = new JPanel();
		p_map.setBounds(764, 541, -368, -429);
		contentPane.add(p_map);

		JLabel lbl_map = new JLabel("");
		ImageIcon map = new ImageIcon("map.png");
		// D:/Programlar/eclipse/workshop/AdventureGame/src/GUI/map.png
		// C:/Users/ROMAN/Desktop/eclipse/workshop/AdventureGame/src/GUI/map.png
		lbl_map.setIcon(map);
		lbl_map.setBounds(323, 113, 451, 437);
		contentPane.add(lbl_map);

		JPanel p_Stats = new JPanel();
		p_Stats.setBackground(new Color(255, 255, 153));
		p_Stats.setBounds(10, 114, 303, 273);
		contentPane.add(p_Stats);
		p_Stats.setLayout(null);

		JLabel lbl_title = new JLabel("       STATS\r\n");
		lbl_title.setFont(new Font("Minecraft", Font.BOLD, 30));
		lbl_title.setVerticalAlignment(SwingConstants.TOP);
		lbl_title.setBounds(33, 11, 232, 28);
		p_Stats.add(lbl_title);

		JTextArea txt_stats = new JTextArea();
		txt_stats.setText("Welcome " + c.getName() + "!" + "\r\n\r\n\r\n\r\nHp           :" + c.getHp() + "/"
				+ c.getFullHp() + "\r\nStamina  :" + c.getStamina() + "/" + c.getFullStamina() + "\r\nDamage  :"
				+ c.getDamage() + "\r\nArmor     :" + c.getArmor() + "\r\nCoin        :" + c.getInv().getCoin());
		if (c.getExtraDamage() != 0 && c.getExtraArmor() != 0) {
			txt_stats.setText("Welcome " + c.getName() + "!" + "\r\n\r\n\r\n\r\nHp           :" + c.getHp() + "/"
					+ c.getFullHp() + "\r\nStamina  :" + c.getStamina() + "/" + c.getFullStamina() + "\r\nDamage  :"
					+ c.getDamage() + "+" + c.getExtraDamage() + "\r\nArmor     :" + c.getArmor() + "+"
					+ c.getExtraArmor() + "\r\nCoin        :" + c.getInv().getCoin());
		} else if (c.getExtraArmor() != 0) {
			txt_stats.setText("Welcome " + c.getName() + "!" + "\r\n\r\n\r\n\r\nHp           :" + c.getHp() + "/"
					+ c.getFullHp() + "\r\nStamina  :" + c.getStamina() + "/" + c.getFullStamina() + "\r\nDamage  :"
					+ c.getDamage() + "\r\nArmor     :" + c.getArmor() + "+" + c.getExtraArmor() + "\r\nCoin        :"
					+ c.getInv().getCoin());
		} else if (c.getExtraDamage() != 0) {
			txt_stats.setText("Welcome " + c.getName() + "!" + "\r\n\r\n\r\n\r\nHp           :" + c.getHp() + "/"
					+ c.getFullHp() + "\r\nStamina  :" + c.getStamina() + "/" + c.getFullStamina() + "\r\nDamage  :"
					+ c.getDamage() + "+" + c.getExtraDamage() + "\r\nArmor     :" + c.getArmor() + "\r\nCoin        :"
					+ c.getInv().getCoin());
		}
		txt_stats.setBackground(new Color(255, 255, 153));
		txt_stats.setForeground(new Color(0, 0, 0));
		txt_stats.setEditable(false);
		txt_stats.setFont(new Font("Minecraft", Font.PLAIN, 19));
		txt_stats.setBounds(10, 61, 283, 212);
		p_Stats.add(txt_stats);

		JLabel lbl_background = new JLabel("");
		lbl_background.setBounds(0, 39, 784, 541);
		contentPane.add(lbl_background);
		ImageIcon background = new ImageIcon("background.jpg");
		lbl_background.setIcon(background);
		
	}

	public void blockButton(JButton btn_forest, JButton btn_mountain, JButton btn_desert) {

		if (c.getForest_lvl() <= 3) {
			btn_forest.setEnabled(true);
			btn_mountain.setEnabled(false);
			btn_desert.setEnabled(false);
		} else if (c.getForest_lvl() > 3 && c.getMountain_lvl() <= 3) {
			btn_forest.setEnabled(false);
			btn_mountain.setEnabled(true);
			btn_desert.setEnabled(false);
		} else if (c.getForest_lvl() > 3 && c.getMountain_lvl() > 3 && c.getDesert_lvl() <= 3) {
			btn_forest.setEnabled(false);
			btn_mountain.setEnabled(false);
			btn_desert.setEnabled(true);
		}else if(c.getDesert_lvl() > 3) {
			btn_forest.setEnabled(false);
			btn_mountain.setEnabled(false);
			btn_desert.setEnabled(false);
		}
	}
}
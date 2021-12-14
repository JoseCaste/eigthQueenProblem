package com.eigthqueen.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.eigthqueen.controller.PrincipalController;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class EigthQueenProblemGUI extends JFrame {

	public JPanel contentPane;
	public JButton btnStart;
	public GridBagConstraints gbc_lblNewLabel;
	public JPanel panel;
	public JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EigthQueenProblemGUI frame = new EigthQueenProblemGUI();
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
	public EigthQueenProblemGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 859);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(221, 30, 265, 202);
		panel.setVisible(false);
		contentPane.add(panel);


		panel_1 = new JPanel();
		panel_1.setBounds(172, 256, 394, 394);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(621, 32, 97, 25);
		contentPane.add(btnStart);
		
		
		gbc_lblNewLabel = new GridBagConstraints();
		
		Icon imgIcon = new ImageIcon(this.getClass().getResource("/com/eigthqueen/stuff/loading.gif"));
		new PrincipalController(this);
	}
}

package com.eigthqueen.controller;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.eigthqueen.IA.EigthQueenAlgoritm;
import com.eigthqueen.view.EigthQueenProblemGUI;

public class PrincipalController implements ActionListener{
	EigthQueenProblemGUI gui;
	ArrayList<Integer> queens= new ArrayList<>();
	public PrincipalController(EigthQueenProblemGUI gui) {
		this.gui=gui;
		initComponents();
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		this.gui.btnStart.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.gui.btnStart){
			String tablero="";
			Thread thread= new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					String tablero=EigthQueenAlgoritm.run();
					String[] thisCombo2 = tablero.split("(?<=\\G.{" + 3 + "})");
		            for (String thisCombo21 : thisCombo2) {
		            	queens.add(Integer.parseInt(thisCombo21, 2));
		            }
		            for (int i = 0; i < queens.size(); i++) {
						System.out.println("("+queens.get(i)+","+i+")");
		            }
		            int color=0;
		    		for (int i = 0; i <= 7; i++) {
		    			for (int j = 0; j <= 7; j++) {
		    				JLabel label2 = new JLabel();
		    				label2.setBounds(0, 1, 50, 50);
		    				BufferedImage img2;
		    				try {
		    					if(queens.get(i)== j){
		    						img2 = ImageIO.read(
		    								EigthQueenProblemGUI.class.getResource("/com/eigthqueen/stuff/queen.png"));	
		    					}else{
		    						if(color % 2 == 0)
			    						img2 = ImageIO.read(
			    								EigthQueenProblemGUI.class.getResource("/com/eigthqueen/stuff/cuadro_negro.png"));
		    						else
			    						img2 = ImageIO.read(
			    								EigthQueenProblemGUI.class.getResource("/com/eigthqueen/stuff/cuadro_blanco.png"));
		    					}
		    					color++;
		    					Image resizeImage = img2.getScaledInstance(label2.getWidth(),
		    							label2.getHeight(), Image.SCALE_SMOOTH);
		    					ImageIcon icon = new ImageIcon(resizeImage);
		    					label2.setIcon(icon);
		    					gui.panel.add(label2, BorderLayout.CENTER);
		    					label2.setName("myChair available");
		    					gui.gbc_lblNewLabel.gridx = i;
		    					gui.gbc_lblNewLabel.gridy = j;
		    					
		    				} catch (IOException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
		    				gui.panel_1.add(label2, gui.gbc_lblNewLabel);
		    			}
		    			color++;
		    		}
		    		SwingUtilities.updateComponentTreeUI(gui);
		            /*for (int i = 0; i < queens.size(); i++) {
						System.out.println("("+queens.get(i)+","+i+")");
						JLabel label2 = new JLabel();
						label2.setBounds(0, 1, 50, 50);
						BufferedImage img2;
						try {
							
								img2 = ImageIO.read(
										EigthQueenProblemGUI.class.getResource("/com/eigthqueen/stuff/queen.png"));
							Image resizeImage = img2.getScaledInstance(label2.getWidth(),
									label2.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon icon = new ImageIcon(resizeImage);
							label2.setIcon(icon);
							gui.panel.add(label2, BorderLayout.CENTER);
							label2.setName("myChair available");
							gui.gbc_lblNewLabel.gridx = i;
							gui.gbc_lblNewLabel.gridy = queens.get(i);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						gui.panel_1.add(label2, gui.gbc_lblNewLabel);
						SwingUtilities.updateComponentTreeUI(gui);
					}*/
				}
			});
			thread.start();
		}
		
	}

}

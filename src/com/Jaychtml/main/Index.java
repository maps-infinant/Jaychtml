package com.Jaychtml.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Index extends JFrame {
	
	public Index() {
		//Variable declaration and crap
		JFrame frame = this;
		JPanel treePanel = new JPanel();
		JPanel inspectPanel = new JPanel();
		JPanel editorPanel = new JPanel();
		JPanel menuPanel = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Functional shit i guess
		menuPanel.add(new JLabel("Menu"));
		treePanel.add(new JLabel("Tree"));
		editorPanel.add(new JLabel("Editor"));
		inspectPanel.add(new JLabel("Inspect"));
		
		//fullscreen BITCCHES
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setLayout(null);//Get rid of layout to make setBounds work
		
		//sizing and positioning
		menuPanel.setBounds(new Rectangle(0, 0, screenSize.width, screenSize.height/10));
		//menuPanel.setBackground(Color.RED);
		menuPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		treePanel.setBounds(new Rectangle(0,screenSize.height/10,screenSize.width*3/10,screenSize.height*7/10));
		//treePanel.setBackground(Color.GREEN);
		treePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		editorPanel.setBounds(new Rectangle(screenSize.width*3/10, screenSize.height/10, screenSize.width*7/10, screenSize.height*7/10));
		//editorPanel.setBackground(Color.BLUE);
		editorPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		inspectPanel.setBounds(new Rectangle(0,screenSize.height*8/10,screenSize.width,screenSize.height*2/10));
		//inspectPanel.setBackground(Color.YELLOW);
		inspectPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//add key listener
		this.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					frame.dispose();
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}

			public void keyTyped(KeyEvent e) { 
				
			}
		});
		
		//add everything together. Huzzah!
		this.add(menuPanel);
		this.add(treePanel);
		this.add(editorPanel);
		this.add(inspectPanel);

		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Index();
	}
	
}
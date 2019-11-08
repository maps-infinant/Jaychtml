package com.Jaychtml.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Index extends JFrame {
	
	public Index() {
		//Variable declaration and crap
		JFrame frame = this;
		JPanel treePanel = new JPanel();
		JPanel inspectPanel = new JPanel();
		JPanel editorPanel = new JPanel();
		JPanel menuPanel = new JPanel();
		LayoutManager layout = new SpringLayout();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Functional shit i guess
		menuPanel.add(new JLabel("Menu"));
		menuPanel.setMinimumSize(new Dimension(screenSize.width,screenSize.height/10));
		treePanel.add(new JLabel("Tree"));
		editorPanel.add(new JLabel("Editor"));
		inspectPanel.add(new JLabel("Inspect"));
		
		//fullscreen BITCCHES
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		
		//layout positioning i think
		layout.addLayoutComponent(BorderLayout.NORTH, menuPanel);
		layout.addLayoutComponent(BorderLayout.WEST, treePanel);
		layout.addLayoutComponent(BorderLayout.EAST, editorPanel);
		layout.addLayoutComponent(BorderLayout.SOUTH, inspectPanel);
		
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
		
		this.setLayout(layout);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Index();
	}
	
}
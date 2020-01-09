package com.jaychtml;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

import com.draggables.TextField;

public class Index extends JFrame {
	
	private Point checkPoint;
	private Point prevPoint;
	
	private JFrame frame;
	private JPanel treePanel;
	private JPanel inspectPanel;
	private JPanel editorPanel;
	private JPanel menuPanel;
	private JLayeredPane layeredPane;
	private Dimension screenSize;
	
	public Index() {
		//Variable declaration and crap
		frame = this;
		treePanel = new JPanel();
		inspectPanel = new JPanel();
		editorPanel = new JPanel();
		menuPanel = new JPanel();
		layeredPane = new JLayeredPane();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Functional shit i guess
		menuPanel.add(new JLabel("Menu"));
		treePanel.add(new JLabel("Tree"));
		editorPanel.add(new JLabel("Editor"));
		inspectPanel.add(new JLabel("Inspect"));
		
		//Fullscreen
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setLayout(null);//Get rid of layout to make setBounds work
		
		//sizing and positioning
		menuPanel.setBounds(new Rectangle(0, 0, screenSize.width, screenSize.height/10));
		menuPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		layeredPane.setBounds(new Rectangle(0,screenSize.height/10,screenSize.width,screenSize.height*7/10));
		inspectPanel.setBounds(new Rectangle(0,screenSize.height*8/10,screenSize.width,screenSize.height*2/10));
		inspectPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//Layered Pane layout
		layeredPane.setLayout(createSpringLayout());
		
		//add key listener
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					frame.dispose();
				}
			}
		});
		
		//Add stuff to the editor pane
		treePanel.add(new TextField());
		
		//add everything together. Huzzah!
		this.add(menuPanel);
		layeredPane.add(treePanel);
		layeredPane.add(editorPanel);
		this.add(layeredPane);
		this.add(inspectPanel);
		this.addMouseListener(createFocusManager());

		this.setVisible(true);
		this.requestFocus();
	}
	
	private MouseListener createFocusManager() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				e.getComponent().requestFocusInWindow();
			}
		};
	}

	private SpringLayout createSpringLayout() {
		SpringLayout layout = new SpringLayout();
		treePanel.setPreferredSize(new Dimension(screenSize.width*3/10,screenSize.height*7/10));
		editorPanel.setPreferredSize(new Dimension(screenSize.width*7/10,screenSize.height*7/10));
		layout.putConstraint(SpringLayout.WEST, treePanel, 0, SpringLayout.WEST, layeredPane);
		layout.putConstraint(SpringLayout.EAST, editorPanel, 0, SpringLayout.EAST, layeredPane);
		treePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		editorPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		return layout;
	}

	public static void main(String[] args) {
		new Index();
	}
	
}
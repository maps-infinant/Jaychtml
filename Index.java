package main.Archer.loopy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index extends JFrame {
	
	public Index() {
		//Variable declaration and crap
		JPanel treePanel = new JPanel();
		JPanel inspectPanel = new JPanel();
		JPanel editorPanel = new JPanel();
		JPanel menuPanel = new JPanel();
		LayoutManager layout = new BorderLayout();
		
		//Functional shit i guess
		treePanel.add(new JLabel("Test"));
		inspectPanel.add(new JLabel("Rest"));
		
		//and this is like the JFrame declaration magic
		this.setPreferredSize(new Dimension(640, 480));
		this.setMinimumSize(new Dimension(640, 480));
		this.setLocationRelativeTo(null);
		
		//layout positioning i think
		layout.addLayoutComponent(BorderLayout.WEST, treePanel);
		layout.addLayoutComponent(BorderLayout.SOUTH, inspectPanel);
		
		//add everything together. Huzzah!
		this.add(treePanel);
		this.add(inspectPanel);
		this.setLayout(layout);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Index();
	}
	
}
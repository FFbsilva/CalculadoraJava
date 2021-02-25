package br.com.felipeb.calc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel{

	private final JLabel label; 
	
	public Display() {
		label = new JLabel("Abiguinho");
		setLayout(new BorderLayout());
		setBackground(new Color(46,49,50));
		label.setForeground(Color.white);
		add(label,BorderLayout.EAST);
	}
	
	
	
}

package br.com.felipeb.calc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel{

	private final JLabel label; 
	
	public Display() {
		label = new JLabel("Abiguinho");
		setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
		setBackground(new Color(46,49,50));
		label.setForeground(Color.white);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		add(label);
	}
	
	
	
}

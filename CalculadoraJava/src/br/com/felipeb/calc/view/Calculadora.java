package br.com.felipeb.calc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		
		organizarLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(232,322);
		setLocationRelativeTo(null);
		
	}
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233,60));
		add(display, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		
		new Calculadora();
	}
}

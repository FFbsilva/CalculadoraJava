package br.com.felipeb.calc.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Teclado extends JPanel {

	private final Color COR_CINZA = new Color(68,68,68);
	private final Color COR_LARANJA = new Color(242,163,60);
	private final Color COR_CLARO = new Color(98,98,98);
	
	public Teclado() {
		
		setBackground(Color.BLACK);
		setLayout(new GridLayout(5,4));
		add(new Botao("AC", COR_CINZA));
		add(new Botao("+-", COR_CINZA));
		add(new Botao("%", COR_CINZA));
		add(new Botao("/", COR_LARANJA));
		
		add(new Botao("7", COR_CLARO));
		add(new Botao("8", COR_CLARO));
		add(new Botao("9", COR_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CLARO));
		add(new Botao("8", COR_CLARO));
		add(new Botao("9", COR_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CLARO));
		add(new Botao("8", COR_CLARO));
		add(new Botao("9", COR_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CLARO));
		add(new Botao("8", COR_CLARO));
		add(new Botao("9", COR_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		
	}
	
	
	
}

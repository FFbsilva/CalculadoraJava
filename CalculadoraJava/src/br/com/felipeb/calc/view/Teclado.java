package br.com.felipeb.calc.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Teclado extends JPanel {

	public Teclado() {
		setBackground(Color.BLACK);
	}
	
	List<Botao> botoes = new ArrayList<>();
	
}

package br.com.felipeb.calc.view;

import javax.sql.rowset.RowSetMetaDataImpl;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(232,322);
		
	}
	
	public static void main(String[] args) {
		
		new Calculadora();
	}
}

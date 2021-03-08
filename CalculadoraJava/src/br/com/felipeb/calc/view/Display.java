package br.com.felipeb.calc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Memoria;
import model.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{

	private final JLabel label; 
	
	public Display() {
		Memoria.getInstacia().adicionarObservador(this);
		
		label = new JLabel(Memoria.getInstacia().getTextoAtual());
		setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
		setBackground(new Color(46,49,50));
		label.setForeground(Color.white);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		
		label.setText(novoValor);
	}

	
	
	
}

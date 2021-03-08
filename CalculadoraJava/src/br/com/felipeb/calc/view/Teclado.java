package br.com.felipeb.calc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private final Color COR_CINZA = new Color(68, 68, 68);
	private final Color COR_LARANJA = new Color(242, 163, 60);
	private final Color COR_CLARO = new Color(98, 98, 98);

	public Teclado() {

		setBackground(Color.BLACK);

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constrain = new GridBagConstraints();

		setLayout(layout);
		
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.fill = GridBagConstraints.BOTH;
		
		//Linha 1
		adicionarBotao("AC", COR_CINZA, constrain, 0, 0);
		adicionarBotao("+-", COR_CINZA, constrain, 1, 0);
		adicionarBotao("%", COR_CINZA, constrain,  2, 0);
		adicionarBotao("/", COR_LARANJA, constrain, 3, 0);
		
		//Linha 2
		adicionarBotao("7", COR_CLARO, constrain, 0, 1);
		adicionarBotao("8", COR_CLARO, constrain, 1, 1);
		adicionarBotao("9", COR_CLARO, constrain,  2, 1);
		adicionarBotao("*", COR_LARANJA, constrain, 3, 1);
		
		//Linha 3
		adicionarBotao("6", COR_CLARO, constrain, 0, 2);
		adicionarBotao("5", COR_CLARO, constrain, 1, 2);
		adicionarBotao("4", COR_CLARO, constrain,  2, 2);
		adicionarBotao("-", COR_LARANJA, constrain, 3, 2);
		
		//Linha 4
		adicionarBotao("3", COR_CLARO, constrain, 0, 3);
		adicionarBotao("2", COR_CLARO, constrain, 1, 3);
		adicionarBotao("1", COR_CLARO, constrain,  2, 3);
		adicionarBotao("+", COR_LARANJA, constrain, 3, 3);

		//Linha 5;
		constrain.gridwidth = 2;
		adicionarBotao("0", COR_CLARO, constrain, 0, 4);
		constrain.gridwidth = 1;
		adicionarBotao(",", COR_CLARO, constrain,  2, 4);
		adicionarBotao("=", COR_LARANJA, constrain, 3, 4);
		
	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints constrain, int i, int j) {

		constrain.gridx = i;
		constrain.gridy = j;
		
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao,constrain); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstacia().processarComando(botao.getText());
		}
	}

}

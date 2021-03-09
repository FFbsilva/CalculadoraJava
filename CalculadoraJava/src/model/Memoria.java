package model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando{
		ZERAR, DIV, SOMA, MULT, SUB, VIRGULA,IGUAL,NUMERO;
	};
	
	private static final Memoria instacia = new Memoria();
	
	private List<MemoriaObservador> observadores = new ArrayList<MemoriaObservador>();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoBuffer = "";
	private String textoAtual= "";
	private Memoria() {
		
	}

	public static Memoria getInstacia() {
		return instacia;
	}
	
	public void adicionarObservador(MemoriaObservador o) {
		observadores.add(o);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0": textoAtual;
	}
	
	public void processarComando(String valor) {
		
		TipoComando tipoComando = detectarComando(valor);
		
		if(tipoComando == null) {
			return;
		}else if( tipoComando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;
		} else if( tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituir ? valor : textoAtual + valor;
			substituir = false;
		}else {
			substituir = true;
			textoAtual = obterResultadoOperacao();
			ultimaOperacao = tipoComando;
			textoBuffer = textoAtual;
			
			
		}
		
		
		observadores.forEach(o-> o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		if(ultimaOperacao == null) {
			return textoAtual;
		}
		
		double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
		double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
		
		double resultado = 0;
		
		if(ultimaOperacao == TipoComando.SOMA) {
			
			resultado = numeroBuffer + numeroAtual;
		} else if(ultimaOperacao == TipoComando.SUB) {
			
			resultado = numeroBuffer - numeroAtual;
		}else if(ultimaOperacao == TipoComando.MULT) {
			
			resultado = numeroBuffer * numeroAtual;
		}else if(ultimaOperacao == TipoComando.DIV) {
			
			resultado = numeroBuffer / numeroAtual;
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		
		boolean inteiro = resultadoString.endsWith(",0");
		
		return inteiro? resultadoString.replace(",0", ""): resultadoString;
		
	}

	private TipoComando detectarComando(String valor) {
		
		if(textoAtual.isEmpty() && valor == "0") {
			return null;
		}
		try {
			Integer.parseInt(valor);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			// Quando não for número, os demais casts serão feitos aqui
			if("AC".equals(valor)) {
				return TipoComando.ZERAR;
			}else if("/".equals(valor)) {
				return TipoComando.DIV;
			}else if("*".equals(valor)) {
				return TipoComando.MULT;
			}else if("+".equals(valor)) {
				return TipoComando.SOMA;
			}else if("-".equals(valor)) {
				return TipoComando.SUB;
			}else if("=".equals(valor)) {
				return TipoComando.IGUAL;
			} else if(",".equals(valor) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}
		}
		return null;
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando{
		ZERAR, DIV, SOMA, MULT, SUB, VIRGULA,IGUAL,NUMERO;
	};
	
	private static final Memoria instacia = new Memoria();
	
	private List<MemoriaObservador> observadores = new ArrayList<MemoriaObservador>();
	
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
		textoAtual+= valor;
		observadores.forEach(o-> o.valorAlterado(getTextoAtual()));
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
			} else if(",".equals(valor)) {
				return TipoComando.VIRGULA;
			}
		}
		return null;
	}

}

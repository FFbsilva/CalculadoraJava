package model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

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
		
		textoAtual+= valor;
		observadores.forEach(o-> o.valorAlterado(textoAtual));
	}

}

package model;

public class Memoria {

	private static final Memoria instacia = new Memoria();
	
	private String textoAtual= "";
	private Memoria() {
		
	}

	public static Memoria getInstacia() {
		return instacia;
	}

	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0": textoAtual;
	}


}

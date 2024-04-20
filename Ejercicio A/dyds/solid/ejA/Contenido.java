package dyds.solid.ejA;

public class Contenido {

	String texto;

	public boolean validar() {
		if(texto != null && texto != "") return true;
		else return false;
	}

	public Contenido(String cantidad) {
		this.texto = cantidad;
	}
}

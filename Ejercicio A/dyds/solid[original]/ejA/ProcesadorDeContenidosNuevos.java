package dyds.solid.ejA;

public class ProcesadorDeContenidosNuevos {
	RepositorioDummy repo = new RepositorioDummy();

	public void procesar(Contenido contenidoNuevo) {
		if (contenidoNuevo.validar() && repo.grabar(contenidoNuevo)) {
			ManejadorDeChulogram.getInstance().postearContenido(contenidoNuevo);
		}
	}

	public RepositorioDummy getRepo() { return repo; }
}

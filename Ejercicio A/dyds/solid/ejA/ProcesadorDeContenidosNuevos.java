package dyds.solid.ejA;

public class ProcesadorDeContenidosNuevos {
	RepositorioDummy repo = new RepositorioDummy();

	public void procesar(Contenido contenidoNuevo, ManagerRedSocial redSocial) {
		if (contenidoNuevo.validar() && repo.grabar(contenidoNuevo)) {
			redSocial.postearContenido(contenidoNuevo);
		}
	}

	public RepositorioDummy getRepo() { return repo; }
}


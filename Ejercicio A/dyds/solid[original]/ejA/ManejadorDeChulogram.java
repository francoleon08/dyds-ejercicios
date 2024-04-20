package dyds.solid.ejA;

public class ManejadorDeChulogram {

	private static ManejadorDeChulogram instance;

	private ManejadorDeChulogram() {
	}

	public static ManejadorDeChulogram getInstance() {
		if (instance == null) {
			instance = new ManejadorDeChulogram();
		}
		return instance;
	}

	int cantidadContenidosEnviados = 0;


	public void postearContenido(Contenido contenido) {
		//Codigo dummy para hacer los tests
		cantidadContenidosEnviados++;
	}

	public int getCantidadContenidosEnviados() {
		return cantidadContenidosEnviados;
	}

	public void resetSingleton(){
		//Por ser un singleton tenemos que limpiarlo para el testing
		cantidadContenidosEnviados = 0;
	}
}
